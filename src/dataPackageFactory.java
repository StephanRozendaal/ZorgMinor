import java.util.LinkedList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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

	public dataPackage requestNewPackage() {
		return null;
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
		JSONArray tempdevarr = tempdevice.getJSONArray("sensors");
		for(int i = 0; temparr.size() > i; i++) {
			tempdevice = temparr.getJSONObject(i);
			Device device = new Device(tempdevice.getInt("id"),
					tempdevice.getString("uuid"), tempdevice.getString("type"));
			j = 0;
			while (tempdevarr.size() >= j) {
				tempsensor = tempdevarr.getJSONObject(i);
				device.add(new Sensor(tempsensor.getInt("id"), tempsensor
						.getString("name"), tempsensor.getString("type"),
						tempsensor.getString("device_type"), tempsensor
								.getString("pager_type"), tempsensor
								.getString("display_name"), tempsensor
								.getString("data_type")));
				j++;
			}
			devices.add(device);
			device.print();
		}
	}
}
