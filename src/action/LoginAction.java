package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action{
	public ActionForward execute(ActionMapping map ,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		return map.findForward("success");
			}
}
