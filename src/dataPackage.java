import java.util.LinkedList;

import net.sf.json.JSONObject;

/**
 * 
 * @author stephan
 * dit wordt een klasse die JSON data omzet in ..
 */

public class dataPackage {
	
	LinkedList<JSONObject> sensor_data;
	
	public dataPackage() {
		sensor_data = new LinkedList<JSONObject>();
	}
	public void add(JSONObject ob) {
		sensor_data.add(ob);
	}

}
