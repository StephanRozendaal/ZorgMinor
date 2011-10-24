import java.util.Date;
import java.util.LinkedList;
import static java.lang.System.out;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Deze klasse houdt sensordata vast uit sense van data tussen twee tijdstippen.
 * 
 * @author stephan
 */

public class dataPackage {

	LinkedList<sensorData> sensor_data;
	Date start_date, end_date;

	/**
	 * Constructor voor dataPackage
	 * 
	 * @param start_date
	 *            starttijd
	 * @param end_date
	 *            eindtijd
	 */
	public dataPackage(Date start_date, Date end_date) {
		sensor_data = new LinkedList<sensorData>();
		this.start_date = start_date;
		this.end_date = end_date;
	}

	/**
	 * voeg een JSONObject toe aan het dataPackage
	 * 
	 * @param ob
	 *            JSONObject
	 */
	public void add(JSONObject ob) {
		JSONArray ar = ob.getJSONArray("data");
		for (int i = 0; i < ar.size(); i++) {
			sensor_data.add(new sensorData(ar.getJSONObject(i)));
		}
	}

	public LinkedList<sensorData> getSensorData() {
		return sensor_data;
	}

	public Date getStartdate() {
		return start_date;
	}

	public Date getEndDate() {
		return end_date;
	}

	public void print() {
		for (int i = 0; i < sensor_data.size(); i++) {
			sensor_data.get(i).print();
		}
	}
}
