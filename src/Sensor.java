import static java.lang.System.out;

/**
 * Sensor dataklasse
 * TODO data_structure field oplossing zoeken.
 * dit field kan varieren, JSONobject, boolean of string etc..
 * @author stephan
 *
 */
public class Sensor {

	int id;
	String name, type, device_type, pager_type, display_name, data_type;
	public Object data_structure;

	public Sensor(int id, String name, String type, String device_type,
			String pager_type, String display_name, String data_type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.device_type = device_type;
		this.pager_type = pager_type;
		this.display_name = display_name;
		this.data_type = data_type;
	}

	public void print() {
		out.printf("Sensor ID: %d \n" + "Sensor naam: %s \n" + "Sensor type: %s \n"
				+ "Sensor device_type: %s \n" + "Sensor pager_type: %s \n"
				+ "Sensor display_name: %s \n" + "Sensor data_type: %s \n \n", id, name,
				type, device_type, pager_type, display_name, data_type);
	}

}
