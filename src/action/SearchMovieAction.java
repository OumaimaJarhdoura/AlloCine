package action;

import java.util.ArrayList;

import entities.Movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.SearchMovieForm;
import services.MovieServices;

public class SearchMovieAction extends Action{
	
	public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		MovieServices m = new MovieServices();
		SearchMovieForm formulaire = (SearchMovieForm) form;
		ArrayList<Movie> movies = m.searchMovieByTitle(formulaire.getTitle());
		if (movies != null){
			request.setAttribute("movies", movies);
			System.out.println("Ok");
			return map.findForward("success");}
		else {
			System.out.println("KO");
			return map.findForward("error");}
			}

}
