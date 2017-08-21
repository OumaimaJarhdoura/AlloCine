package services;

import daos.MovieDAO;
import entities.Movie;

public class MovieServices {
	
	public MovieServices(){
		
	}
	
	public int createMovie (Movie toCreate) {
		MovieDAO _movieDAO = new MovieDAO ();
		return _movieDAO.create(toCreate);
	}

}
