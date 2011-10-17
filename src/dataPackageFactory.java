import java.util.LinkedList;


public class dataPackageFactory {
	private loginToSense sense_login;
	private LinkedList<Device> devices;
	jsonHandler json;

	public dataPackageFactory() throws Exception {
		sense_login = new loginToSense("srozendaal",
				"e967b1366fe2c2997520eec0968cb20d");
		devices = new LinkedList<Device>();
		json = new jsonHandler(sense_login.getSessionId());
		initSenseDevices();
		
	}
	
	public dataPackage requestNewPackage() {
		
		
		return null;
	}
	
	private void initSenseDevices() throws Exception {
		Device tempdevice;
		//while (true) {
		//	
		//}
		json.executeJSON(1);
	}
}
