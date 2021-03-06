package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.SearchMoviesUserForm;
import entities.Movie;
import entities.Session;
import services.FactoryServices;
import services.MovieServices;
import services.SessionServices;

public class SearchMoviesUserAction extends Action {
	
	public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		MovieServices m_service = (MovieServices) FactoryServices.getService("Movie");
		SearchMoviesUserForm formulaire = (SearchMoviesUserForm) form;
		ArrayList<Movie> movies = m_service.searchMoviesByCity(formulaire.getCity());
		if (movies != null){
			request.setAttribute("movies", movies);
			System.out.println("Ok");
			return map.findForward("success");}
		else {
			System.out.println("KO");
			return map.findForward("error");}
			}

}
