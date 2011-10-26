import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		try {
			dataPackageFactory factory = new dataPackageFactory();
			dataPackage dat = factory.requestNewPackage();
			LinkedList<sensorData> list = dat.getSensorData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
