package action;

import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daos.MovieDAO;
import daos.TheatreDAO;
import services.FactoryServices;
import services.SessionServices;
import entities.Movie;
import entities.Session;
import entities.Theatre;
import actionform.CreateSessionForm;

public class CreateSessionAction  extends Action {
	
			public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		
		CreateSessionForm formulaire = (CreateSessionForm) form;
		
		
		String movieId = formulaire.getMovieid();
		String theatreID = formulaire.getTheatreid();
		String begindate = formulaire.getBegindate();
		
		
			MovieDAO _movieDAO = new MovieDAO();
			TheatreDAO _theatreDAO = new TheatreDAO();
			Movie movie= _movieDAO.searchById(movieId);
			//TODO : Comparer date de sortie et la date begin
			Theatre theatre = _theatreDAO.searchById(theatreID);	
		if(movie == null ) System.out.println("movie null");
		if (theatre == null) System.out.println("theatre null");
		
		Session stoCreate = new Session(movie,theatre,begindate);
		
		SessionServices s_services = (SessionServices) FactoryServices.getService("Session");
		if (s_services.createSession(stoCreate)==1)
			return map.findForward("success");
		else return map.findForward("error");
		
			}
}
