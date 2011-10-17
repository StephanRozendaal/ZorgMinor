import net.sf.json.JSONObject;


public class Sensor {
	int id;
	String name, type, device_type, pager_type, display_name, data_type;
	JSONObject data_structure;
	
public Sensor(int id, String name, String type, String device_type,
			String pager_type, String display_name, String data_type,
			JSONObject data_structure) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.device_type = device_type;
		this.pager_type = pager_type;
		this.display_name = display_name;
		this.data_type = data_type;
		this.data_structure = data_structure;
	}

}
