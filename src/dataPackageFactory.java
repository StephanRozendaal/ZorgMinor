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
		int i = 0, j = 0;
		JSONObject tempjson = json.executeJSON(1);
		JSONObject tempdevices = json.executeJSON(2);
		JSONArray temparr = tempjson.getJSONArray("devices");
		JSONArray tempdevarr = tempdevices.getJSONArray("sensors");
		try{
		while (temparr.size() >= i) {
			tempjson = temparr.getJSONObject(i);
			Device tempdevice = new Device(tempjson.getInt("id"),
					tempjson.getString("uuid"), tempjson.getString("type"));
			i++;
			while (tempdevarr.size() >= j) {
				tempjson = tempdevarr.getJSONObject(i);
				tempdevice.add(new Sensor(tempjson.getInt("id"), tempjson
						.getString("name"), tempjson.getString("type"),
						tempjson.getString("device_type"), tempjson
								.getString("pager_type"), tempjson
								.getString("display_name"), tempjson
								.getString("data_type"), tempjson
								.getJSONObject("data_structure")));
				j++;
			}
			devices.add(tempdevice);
		}
		} catch (Exception e) {
			continue;
		}
	}
}
