import java.util.LinkedList;

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

}
