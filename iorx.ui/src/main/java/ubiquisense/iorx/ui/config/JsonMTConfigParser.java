package ubiquisense.iorx.ui.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class JsonMTConfigParser {
//	{	"outAddr" : "localhost",
//		"outOscPort" : "6655",
//		"inOscPort" : "8877",
//		"fiducials" : 
//		[
//			{"id" : "1", "kind" : "Circle", "radius" : "100", "tempo" : 50}, 
//			{"id" : "2", "kind" : "Circle", "radius" : "80", "tempo" : 66}, 
//			{"id" : "3", "kind" : "Circle", "radius" : "110", "tempo" : 100}, 
//			{"id" : "4", "kind" : "Circle", "radius" : "120", "tempo" : 40}, 
//			{"id" : "5", "kind" : "Circle", "radius" : "130", "tempo" : 80}, 
//			{"id" : "6", "kind" : "Circle", "radius" : "90", "tempo" : 75}, 
//			{"id" : "7", "kind" : "Circle", "radius" : "60", "tempo" : 65}
//		]
//	}
	
	
	public MTConfig parse(String path)
	{
		try {
			String jsonText = new String(Files.readAllBytes(Paths.get(path)));
			JSONObject json = new JSONObject(jsonText);
			
			String outAdr =  json.getString("outAddr");
			int outOscPort = json.getInt("outOscPort");
			int inOscPort = json.getInt("inOscPort");
			MTConfig cfg = new MTConfig(outAdr, outOscPort, inOscPort);
			
			cfg.getFiducials().addAll(json.getJSONArray("fiducials").toList().stream()
				.map(o2m -> new HashMap<String, String>((Map<String, String>)o2m))
					.map( o  -> new MTFiducialConfig(
						o.get("id"), 
						o.get("radius"), 
						o.get("kind"), 
						o.get("tempo"),
						o.get("fg"),
						o.get("bg"),
						o.get("range"),
						o.get("weight")
				)).collect(Collectors.toSet()));
			 return cfg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new MTConfig("localhost", 4444, 5555);
	}

}
