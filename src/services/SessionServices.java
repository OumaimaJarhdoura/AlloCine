package services;

import java.util.ArrayList; 

import daos.SessionDAO;
import entities.Session;

public class SessionServices implements BaseServices {
	
	public SessionServices(){
		
	}
	
	public int createSession (Session toCreate) {
		SessionDAO _sessionDAO = new SessionDAO ();
		return _sessionDAO.create(toCreate);
	}

	public ArrayList<Session> searchSessionByMovie(Long movieid) {
		SessionDAO _sessionDAO = new SessionDAO();
		return _sessionDAO.search(movieid);
	}
	
	public ArrayList<Session> findAllSessions() {
		SessionDAO _sessionDAO = new SessionDAO();
		return _sessionDAO.findAll();
	}

	public boolean delete(Long sessionid) {
		SessionDAO _sessionDAO = new SessionDAO();
		return _sessionDAO.delete(sessionid);
	}
	
	
	

}
