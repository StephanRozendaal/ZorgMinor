import java.net.HttpURLConnection;
import java.net.URL;
import net.sf.json.JSONObject;

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
	 *            devices 2. = sensors
	 * @return JSONObject
	 */
	public JSONObject executeJSON(int type) throws Exception {
		switch (type) {
		case 1: {
			sense_login = new URL("http://api.sense-os.nl/devices.json");
		}
		case 2: {
			sense_login = new URL("http://api.sense-os.nl/sensors.json");
		}
		case 3: {
			// TODO
		}
		}
		connection = (HttpURLConnection) sense_login.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("X-SESSION_ID", session_id);
		connection.setConnectTimeout(5000);

		return null;

	}

}
