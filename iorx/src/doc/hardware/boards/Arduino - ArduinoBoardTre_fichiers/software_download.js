/*
 *  js for the Donate Page (http://arduino.cc/en/Main/Donate) and Thank You Page (http://arduino.cc/en/Main/Thank You)
 *  last updated: 2015-02-06
 *  Stefania - Ádám
 */

$(function() {

  $('.donate-open-button').on('click', function(event) {
    var donationValue = $(event.target).closest('.donate-open-button').attr('value');
    
    $('#donationModal').find('#donationValue').val(donationValue);

    if(donationValue == '' || !donationValue) {
       $('#donateErrorMsg').hide();
       $('.donate-modal').foundation('reveal', 'open');
    } else {
      $('#stripe-button').click();  
    }
  });

  $('#donationModal').find('#donationValue').on('input propertychange paste', throttle(function (event) {
      var element = $('#donationModal').find('#donationValue');
      var value = element.val();
      var reg = new RegExp('^\\$?[0-9]+\\.?[0-9]?[0-9]?$');
      if(!reg.test(value)){
        element.val("");
      } else {
        if(value.substring(0, 1) !== '$')
          element.val("$"+value);
      }
  }, 1000));

  function throttle(fn, threshhold, scope) {
    threshhold || (threshhold = 250);
    var last,
        deferTimer;
    return function () {
      var context = scope || this;

      var now = +new Date,
          args = arguments;
      if (last && now < last + threshhold) {
        // hold on to it
        clearTimeout(deferTimer);
        deferTimer = setTimeout(function () {
          last = now;
          fn.apply(context, args);
        }, threshhold);
      } else {
        last = now;
        fn.apply(context, args);
      }
    };
  }

  var stripeResponseHandler = function(response) {
      
      var amount = $('#donationValue').val();
      var amountCents = parseFloat(amount.substring(1)).toFixed(2)*100;

      $.ajax({
      type: "POST",
      url: "https://api.arduino.cc/stripe/charge",
      contentType:"application/json; charset=utf-8",
      timeout: 10000,
      data: JSON.stringify({
        token: response.id, 
        amount: amountCents,
        donator: response.card.name,
        email: response.email
      }),
      success: function(data){
        console.log('Payment success')
        //console.log(data);
        //redirect to thank you page
        window.location.replace("/en/Main/ThankYou");
      },
      error: function(x, t, m) {
          if(x.responseJSON) {
            $('#donateErrorMsg').text(JSON.parse(x.responseJSON.error).message + ' Please retry.')
          } else {
            $('#donateErrorMsg').text('Server unavailable, please retry.');
          }           
          
          $('#donateErrorMsg').show();
          $('.donate-modal').foundation('reveal', 'open');
        }
    });

  };

  var stripeCheckoutHandler = StripeCheckout.configure({
      key: 'pk_live_kqUHyHvV7j8teAbjsZ6b6TMs',
      image: '../pub/skins/arduinoWide/img/ArduinoLogo_loop-01.svg', 
      billingAddress:  'true',
      token: stripeResponseHandler
    });

  $('#stripe-button').on('click', function(e) {
      $('#donateErrorMsg').hide();
      var amount = $(e.target).parents().find('#donationValue').val();
      var amount_valid = !(parseInt(amount.substring(1)) === 0 || amount.substring(1) === '' || !amount.substring(1));

      if(amount_valid) {

        $('.donate-modal').foundation('reveal', 'close');
        
        var amountCents = parseFloat(amount.substring(1)).toFixed(2)*100;

        // Open Checkout with further options
        stripeCheckoutHandler.open({
          name: 'Arduino',
          description: amount,
          amount: amountCents
        });
        e.preventDefault();
      } else {
        $('#donateErrorMsg').text('Please enter a valid amount.'); 
        $('#donateErrorMsg').show();
      }

    });

  // Close Checkout on page navigation
  $(window).on('popstate', function() {
      stripeCheckoutHandler.close();
      $('.donate-modal').foundation('reveal', 'close');
    });

  // Update download counter if it exists on page
  if( $('#download_counter').length ) {
    function pad(number) {
      var padArr = ['00000000', '0000000', '000000', '00000', '0000', '000', '00', '0', ''];
      numStr = number.toString();
      if (numStr.length < 8) numStr = padArr[numStr.length] + numStr;
      return numStr;
    }
    $.ajax({
      url : '/download_handler.php?getCount&json'
      ,dataType : 'json'
      ,cache : false
      ,success : function(data) {
        var counter = "SO MANY";
        if ($.isNumeric(data) && data > 0) counter = pad(data);
        else counter = pad(Math.floor((Math.random() * 100000) + 1));
        $('#download_counter').html(counter);
      }
    });
  }

  /* Donate Page scripts */

  var openSocialPopup = function(url, name) {
      var width  = 575,
          height = 400,
          left   = ($(window).width()  - width)  / 2,
          top    = ($(window).height() - height) / 2,
          opts   = 'status=1' +
                   ',width='  + width  +
                   ',height=' + height +
                   ',top='    + top    +
                   ',left='   + left;
      
      window.open(url, name, opts);
   
      return false; 
    }

  $('#thankyou-twitter-button').on('click', function(event) {
    var currentUrl = document.location.origin;
      var url = "https://twitter.com/share?text=I%20supported%20the%20Arduino%20Software%20with%20a%20contribution!%20Check%20out&url="+currentUrl+"/en/Main/Donate";
      openSocialPopup(url, "twitter")  
    });


  $('#thankyou-facebook-button').on('click', function(event) {

    FB.ui({
        method: 'feed',
        link: document.location.origin+'/en/Main/Donate',
        caption: '',
        name: 'Arduino - Contribution',
        display: 'popup',
        description: 'I supported the Arduino Software with a contribution!',
        picture: 'http://arduino.cc/en/pub/skins/arduinoWide/img/Heart-01.png'
      }, function(response){});

  });

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1438254093131479',
      xfbml      : true,
      version    : 'v2.1'
    });
  };

  (function(d, s, id){
       var js, fjs = d.getElementsByTagName(s)[0];
       if (d.getElementById(id)) {return;}
       js = d.createElement(s); js.id = id;
       js.src = "//connect.facebook.net/en_US/sdk.js";
       fjs.parentNode.insertBefore(js, fjs);
     }(document, 'script', 'facebook-jssdk'));

});