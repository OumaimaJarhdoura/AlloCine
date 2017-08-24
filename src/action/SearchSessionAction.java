package action;

import java.util.ArrayList;

import entities.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.SearchSessionForm;
import services.FactoryServices;
import services.SessionServices;

public class SearchSessionAction extends Action{
	
	public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		SessionServices s_service = (SessionServices) FactoryServices.getService("Session");
		SearchSessionForm formulaire = (SearchSessionForm) form;
		ArrayList<Session> sessions = s_service.searchSessionByMovie(formulaire.getMovie());
		if (sessions != null){
			request.setAttribute("sessions", sessions);
			System.out.println("Ok");
			return map.findForward("success");}
		else {
			System.out.println("KO");
			return map.findForward("error");}
			}

}
