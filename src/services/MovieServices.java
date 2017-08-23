package services;

import java.util.ArrayList;

import daos.MovieDAO;
import entities.Movie;

public class MovieServices extends BaseServices {
	
	public MovieServices(){
		
	}
	
	public int createMovie (Movie toCreate) {
		MovieDAO _movieDAO = new MovieDAO ();
		return _movieDAO.create(toCreate);
	}

	public ArrayList<Movie> searchMovieByTitle(String title) {
		MovieDAO _movieDAO = new MovieDAO();
		return _movieDAO.search(title);
	}

}
