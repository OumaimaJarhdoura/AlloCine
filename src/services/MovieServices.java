package services;

import java.util.ArrayList;

import daos.MovieDAO;
import entities.Movie;

public class MovieServices implements BaseServices {
	
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
	
	public ArrayList<Movie> findAllMovies() {
		MovieDAO _movieDAO = new MovieDAO();
		return _movieDAO.findAll();
	}
	public ArrayList<Movie> searchMoviesByCity(String city)
	{
		MovieDAO _movieDAO = new MovieDAO();
		return _movieDAO.findByCity(city);
	}
	
	

}
