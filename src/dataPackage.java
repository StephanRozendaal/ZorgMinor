import java.util.LinkedList;
import static java.lang.System.out;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author stephan dit wordt een klasse die JSON data omzet in ..
 */

public class dataPackage {

	LinkedList<sensorData> sensor_data;

	public dataPackage() {
		sensor_data = new LinkedList<sensorData>();
	}

	public void add(JSONObject ob) {
		JSONArray ar = ob.getJSONArray("data");
		for(int i = 0; i < ar.size(); i ++) {
			sensor_data.add(new sensorData(ar.getJSONObject(i)));
		}
	}

	public void print() {
		for (int i = 0; i < sensor_data.size(); i++) {
			sensor_data.get(i).print();
		}
	}
}
