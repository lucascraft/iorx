package ubiquisense.iorx.utils;

public class Platform {
	static boolean debug = true;
	public static  boolean inDebugMode() {
		return debug;
	}
	
	public static void disableDebugMode() {
		debug = false;
	}
	public static void enableDebugMode() {
		debug = true;
	}
	
	
}
