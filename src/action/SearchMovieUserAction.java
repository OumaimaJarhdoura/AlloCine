package action;

import java.util.ArrayList; 

import entities.Movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.SearchMovieUserForm;
import services.FactoryServices;
import services.MovieServices;

public class SearchMovieUserAction extends Action{
	
	public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		MovieServices m_service = (MovieServices) FactoryServices.getService("Movie");
		SearchMovieUserForm formulaire = (SearchMovieUserForm) form;
		ArrayList<Movie> movies = m_service.searchMovieByTitle(formulaire.getTitle());
		if (movies != null){
			request.setAttribute("movies", movies);
			System.out.println("Ok");
			return map.findForward("success");}
		else {
			System.out.println("KO");
			return map.findForward("error");}
			}

}
