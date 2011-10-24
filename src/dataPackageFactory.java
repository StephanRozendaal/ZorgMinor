import java.util.LinkedList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Deze factory maakt dataPackages uit sense sensor data
 * 
 * @author stephan
 * 
 */
public class dataPackageFactory {

	private loginToSense sense_login;
	private LinkedList<Device> devices;
	private jsonHandler json;

	/**
	 * constructor
	 * 
	 * @throws Exception
	 */
	
	public dataPackageFactory() throws Exception {
		sense_login = new loginToSense("srozendaal",
				"e967b1366fe2c2997520eec0968cb20d");
		devices = new LinkedList<Device>();
		json = new jsonHandler(sense_login.getSessionId());
		initSenseDevices();
	}

	public dataPackage requestNewPackage() throws Exception {
		LinkedList<Sensor> sen = devices.getFirst().getSensor();
		dataPackage pak = new dataPackage();
		for(int i = 0; i < sen.size(); i++) {
			pak.add(json.executeJSON(sen.get(i)));
		}
		pak.print();
		return pak;
	}

	/**
	 * Deze methode initialiseert een linkedlist van de devices uit sense
	 * NOTE!! bij het maken van een sensor is de field data_structure soms leeg, moet dit nog afvangen.
	 * 
	 * @throws Exception
	 */
	private void initSenseDevices() throws Exception {
		int j;
		JSONObject tempsensor = json.executeJSON(JSON_TYPES.sensor);
		JSONObject tempdevice = json.executeJSON(JSON_TYPES.device);
		JSONArray temparr = tempdevice.getJSONArray("devices");
		JSONArray tempdevarr = tempsensor.getJSONArray("sensors");
		for(int i = 0; temparr.size() > i; i++) {
			tempdevice = temparr.getJSONObject(i);
			Device device = new Device(tempdevice.getInt("id"),
					tempdevice.getString("uuid"), tempdevice.getString("type"));
			for(j = 0; tempdevarr.size() > j; j++) {
				tempsensor = tempdevarr.getJSONObject(j);
				Sensor s = new Sensor(tempsensor.getInt("id"), tempsensor
						.getString("name"), tempsensor.getString("type"),
						tempsensor.getString("device_type"), tempsensor
								.getString("pager_type"), tempsensor
								.getString("display_name"), tempsensor
								.getString("data_type"));
				if(tempsensor.getString("data_type").equalsIgnoreCase("json") == true)
					s.data_structure = (JSONObject)JSONSerializer.toJSON(tempsensor.getJSONObject("data_structure"));
				if(tempsensor.getString("data_type").equalsIgnoreCase("string") == true)
					s.data_structure = "String";
				if(tempsensor.getString("data_type").equalsIgnoreCase("bool") == true)
					s.data_structure = true; // oplossing om data_structure naar boolean te casten.
				device.add(s);
				j++;
			}
			devices.add(device);
			//device.print();
		}
	}
}
