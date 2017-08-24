package action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.FactoryServices;
import services.MovieServices;
import entities.Movie;
import entities.ProjectionRoom;
import entities.Session;
import actionform.CreateMovieForm;
import actionform.CreateSessionForm;
public class CreateSessionAction  extends Action {
	
			public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		
		CreateSessionForm formulaire = (CreateSessionForm) form;
		
		
		String movieTitle = formulaire.getMovieTitle();
		String roomID = formulaire.getRoomID();
		String begin = formulaire.getBegindate();
		
		//Session stoCreate = new Session(room,movie,begin);
		
		//SessionServices s_services = (SessionServices) FactoryServices.getService("Session");
		//if (s_services.createSession(stoCreate)==1)
			//return map.findForward("success");
		//else return map.findForward("error");
		return null;
			}

}
