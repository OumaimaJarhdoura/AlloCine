package services;

public class FactoryServices extends BaseServices {

	private FactoryServices(){
		
	}
	
	public static BaseServices getService(String classeType) {
		switch (classeType) {
		case "Movie":
			return new MovieServices();
		
		default:
			throw new IllegalArgumentException("Mauvaise classe");
		}
	}
}
