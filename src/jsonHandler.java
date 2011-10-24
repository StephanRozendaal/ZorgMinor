import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class jsonHandler {

	private HttpURLConnection connection;
	private URL sense_login;
	private String session_id;

	public jsonHandler(String session_id) {
		this.session_id = session_id;
	}

	/**
	 * vraag JSON data op uit Sense
	 * 
	 * @param type
	 *            soort JSON data (devices, sensors, sensor data etc) 1. =
	 *            devices 2. = sensors 3. = sensor data
	 * @return JSONObject
	 */
	public JSONObject executeJSON(JSON_TYPES type) throws Exception {
		switch (type) {
		case device:
			sense_login = new URL("http://api.sense-os.nl/devices.json");
			break;
		case sensor:
			sense_login = new URL("http://api.sense-os.nl/sensors.json");
			break;
		default:
			sense_login = null;
		}
		connection = (HttpURLConnection) sense_login.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("X-SESSION_ID", session_id);
		connection.setConnectTimeout(5000);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine;
		StringBuilder strbuilder = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			strbuilder.append(inputLine);
		in.close();
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(strbuilder
				.toString());
		return jsonObject;
	}

	/**
	 * Deze methode wordt gebruikt om de sensordata op te halen uit sense
	 * 
	 * @param sen
	 *            De sensor waarvoor data opgehaald wordt.
	 * @param start_date
	 *            start datum van sensordata
	 * @param end_date
	 *            eind datum van sensordata
	 * @return JSONObject met daarin sensordata
	 * @throws Exception
	 */
	public JSONObject executeJSON(Sensor sen, Date start_date, Date end_date)
			throws Exception {
		String query = String.format("start_date=%s&end_date=%s",
				start_date.getTime(), end_date.getTime());
		sense_login = new URL("http://api.sense-os.nl/sensors/" + sen.id
				+ "/data.json" + "?" + query);
		connection = (HttpURLConnection) sense_login.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("X-SESSION_ID", session_id);
		connection.setConnectTimeout(5000);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine;
		StringBuilder strbuilder = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			strbuilder.append(inputLine);
		in.close();
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(strbuilder
				.toString());
		return jsonObject;
	}
}
