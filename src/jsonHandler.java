import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String inputLine;
		StringBuilder strbuilder = new StringBuilder();

		while ((inputLine = in.readLine()) != null)
			strbuilder.append(inputLine);

		in.close();
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(strbuilder.toString());

		return jsonObject;

	}
}
