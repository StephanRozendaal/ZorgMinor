public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			dataPackageFactory factory = new dataPackageFactory();
			dataPackage dat = factory.requestNewPackage();
			dat.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
