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
		String language = formulaire.getLanguage();
		String director = formulaire.getDirector();
		String cast = formulaire.getCast();
		int age= formulaire.getAge();
		String starts = formulaire.getStarts();
		String ends = formulaire.getEnds();
		String link = formulaire.getLink();
		
		
		Movie mtoCreate = new Movie (title,genre,duration,releasedate, synopsis, language, director, cast, age, starts, ends, link);
		
		MovieServices m_service = (MovieServices) FactoryServices.getService("Movie");
		if (m_service.createMovie(mtoCreate)==1)
			return map.findForward("success");
		else return map.findForward("error");
			}

}
