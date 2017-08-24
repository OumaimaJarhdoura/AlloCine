package services;

import java.util.ArrayList;

import daos.SessionDAO;
import entities.Movie;
import entities.Session;

public class SessionServices extends BaseServices {
	
	public SessionServices(){
		
	}
	
	public int createSession (Session toCreate) {
		SessionDAO _sessionDAO = new SessionDAO ();
		return _sessionDAO.create(toCreate);
	}

	public ArrayList<Session> searchSessionByMovie(Movie movie) {
		SessionDAO _sessionDAO = new SessionDAO();
		return _sessionDAO.search(movie);
	}
	
	public ArrayList<Session> findAllSessions() {
		SessionDAO _sessionDAO = new SessionDAO();
		return _sessionDAO.findAll();
	}
	
	

}
