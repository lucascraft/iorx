package ubiquisense.iorx.ui.fmurf;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;
import ubiquisense.iorx.ui.fmurf.enums.SmurfAspect;
import ubiquisense.iorx.ui.fmurf.enums.SmurfFunction;

public class SmurfCfg 
{
	Map<String, Color> colors;
	Map<Float, SmurfDetails > details;
	int oscSendPort, oscReceivePort, tuioPort;
	String oscSendAddress;
	SmurfCfg() {
		initColors();
		initSettings();
	}

	void initColors() {
		colors = new HashMap<String, Color>();
//
//		colors["Aquamarine"]=Color( 0x70, 0xDB, 0x93);
//		colors["Baker's Chocolate"]=Color( 0x5C, 0x33, 0x17);
//		colors["Black"]=Color( 0x00, 0x00, 0x00);
//		colors["Blue"]=Color( 0x00, 0x00, 0xFF);
//		colors["Brass"]=Color( 0xB5, 0xA6, 0x42);
//		colors["Bright Gold"]=Color( 0xD9, 0xD9, 0x19);
//		colors["Brown"]=Color( 0xA6, 0x2A, 0x2A);
//		colors["Bronze"]=Color( 0x8C, 0x78, 0x53);
//		colors["Gold"]=Color( 0xCD, 0x7F, 0x32);
//		colors["Grey"]=Color( 0xC0, 0xC0, 0xC0);
//		colors["Green"]=Color( 0x00, 0xFF, 0x00);
//		colors["Copper"]=Color( 0xB8, 0x73, 0x33);
//		colors["Coral"]=Color( 0xFF, 0x7F, 0x00);
//		colors["Cyan"]=Color( 0x00, 0xFF, 0xFF);
//		colors["Dark Green"]=Color( 0x2F, 0x4F, 0x2F);
//		colors["Green Yellow"]=Color( 0x93, 0xDB, 0x70);
//		colors["Magenta"]=Color(0xFF, 0x00, 0xFF);
//		colors["Maroon"]=Color( 0x8E, 0x23, 0x6B);
//		colors["Medium Blue"]=Color( 0x32, 0x32, 0xCD);
//		colors["Sienna"]=Color( 0x8E, 0x6B, 0x23);
//		colors["Silver"]=Color( 0xE6, 0xE8, 0xFA);
//		colors["Salmon"]=Color( 0x6F, 0x42, 0x42);
//		colors["Orange"]=Color( 0xFF, 0x7F, 0x00);
//		colors["Pink"]=Color( 0xBC, 0x8F, 0x8F);
//		colors["Red"]=Color( 0xFF, 0x00, 0x00);
//		colors["Summer Sky"]=Color( 0x5C, 0x33, 0x17);
//		colors["Tan"]=Color( 0xDB, 0x93, 0x70);
//		colors["Thistle"]=Color( 0xD8, 0xBF, 0xD8);
//		colors["Turquoise"]=Color( 0xAD, 0xEA, 0xEA);
//		colors["Very Dark Brown"]=Color( 0x5C, 0x40, 0x33);
//		colors["Very Light Grey"]=Color( 0xCD, 0xCD, 0xCD);
//		colors["Violet"]=Color( 0x4F, 0x2F, 0x4F);
//		colors["Violet Red"]=Color( 0xCC, 0x32, 0x99);
//		colors["Wheat"]=Color( 0xD8, 0xD8, 0xBF);
//		colors["White"]=Color( 0xFF, 0xFF, 0xFF);
//		colors["Yellow"]=Color( 0xFF, 0xFF, 0x00);
//		colors["Yellow Green"]=Color( 0x99, 0xCC, 0x32);
//		colors["Dark Yellow"]=Color( 0x99, 0xCC, 0x32);
//		colors["Bronze II"]=Color( 0xA6, 0x7D, 0x3D);
//		colors["Cadet Blue"]=Color( 0x5F, 0x9F, 0x9F);
//	    colors["Cool Copper"]=Color( 0xD9, 0x87, 0x19);
//		colors["Corn Flower Blue"]=Color( 0x42, 0x42, 0x6F);
//		colors["Dark Brown"]=Color( 0x5C, 0x40, 0x33);
//		colors["Dark Green Copper"]=Color( 0x4A, 0x76, 0x6E);
//		colors["Dark Olive Green"]=Color( 0x4F, 0x4F, 0x2F);
//		colors["Dark Orchid"]=Color( 0x99, 0x32, 0xCD);
//		colors["Dark Purple"]=Color( 0x87, 0x1F, 0x78);
//		colors["Dark Slate Blue"]=Color(0x6B, 0x23, 0x8E);
//		colors["Dark Slate Grey"]=Color( 0x2F, 0x4F, 0x4F);
//		colors["Dark Tan"]=Color(0x97, 0x69, 0x4F);
//		colors["Dark Turquoise"]=Color( 0x70, 0x93, 0xDB);
//		colors["Dark Wood"]=Color(0x85, 0x5E, 0x42);
//		colors["Dim Grey"]=Color( 0x54, 0x54, 0x54);
//		colors["Dusty Rose"]=Color( 0x85, 0x63, 0x63);
//		colors["Feldspar"]=Color( 0xD1, 0x92, 0x75);
//		colors["Firebrick"]=Color( 0x8E, 0x23, 0x23);
//		colors["Forest Green"]=Color(  0x23, 0x8E, 0x23);
//		colors["Goldenrod"]=Color( 0xDB, 0xDB, 0x70);
//		colors["Green Copper"]=Color( 0x52, 0x7F, 0x76);
//		colors["Hunter Green"]=Color( 0x21, 0x5E, 0x21);
//		colors["Indian Red"]=Color( 0x4E, 0x2F, 0x2F);
//		colors["Khaki"]=Color( 0x9F, 0x9F, 0x5F);
//		colors["Light Blue"]=Color( 0xC0, 0xD9, 0xD9);
//		colors["Light Grey"]=Color( 0xA8, 0xA8, 0xA8);
//		colors["Light Steel Blue"]=Color( 0x8F, 0x8F, 0xBD);
//		colors["Light Wood"]=Color( 0xE9, 0xC2, 0xA6);
//		colors["Lime Green"]=Color( 0x5C, 0x33, 0x17);
//		colors["Mandarian Orange"]=Color( 0xE4, 0x78, 0x33);
//		colors["Medium Aquamarine"]=Color( 0x5C, 0x33, 0x17);
//		colors["Medium Forest Green"]=Color( 0x6B, 0x8E, 0x23);
//		colors["Medium Goldenrod"]=Color( 0xEA, 0xEA, 0xAE);
//		colors["Medium Orchid"]=Color( 0x93, 0x70, 0xDB);
//		colors["Medium Sea Green"]=Color( 0x42, 0x6F, 0x42);
//		colors["Medium Slate Blue"]=Color(0x7F, 0x00, 0xFF);
//		colors["Medium Spring Green"]=Color(0x7F, 0xFF, 0x00);
//		colors["Medium Turquoise"]=Color( 0x70, 0xDB, 0xDB);
//		colors["Medium Violet Red"]=Color( 0xDB, 0x70, 0x93);
//		colors["Medium Wood"]=Color( 0xA6, 0x80, 0x64);
//		colors["Midnight Blue"]=Color( 0x2F, 0x2F, 0x4F);
//		colors["Navy Blue"]=Color( 0x23, 0x23, 0x8E);
//		colors["Neon Blue"]=Color( 0x4D, 0x4D, 0xFF);
//		colors["Neon Pink"]=Color( 0xFF, 0x6E, 0xC7);
//		colors["New Midnight Blue"]=Color( 0x00, 0x00, 0x9C);
//		colors["New Tan"]=Color( 0xEB, 0xC7, 0x9E);
//		colors["Old Gold"]=Color( 0xCF, 0xB5, 0x3B);
//		colors["Orange Red"]=Color( 0xFF, 0x24, 0x00);
//		colors["Orchid"]=Color( 0xDB, 0x70, 0xDB);
//		colors["Pale Green"]=Color( 0x8F, 0xBC, 0x8F);
//		colors["Plum"]=Color( 0xEA, 0xAD, 0xEA);
//		colors["Quartz"]=Color( 0xD9, 0xD9, 0xF3);
//		colors["Rich Blue"]=Color( 0x59, 0x59, 0xAB);
//		colors["Scarlet"]=Color( 0x8C, 0x17, 0x17);
//		colors["Sea Green"]=Color( 0x5C, 0x33, 0x17);
//		colors["Semi-Sweet Chocolate"]=Color( 0x5C, 0x33, 0x17);
//		colors["Sky Blue"]=Color(0x32, 0x99, 0xCC);
//		colors["Slate Blue"]=Color( 0x00, 0x7F, 0xFF);
//		colors["Spicy Pink"]=Color( 0xFF, 0x1C, 0xAE);
//		colors["Spring Green"]=Color( 0x00, 0xFF, 0x7F);
//		colors["Steel Blue"]=Color( 0x23, 0x6B, 0x8E);
	}

	SmurfAspect getStyle(String _style) {
		if (_style == "TRANSPARENT") {
			return SmurfAspect.SMURF_ASPECT_TRANSPARENT;
		} else if (_style == "SQUARE") {
			return SmurfAspect.SMURF_ASPECT_SQUARE;
		} else if (_style == "STAR") {
			return SmurfAspect.SMURF_ASPECT_STAR;
		} else { 
			return SmurfAspect.SMURF_ASPECT_DISC;
		}
	}

	SmurfFunction getFunction(String _function) {
		if (_function == "KNOB") {
			return SmurfFunction.SMURF_FUNC_KNOB;
		}  else { 
			return SmurfFunction.SMURF_FUNC_NONE;
		}
	}


	

	void initSettings() {	
		details = new HashMap<Float, SmurfDetails >();
		
		String  settingsFilePath = "/../../../data/settings.xml";
		
//		
//		if( XML.loadFile(settingsFilePath)){
//	        					
//			// OSC Send Address
//			String addr = XML.getValue("smurf:settings:OscSendAddress", "localhost");
//			setOscSendAddress(addr);
//					
//			// OSC Send Port
//			int oscSendPort = XML.getValue("smurf:settings:OscSendPort",  12345);
//			setOscSendPort(oscSendPort);
//			
//			// OSC Receive Port
//			int oscReceivePort = XML.getValue("smurf:settings:OscReceivePort",  3334);
//			setOscReceivePort(oscReceivePort);
//			
//			// TUIO Port
//			int tuioPort = XML.getValue("smurf:settings:TuioPort",  3333);
//			setTuioPort(tuioPort);
//					
//							
//			XML.pushTag("smurf", 0);
//
//			int numTags = XML.getNumTags("fid");	
//
//			for (int i=0;i<numTags;i++) {
//				XML.pushTag("fid", i);
//				// <fid> id=0 style=ROUND FG="Green" radius=30.0 </fid>
//				float uid = XML.getValue("id", 0.0);
//				String style = XML.getValue("style", "");
//				String kind = XML.getValue("kind", "");
//				String bg = XML.getValue("BG", "");
//				String fg = XML.getValue("FG", "");
//				float radius = XML.getValue("radius", 0.0);
//				float proxima = XML.getValue("proxima", 15.0);
//				float range = XML.getValue("range", 15.0);
//				String function = XML.getValue("function", "");
//				boolean proximaVisible = XML.getValue("proximaVisible", false);
//				
//				details.get(uid).add(new SmurfDetails(uid, 0.0, getColor(fg), getColor(bg), getStyle(style), radius, proxima, range, getFunction(function), kind, proximaVisible);
//				
//				XML.popTag();
//			}
//			
//			XML.popTag();
//			XML.popTag();
			
//			ofLog(OF_LOG_NOTICE, "Settings read successfully");
//		}
	}

	Color getColor(String _name) {
		return colors.get(_name);
	}

	void setTuioPort(int _port) {
		tuioPort = _port;
	}

	int getTuioPort() {
		return tuioPort;
	}

	void setOscSendPort(int _port) {
		oscSendPort = _port;
	}

	int getOscSendPort() {
		return oscSendPort;
	}

	void setOscReceivePort(int _port) {
		oscReceivePort = _port;
	}

	int getOscReceivePort() {
		return oscReceivePort;
	}

	void setOscSendAddress(String _address) {
		oscSendAddress = _address;
	}

	String getOscSendAddress() {
		return oscSendAddress;
	}

	SmurfDetails  getSmurfDetails(float _uid) {
		return details.get(_uid);
	}

	


}
