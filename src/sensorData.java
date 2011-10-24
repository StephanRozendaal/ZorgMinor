import java.util.Date;
import net.sf.json.JSONObject;
import static java.lang.System.out;

public class sensorData {
	/**
	 * Dataklasse voor sensordata
	 */
	int id, sensor_id;
	Date date;
	Object value;

	public sensorData(int id, int sensor_id, Date date, JSONObject value) {
		super();
		this.id = id;
		this.sensor_id = sensor_id;
		this.date = date;
		this.value = value;
	}

	public sensorData(JSONObject input) {
		super();
		this.id = input.getInt("id");
		this.sensor_id = input.getInt("sensor_id");
		this.date = new Date(input.getLong("date"));
		this.value = input.get("value");
	}

	public void print() {
		out.printf(
				"sensordata ID: %d \n sensordata sensor_id: %d \n sensordata date: %s \n",
				id, sensor_id, date.toString());
	}

}
