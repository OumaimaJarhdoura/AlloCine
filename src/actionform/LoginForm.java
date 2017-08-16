package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm{
	private String id;
	private String pass;
	
	public String getId() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(id == null || id.equals(""))
			errors.add("userID", new ActionMessage("error.userID.required"));
		if(pass == null || pass.equals(""))
			errors.add("userPassword", new ActionMessage("error.userPassword.required"));
		if(!id.equals(pass))
			errors.add("userLog",  new ActionMessage("error.userLog.false"));
		return errors;
	}
}
