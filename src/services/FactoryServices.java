package services;

public class FactoryServices implements BaseServices {

	private FactoryServices(){
		
	}
	
	public static BaseServices getService(String classeType) {
		switch (classeType) {
		case "Movie":
			return new MovieServices();
		case "Theatre" :
			return new TheatreServices();
		case "Session" :
			return new SessionServices();
		default:
			throw new IllegalArgumentException("Mauvaise classe");
		}
	}
}
