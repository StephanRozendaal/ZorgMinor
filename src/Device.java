import java.util.LinkedList;
import static java.lang.System.out;

/**
 * Dit is een dataklasse voor sense devices
 * @author stephan
 *
 */
public class Device {

	private int ID;
	private String uuid, type;
	private LinkedList<Sensor> sensors;

	/**
	 * sense devices (smartphones) omgezet vanuit sense (JSON) naar een Java
	 * object.
	 * 
	 * @param ID
	 *            Device ID
	 * @param uuid
	 *            Device uuid
	 * @param type
	 *            Device naam
	 */
	
	public Device(int ID, String uuid, String type) {
		this.ID = ID;
		this.uuid = uuid;
		this.type = type;
		this.sensors = new LinkedList<Sensor>();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void add(Sensor s) {
		sensors.add(s);
	}
	
	public LinkedList<Sensor> getSensor() {
		return sensors;
	}
	
	public void print() {
		out.printf(
				"Device uuid: %s \n" +
				"Device type: %s \n" +
				"Device ID: %s \n \n",uuid, type, ID);
		for(int i = 0; sensors.size() > i; i++) {
			sensors.get(i).print();
		}
		
	}

}
