import java.util.LinkedList;


public class dataPackageFactory {
	private loginToSense sense_login;
	private LinkedList<Device> devices;

	public dataPackageFactory() {
		sense_login = new loginToSense("srozendaal",
				"e967b1366fe2c2997520eec0968cb20d");
		initSenseDevices();
	}
	
	public dataPackage requestNewPackage() {
		
		
		return 
	}
	
	private void initSenseDevices() {
		
	}
}
