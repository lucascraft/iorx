/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.midi.internal.dsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum CONTROLLER_CHANGE_VALUES  {

	UNDEFINED(0, "UNDEFINED", "UNDEFINED"),


	MODULATION_WHEEL(1, "MODULATION_WHEEL", "MODULATION_WHEEL"),


	BREATHE_CONTROLLER(2, "BREATHE_CONTROLLER", "BREATHE_CONTROLLER"),


	FOOT_CONTROLLER(4, "FOOT_CONTROLLER", "FOOT_CONTROLLER"),


	PORTAMENTO_TIME(5, "PORTAMENTO_TIME", "PORTAMENTO_TIME"),


	DATA_ENTRY_SLIDER(6, "DATA_ENTRY_SLIDER", "DATA_ENTRY_SLIDER"),


	MAIN_VOLUME(7, "MAIN_VOLUME", "MAIN_VOLUME"),


	BALANCE(8, "BALANCE", "BALANCE"),


	PAN(10, "PAN", "PAN"),


	EXPRESSION_CONTROLLER(11, "EXPRESSION_CONTROLLER", "EXPRESSION_CONTROLLER"),


	GENERAL_PURPOSES_CONTROLLER_1(16, "GENERAL_PURPOSES_CONTROLLER_1", "GENERAL_PURPOSES_CONTROLLER_1"),


	GENERAL_PURPOSES_CONTROLLER_2(17, "GENERAL_PURPOSES_CONTROLLER_2", "GENERAL_PURPOSES_CONTROLLER_2"),


	GENERAL_PURPOSES_CONTROLLER_3(18, "GENERAL_PURPOSES_CONTROLLER_3", "GENERAL_PURPOSES_CONTROLLER_3"),


	GENERAL_PURPOSES_CONTROLLER_4(19, "GENERAL_PURPOSES_CONTROLLER_4", "GENERAL_PURPOSES_CONTROLLER_4"),


	LSB_FOR_CONTROLLER_32(32, "LSB_FOR_CONTROLLER_32", "LSB_FOR_CONTROLLER_32"),


	LSB_FOR_CONTROLLER_33(33, "LSB_FOR_CONTROLLER_33", "LSB_FOR_CONTROLLER_33"),


	LSB_FOR_CONTROLLER_34(34, "LSB_FOR_CONTROLLER_34", "LSB_FOR_CONTROLLER_34"),


	LSB_FOR_CONTROLLER_35(35, "LSB_FOR_CONTROLLER_35", "LSB_FOR_CONTROLLER_35"),


	LSB_FOR_CONTROLLER_36(36, "LSB_FOR_CONTROLLER_36", "LSB_FOR_CONTROLLER_36"),


	LSB_FOR_CONTROLLER_37(37, "LSB_FOR_CONTROLLER_37", "LSB_FOR_CONTROLLER_37"),


	LSB_FOR_CONTROLLER_38(38, "LSB_FOR_CONTROLLER_38", "LSB_FOR_CONTROLLER_38"),

	
	LSB_FOR_CONTROLLER_39(39, "LSB_FOR_CONTROLLER_39", "LSB_FOR_CONTROLLER_39"),


	LSB_FOR_CONTROLLER_40(40, "LSB_FOR_CONTROLLER_40", "LSB_FOR_CONTROLLER_40"),


	LSB_FOR_CONTROLLER_41(41, "LSB_FOR_CONTROLLER_41", "LSB_FOR_CONTROLLER_41"),

	
	LSB_FOR_CONTROLLER_42(42, "LSB_FOR_CONTROLLER_42", "LSB_FOR_CONTROLLER_42"),

	
	LSB_FOR_CONTROLLER_43(43, "LSB_FOR_CONTROLLER_43", "LSB_FOR_CONTROLLER_43"),

	
	LSB_FOR_CONTROLLER_44(44, "LSB_FOR_CONTROLLER_44", "LSB_FOR_CONTROLLER_44"),

	
	LSB_FOR_CONTROLLER_45(45, "LSB_FOR_CONTROLLER_45", "LSB_FOR_CONTROLLER_45"),

	
	LSB_FOR_CONTROLLER_46(46, "LSB_FOR_CONTROLLER_46", "LSB_FOR_CONTROLLER_46"),

	
	LSB_FOR_CONTROLLER_47(47, "LSB_FOR_CONTROLLER_47", "LSB_FOR_CONTROLLER_47"),

	
	LSB_FOR_CONTROLLER_48(48, "LSB_FOR_CONTROLLER_48", "LSB_FOR_CONTROLLER_48"),

	
	LSB_FOR_CONTROLLER_49(49, "LSB_FOR_CONTROLLER_49", "LSB_FOR_CONTROLLER_49"),

	
	LSB_FOR_CONTROLLER_50(50, "LSB_FOR_CONTROLLER_50", "LSB_FOR_CONTROLLER_50"),

	
	LSB_FOR_CONTROLLER_51(51, "LSB_FOR_CONTROLLER_51", "LSB_FOR_CONTROLLER_51"),

	
	LSB_FOR_CONTROLLER_52(52, "LSB_FOR_CONTROLLER_52", "LSB_FOR_CONTROLLER_52"),

	
	LSB_FOR_CONTROLLER_53(53, "LSB_FOR_CONTROLLER_53", "LSB_FOR_CONTROLLER_53"),


	LSB_FOR_CONTROLLER_54(54, "LSB_FOR_CONTROLLER_54", "LSB_FOR_CONTROLLER_54"),


	LSB_FOR_CONTROLLER_55(55, "LSB_FOR_CONTROLLER_55", "LSB_FOR_CONTROLLER_55"),


	LSB_FOR_CONTROLLER_56(56, "LSB_FOR_CONTROLLER_56", "LSB_FOR_CONTROLLER_56"),


	LSB_FOR_CONTROLLER_57(57, "LSB_FOR_CONTROLLER_57", "LSB_FOR_CONTROLLER_57"),


	LSB_FOR_CONTROLLER_58(58, "LSB_FOR_CONTROLLER_58", "LSB_FOR_CONTROLLER_58"),


	LSB_FOR_CONTROLLER_59(59, "LSB_FOR_CONTROLLER_59", "LSB_FOR_CONTROLLER_59"),

	
	LSB_FOR_CONTROLLER_60(60, "LSB_FOR_CONTROLLER_60", "LSB_FOR_CONTROLLER_60"),


	LSB_FOR_CONTROLLER_61(61, "LSB_FOR_CONTROLLER_61", "LSB_FOR_CONTROLLER_61"),


	LSB_FOR_CONTROLLER_62(62, "LSB_FOR_CONTROLLER_62", "LSB_FOR_CONTROLLER_62"), 


	DAMPER_PEDAL(64, "DAMPER_PEDAL", "DAMPER_PEDAL"), 


	LSB_FOR_CONTROLLER_63(63, "LSB_FOR_CONTROLLER_63", "LSB_FOR_CONTROLLER_63"), 
	

	PORTAMENTO(65, "PORTAMENTO", "PORTAMENTO"), /**
	 * The '<em><b>SOSTENUTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOSTENUTO_VALUE
	 * @generated
	 * @ordered
	 */
	SOSTENUTO(66, "SOSTENUTO", "SOSTENUTO"), /**
	 * The '<em><b>SOFT PEDAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFT_PEDAL_VALUE
	 * @generated
	 * @ordered
	 */
	SOFT_PEDAL(67, "SOFT_PEDAL", "SOFT_PEDAL"), /**
	 * The '<em><b>HOLD 2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOLD_2_VALUE
	 * @generated
	 * @ordered
	 */
	HOLD_2(69, "HOLD_2", "HOLD_2"), /**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 5</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_5_VALUE
	 * @generated
	 * @ordered
	 */
	GENERAL_PURPOSES_CONTROLLER_5(80, "GENERAL_PURPOSES_CONTROLLER_5", "GENERAL_PURPOSES_CONTROLLER_5"), /**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 6</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_6_VALUE
	 * @generated
	 * @ordered
	 */
	GENERAL_PURPOSES_CONTROLLER_6(81, "GENERAL_PURPOSES_CONTROLLER_6", "GENERAL_PURPOSES_CONTROLLER_6"), /**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 7</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_7_VALUE
	 * @generated
	 * @ordered
	 */
	GENERAL_PURPOSES_CONTROLLER_7(82, "GENERAL_PURPOSES_CONTROLLER_7", "GENERAL_PURPOSES_CONTROLLER_7"), /**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_8_VALUE
	 * @generated
	 * @ordered
	 */
	GENERAL_PURPOSES_CONTROLLER_8(83, "GENERAL_PURPOSES_CONTROLLER_8", "GENERAL_PURPOSES_CONTROLLER_8"), /**
	 * The '<em><b>TREMOLO DEPTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TREMOLO_DEPTH_VALUE
	 * @generated
	 * @ordered
	 */
	TREMOLO_DEPTH(92, "TREMOLO_DEPTH", "TREMOLO_DEPTH"), /**
	 * The '<em><b>CHORUS DEPTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHORUS_DEPTH_VALUE
	 * @generated
	 * @ordered
	 */
	CHORUS_DEPTH(93, "CHORUS_DEPTH", "CHORUS_DEPTH"), /**
	 * The '<em><b>CELESTE DETUNE DEPTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CELESTE_DETUNE_DEPTH_VALUE
	 * @generated
	 * @ordered
	 */
	CELESTE_DETUNE_DEPTH(94, "CELESTE_DETUNE_DEPTH", "CELESTE_DETUNE_DEPTH"), /**
	 * The '<em><b>PHASER DEPTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHASER_DEPTH_VALUE
	 * @generated
	 * @ordered
	 */
	PHASER_DEPTH(95, "PHASER_DEPTH", "PHASER_DEPTH"), /**
	 * The '<em><b>DATA INCREMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_INCREMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_INCREMENT(96, "DATA_INCREMENT", "DATA_INCREMENT"), /**
	 * The '<em><b>DATA DECREMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_DECREMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_DECREMENT(97, "DATA_DECREMENT", "DATA_DECREMENT"), /**
	 * The '<em><b>NON REGISTERED PARAMETER NUMBER LSB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_REGISTERED_PARAMETER_NUMBER_LSB_VALUE
	 * @generated
	 * @ordered
	 */
	NON_REGISTERED_PARAMETER_NUMBER_LSB(98, "NON_REGISTERED_PARAMETER_NUMBER_LSB", "NON_REGISTERED_PARAMETER_NUMBER_LSB"), /**
	 * The '<em><b>NON REGISTERED PARAMETER NUMBER MSB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_REGISTERED_PARAMETER_NUMBER_MSB_VALUE
	 * @generated
	 * @ordered
	 */
	NON_REGISTERED_PARAMETER_NUMBER_MSB(99, "NON_REGISTERED_PARAMETER_NUMBER_MSB", "NON_REGISTERED_PARAMETER_NUMBER_MSB"), /**
	 * The '<em><b>REGISTERED PARAMETER NUMBER LSB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERED_PARAMETER_NUMBER_LSB_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTERED_PARAMETER_NUMBER_LSB(100, "REGISTERED_PARAMETER_NUMBER_LSB", "REGISTERED_PARAMETER_NUMBER_LSB"), /**
	 * The '<em><b>REGISTERED PARAMETER NUMBER MSB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTERED_PARAMETER_NUMBER_MSB_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTERED_PARAMETER_NUMBER_MSB(101, "REGISTERED_PARAMETER_NUMBER_MSB", "REGISTERED_PARAMETER_NUMBER_MSB"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 0</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_0_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_0(122, "CHANNEL_MODE_MESSAGE_0", "CHANNEL_MODE_MESSAGE_0"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_1_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_1(123, "CHANNEL_MODE_MESSAGE_1", "CHANNEL_MODE_MESSAGE_1"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_2_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_2(124, "CHANNEL_MODE_MESSAGE_2", "CHANNEL_MODE_MESSAGE_2"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_3_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_3(125, "CHANNEL_MODE_MESSAGE_3", "CHANNEL_MODE_MESSAGE_3"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_4_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_4(126, "CHANNEL_MODE_MESSAGE_4", "CHANNEL_MODE_MESSAGE_4"), /**
	 * The '<em><b>CHANNEL MODE MESSAGE 5</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_5_VALUE
	 * @generated
	 * @ordered
	 */
	CHANNEL_MODE_MESSAGE_5(127, "CHANNEL_MODE_MESSAGE_5", "CHANNEL_MODE_MESSAGE_5");

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>MODULATION WHEEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULATION WHEEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULATION_WHEEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULATION_WHEEL_VALUE = 1;

	/**
	 * The '<em><b>BREATHE CONTROLLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BREATHE CONTROLLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREATHE_CONTROLLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BREATHE_CONTROLLER_VALUE = 2;

	/**
	 * The '<em><b>FOOT CONTROLLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOOT CONTROLLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOOT_CONTROLLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOOT_CONTROLLER_VALUE = 4;

	/**
	 * The '<em><b>PORTAMENTO TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PORTAMENTO TIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORTAMENTO_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PORTAMENTO_TIME_VALUE = 5;

	/**
	 * The '<em><b>DATA ENTRY SLIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA ENTRY SLIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_ENTRY_SLIDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_ENTRY_SLIDER_VALUE = 6;

	/**
	 * The '<em><b>MAIN VOLUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAIN VOLUME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAIN_VOLUME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAIN_VOLUME_VALUE = 7;

	/**
	 * The '<em><b>BALANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BALANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BALANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BALANCE_VALUE = 8;

	/**
	 * The '<em><b>PAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PAN_VALUE = 10;

	/**
	 * The '<em><b>EXPRESSION CONTROLLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPRESSION CONTROLLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPRESSION_CONTROLLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_CONTROLLER_VALUE = 11;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_1_VALUE = 16;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_2_VALUE = 17;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_3
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_3_VALUE = 18;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_4
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_4_VALUE = 19;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_32_VALUE = 32;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 33</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 33</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_33
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_33_VALUE = 33;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 34</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 34</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_34
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_34_VALUE = 34;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 35</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 35</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_35
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_35_VALUE = 35;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 36</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 36</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_36
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_36_VALUE = 36;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 37</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 37</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_37
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_37_VALUE = 37;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 38</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 38</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_38
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_38_VALUE = 38;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 39</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 39</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_39
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_39_VALUE = 39;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 40</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 40</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_40
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_40_VALUE = 40;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 41</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 41</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_41
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_41_VALUE = 41;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 42</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 42</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_42
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_42_VALUE = 42;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 43</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 43</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_43
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_43_VALUE = 43;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 44</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 44</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_44
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_44_VALUE = 44;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 45</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 45</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_45
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_45_VALUE = 45;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 46</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 46</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_46
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_46_VALUE = 46;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 47</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 47</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_47
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_47_VALUE = 47;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 48</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 48</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_48
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_48_VALUE = 48;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 49</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 49</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_49
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_49_VALUE = 49;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 50</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 50</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_50
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_50_VALUE = 50;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 51</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 51</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_51
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_51_VALUE = 51;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 52</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 52</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_52
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_52_VALUE = 52;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 53</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 53</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_53
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_53_VALUE = 53;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 54</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 54</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_54
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_54_VALUE = 54;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 55</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 55</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_55
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_55_VALUE = 55;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 56</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 56</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_56
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_56_VALUE = 56;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 57</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 57</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_57
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_57_VALUE = 57;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 58</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 58</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_58
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_58_VALUE = 58;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 59</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 59</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_59
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_59_VALUE = 59;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 60</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 60</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_60
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_60_VALUE = 60;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 61</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 61</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_61
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_61_VALUE = 61;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 62</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 62</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_62
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_62_VALUE = 62;

	/**
	 * The '<em><b>DAMPER PEDAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DAMPER PEDAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DAMPER_PEDAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DAMPER_PEDAL_VALUE = 64;

	/**
	 * The '<em><b>LSB FOR CONTROLLER 63</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LSB FOR CONTROLLER 63</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSB_FOR_CONTROLLER_63
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LSB_FOR_CONTROLLER_63_VALUE = 63;

	/**
	 * The '<em><b>PORTAMENTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PORTAMENTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORTAMENTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PORTAMENTO_VALUE = 65;

	/**
	 * The '<em><b>SOSTENUTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOSTENUTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOSTENUTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOSTENUTO_VALUE = 66;

	/**
	 * The '<em><b>SOFT PEDAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOFT PEDAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFT_PEDAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOFT_PEDAL_VALUE = 67;

	/**
	 * The '<em><b>HOLD 2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HOLD 2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOLD_2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOLD_2_VALUE = 69;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 5</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 5</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_5
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_5_VALUE = 80;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 6</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 6</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_6
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_6_VALUE = 81;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 7</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 7</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_7
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_7_VALUE = 82;

	/**
	 * The '<em><b>GENERAL PURPOSES CONTROLLER 8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERAL PURPOSES CONTROLLER 8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERAL_PURPOSES_CONTROLLER_8
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_PURPOSES_CONTROLLER_8_VALUE = 83;

	/**
	 * The '<em><b>TREMOLO DEPTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TREMOLO DEPTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TREMOLO_DEPTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TREMOLO_DEPTH_VALUE = 92;

	/**
	 * The '<em><b>CHORUS DEPTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHORUS DEPTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHORUS_DEPTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHORUS_DEPTH_VALUE = 93;

	/**
	 * The '<em><b>CELESTE DETUNE DEPTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CELESTE DETUNE DEPTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CELESTE_DETUNE_DEPTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CELESTE_DETUNE_DEPTH_VALUE = 94;

	/**
	 * The '<em><b>PHASER DEPTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHASER DEPTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHASER_DEPTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHASER_DEPTH_VALUE = 95;

	/**
	 * The '<em><b>DATA INCREMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA INCREMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_INCREMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_INCREMENT_VALUE = 96;

	/**
	 * The '<em><b>DATA DECREMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA DECREMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_DECREMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_DECREMENT_VALUE = 97;

	/**
	 * The '<em><b>NON REGISTERED PARAMETER NUMBER LSB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NON REGISTERED PARAMETER NUMBER LSB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_REGISTERED_PARAMETER_NUMBER_LSB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_REGISTERED_PARAMETER_NUMBER_LSB_VALUE = 98;

	/**
	 * The '<em><b>NON REGISTERED PARAMETER NUMBER MSB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NON REGISTERED PARAMETER NUMBER MSB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_REGISTERED_PARAMETER_NUMBER_MSB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_REGISTERED_PARAMETER_NUMBER_MSB_VALUE = 99;

	/**
	 * The '<em><b>REGISTERED PARAMETER NUMBER LSB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGISTERED PARAMETER NUMBER LSB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGISTERED_PARAMETER_NUMBER_LSB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGISTERED_PARAMETER_NUMBER_LSB_VALUE = 100;

	/**
	 * The '<em><b>REGISTERED PARAMETER NUMBER MSB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGISTERED PARAMETER NUMBER MSB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGISTERED_PARAMETER_NUMBER_MSB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGISTERED_PARAMETER_NUMBER_MSB_VALUE = 101;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 0</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 0</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_0
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_0_VALUE = 122;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_1
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_1_VALUE = 123;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_2_VALUE = 124;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_3
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_3_VALUE = 125;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_4
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_4_VALUE = 126;

	/**
	 * The '<em><b>CHANNEL MODE MESSAGE 5</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANNEL MODE MESSAGE 5</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANNEL_MODE_MESSAGE_5
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANNEL_MODE_MESSAGE_5_VALUE = 127;

	/**
	 * An array of all the '<em><b>CONTROLLER CHANGE VALUES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CONTROLLER_CHANGE_VALUES[] VALUES_ARRAY =
		new CONTROLLER_CHANGE_VALUES[] {
			UNDEFINED,
			MODULATION_WHEEL,
			BREATHE_CONTROLLER,
			FOOT_CONTROLLER,
			PORTAMENTO_TIME,
			DATA_ENTRY_SLIDER,
			MAIN_VOLUME,
			BALANCE,
			PAN,
			EXPRESSION_CONTROLLER,
			GENERAL_PURPOSES_CONTROLLER_1,
			GENERAL_PURPOSES_CONTROLLER_2,
			GENERAL_PURPOSES_CONTROLLER_3,
			GENERAL_PURPOSES_CONTROLLER_4,
			LSB_FOR_CONTROLLER_32,
			LSB_FOR_CONTROLLER_33,
			LSB_FOR_CONTROLLER_34,
			LSB_FOR_CONTROLLER_35,
			LSB_FOR_CONTROLLER_36,
			LSB_FOR_CONTROLLER_37,
			LSB_FOR_CONTROLLER_38,
			LSB_FOR_CONTROLLER_39,
			LSB_FOR_CONTROLLER_40,
			LSB_FOR_CONTROLLER_41,
			LSB_FOR_CONTROLLER_42,
			LSB_FOR_CONTROLLER_43,
			LSB_FOR_CONTROLLER_44,
			LSB_FOR_CONTROLLER_45,
			LSB_FOR_CONTROLLER_46,
			LSB_FOR_CONTROLLER_47,
			LSB_FOR_CONTROLLER_48,
			LSB_FOR_CONTROLLER_49,
			LSB_FOR_CONTROLLER_50,
			LSB_FOR_CONTROLLER_51,
			LSB_FOR_CONTROLLER_52,
			LSB_FOR_CONTROLLER_53,
			LSB_FOR_CONTROLLER_54,
			LSB_FOR_CONTROLLER_55,
			LSB_FOR_CONTROLLER_56,
			LSB_FOR_CONTROLLER_57,
			LSB_FOR_CONTROLLER_58,
			LSB_FOR_CONTROLLER_59,
			LSB_FOR_CONTROLLER_60,
			LSB_FOR_CONTROLLER_61,
			LSB_FOR_CONTROLLER_62,
			DAMPER_PEDAL,
			LSB_FOR_CONTROLLER_63,
			PORTAMENTO,
			SOSTENUTO,
			SOFT_PEDAL,
			HOLD_2,
			GENERAL_PURPOSES_CONTROLLER_5,
			GENERAL_PURPOSES_CONTROLLER_6,
			GENERAL_PURPOSES_CONTROLLER_7,
			GENERAL_PURPOSES_CONTROLLER_8,
			TREMOLO_DEPTH,
			CHORUS_DEPTH,
			CELESTE_DETUNE_DEPTH,
			PHASER_DEPTH,
			DATA_INCREMENT,
			DATA_DECREMENT,
			NON_REGISTERED_PARAMETER_NUMBER_LSB,
			NON_REGISTERED_PARAMETER_NUMBER_MSB,
			REGISTERED_PARAMETER_NUMBER_LSB,
			REGISTERED_PARAMETER_NUMBER_MSB,
			CHANNEL_MODE_MESSAGE_0,
			CHANNEL_MODE_MESSAGE_1,
			CHANNEL_MODE_MESSAGE_2,
			CHANNEL_MODE_MESSAGE_3,
			CHANNEL_MODE_MESSAGE_4,
			CHANNEL_MODE_MESSAGE_5,
		};

	/**
	 * A public read-only list of all the '<em><b>CONTROLLER CHANGE VALUES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CONTROLLER_CHANGE_VALUES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CONTROLLER CHANGE VALUES</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CONTROLLER_CHANGE_VALUES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CONTROLLER_CHANGE_VALUES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CONTROLLER CHANGE VALUES</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CONTROLLER_CHANGE_VALUES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CONTROLLER_CHANGE_VALUES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CONTROLLER CHANGE VALUES</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CONTROLLER_CHANGE_VALUES get(int value) {
		switch (value) {
			case UNDEFINED_VALUE: return UNDEFINED;
			case MODULATION_WHEEL_VALUE: return MODULATION_WHEEL;
			case BREATHE_CONTROLLER_VALUE: return BREATHE_CONTROLLER;
			case FOOT_CONTROLLER_VALUE: return FOOT_CONTROLLER;
			case PORTAMENTO_TIME_VALUE: return PORTAMENTO_TIME;
			case DATA_ENTRY_SLIDER_VALUE: return DATA_ENTRY_SLIDER;
			case MAIN_VOLUME_VALUE: return MAIN_VOLUME;
			case BALANCE_VALUE: return BALANCE;
			case PAN_VALUE: return PAN;
			case EXPRESSION_CONTROLLER_VALUE: return EXPRESSION_CONTROLLER;
			case GENERAL_PURPOSES_CONTROLLER_1_VALUE: return GENERAL_PURPOSES_CONTROLLER_1;
			case GENERAL_PURPOSES_CONTROLLER_2_VALUE: return GENERAL_PURPOSES_CONTROLLER_2;
			case GENERAL_PURPOSES_CONTROLLER_3_VALUE: return GENERAL_PURPOSES_CONTROLLER_3;
			case GENERAL_PURPOSES_CONTROLLER_4_VALUE: return GENERAL_PURPOSES_CONTROLLER_4;
			case LSB_FOR_CONTROLLER_32_VALUE: return LSB_FOR_CONTROLLER_32;
			case LSB_FOR_CONTROLLER_33_VALUE: return LSB_FOR_CONTROLLER_33;
			case LSB_FOR_CONTROLLER_34_VALUE: return LSB_FOR_CONTROLLER_34;
			case LSB_FOR_CONTROLLER_35_VALUE: return LSB_FOR_CONTROLLER_35;
			case LSB_FOR_CONTROLLER_36_VALUE: return LSB_FOR_CONTROLLER_36;
			case LSB_FOR_CONTROLLER_37_VALUE: return LSB_FOR_CONTROLLER_37;
			case LSB_FOR_CONTROLLER_38_VALUE: return LSB_FOR_CONTROLLER_38;
			case LSB_FOR_CONTROLLER_39_VALUE: return LSB_FOR_CONTROLLER_39;
			case LSB_FOR_CONTROLLER_40_VALUE: return LSB_FOR_CONTROLLER_40;
			case LSB_FOR_CONTROLLER_41_VALUE: return LSB_FOR_CONTROLLER_41;
			case LSB_FOR_CONTROLLER_42_VALUE: return LSB_FOR_CONTROLLER_42;
			case LSB_FOR_CONTROLLER_43_VALUE: return LSB_FOR_CONTROLLER_43;
			case LSB_FOR_CONTROLLER_44_VALUE: return LSB_FOR_CONTROLLER_44;
			case LSB_FOR_CONTROLLER_45_VALUE: return LSB_FOR_CONTROLLER_45;
			case LSB_FOR_CONTROLLER_46_VALUE: return LSB_FOR_CONTROLLER_46;
			case LSB_FOR_CONTROLLER_47_VALUE: return LSB_FOR_CONTROLLER_47;
			case LSB_FOR_CONTROLLER_48_VALUE: return LSB_FOR_CONTROLLER_48;
			case LSB_FOR_CONTROLLER_49_VALUE: return LSB_FOR_CONTROLLER_49;
			case LSB_FOR_CONTROLLER_50_VALUE: return LSB_FOR_CONTROLLER_50;
			case LSB_FOR_CONTROLLER_51_VALUE: return LSB_FOR_CONTROLLER_51;
			case LSB_FOR_CONTROLLER_52_VALUE: return LSB_FOR_CONTROLLER_52;
			case LSB_FOR_CONTROLLER_53_VALUE: return LSB_FOR_CONTROLLER_53;
			case LSB_FOR_CONTROLLER_54_VALUE: return LSB_FOR_CONTROLLER_54;
			case LSB_FOR_CONTROLLER_55_VALUE: return LSB_FOR_CONTROLLER_55;
			case LSB_FOR_CONTROLLER_56_VALUE: return LSB_FOR_CONTROLLER_56;
			case LSB_FOR_CONTROLLER_57_VALUE: return LSB_FOR_CONTROLLER_57;
			case LSB_FOR_CONTROLLER_58_VALUE: return LSB_FOR_CONTROLLER_58;
			case LSB_FOR_CONTROLLER_59_VALUE: return LSB_FOR_CONTROLLER_59;
			case LSB_FOR_CONTROLLER_60_VALUE: return LSB_FOR_CONTROLLER_60;
			case LSB_FOR_CONTROLLER_61_VALUE: return LSB_FOR_CONTROLLER_61;
			case LSB_FOR_CONTROLLER_62_VALUE: return LSB_FOR_CONTROLLER_62;
			case DAMPER_PEDAL_VALUE: return DAMPER_PEDAL;
			case LSB_FOR_CONTROLLER_63_VALUE: return LSB_FOR_CONTROLLER_63;
			case PORTAMENTO_VALUE: return PORTAMENTO;
			case SOSTENUTO_VALUE: return SOSTENUTO;
			case SOFT_PEDAL_VALUE: return SOFT_PEDAL;
			case HOLD_2_VALUE: return HOLD_2;
			case GENERAL_PURPOSES_CONTROLLER_5_VALUE: return GENERAL_PURPOSES_CONTROLLER_5;
			case GENERAL_PURPOSES_CONTROLLER_6_VALUE: return GENERAL_PURPOSES_CONTROLLER_6;
			case GENERAL_PURPOSES_CONTROLLER_7_VALUE: return GENERAL_PURPOSES_CONTROLLER_7;
			case GENERAL_PURPOSES_CONTROLLER_8_VALUE: return GENERAL_PURPOSES_CONTROLLER_8;
			case TREMOLO_DEPTH_VALUE: return TREMOLO_DEPTH;
			case CHORUS_DEPTH_VALUE: return CHORUS_DEPTH;
			case CELESTE_DETUNE_DEPTH_VALUE: return CELESTE_DETUNE_DEPTH;
			case PHASER_DEPTH_VALUE: return PHASER_DEPTH;
			case DATA_INCREMENT_VALUE: return DATA_INCREMENT;
			case DATA_DECREMENT_VALUE: return DATA_DECREMENT;
			case NON_REGISTERED_PARAMETER_NUMBER_LSB_VALUE: return NON_REGISTERED_PARAMETER_NUMBER_LSB;
			case NON_REGISTERED_PARAMETER_NUMBER_MSB_VALUE: return NON_REGISTERED_PARAMETER_NUMBER_MSB;
			case REGISTERED_PARAMETER_NUMBER_LSB_VALUE: return REGISTERED_PARAMETER_NUMBER_LSB;
			case REGISTERED_PARAMETER_NUMBER_MSB_VALUE: return REGISTERED_PARAMETER_NUMBER_MSB;
			case CHANNEL_MODE_MESSAGE_0_VALUE: return CHANNEL_MODE_MESSAGE_0;
			case CHANNEL_MODE_MESSAGE_1_VALUE: return CHANNEL_MODE_MESSAGE_1;
			case CHANNEL_MODE_MESSAGE_2_VALUE: return CHANNEL_MODE_MESSAGE_2;
			case CHANNEL_MODE_MESSAGE_3_VALUE: return CHANNEL_MODE_MESSAGE_3;
			case CHANNEL_MODE_MESSAGE_4_VALUE: return CHANNEL_MODE_MESSAGE_4;
			case CHANNEL_MODE_MESSAGE_5_VALUE: return CHANNEL_MODE_MESSAGE_5;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CONTROLLER_CHANGE_VALUES(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CONTROLLER_CHANGE_VALUES
