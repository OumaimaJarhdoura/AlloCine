package services;

import java.util.ArrayList;

import daos.TheatreDAO;
import entities.Theatre;

public class TheatreServices implements BaseServices{


	
	public TheatreServices(){
		
	}
	

	public ArrayList<Theatre> searchTheatreByCity(String city) {
		TheatreDAO _theatreDAO = new TheatreDAO();
		return _theatreDAO.search(city);
	}
	
	public ArrayList<Theatre> findAllTheatres() {
		TheatreDAO _theatreDAO = new TheatreDAO();
		return _theatreDAO.findAll();
	}
	
	

}
