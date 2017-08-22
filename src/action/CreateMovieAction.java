package action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.MovieServices;
import entities.Movie;
import actionform.CreateMovieForm;

public class CreateMovieAction  extends Action {
	
			public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		
		CreateMovieForm formulaire = (CreateMovieForm) form;
		
		String title = formulaire.getTitle();
		String duration = formulaire.getDuration();
		String genre = formulaire.getGenre();
		String releasedate = formulaire.getReleaseDate();
		String synopsis = formulaire.getSynopsis();
		String nationality = formulaire.getNationality();
		String director = formulaire.getDirector();
		String cast = formulaire.getCast();
		
		
		Movie mtoCreate = new Movie ("",title,genre,duration,releasedate, synopsis, nationality, director, cast);
		
		MovieServices m_service = new MovieServices();
		m_service.createMovie(mtoCreate);
		
		return map.findForward("ok");
			}

}
