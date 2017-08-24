package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


@SuppressWarnings("serial")
public class LoginForm extends ActionForm{
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String name) {
		this.id = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(id == null || id.equals(""))
			errors.add("adminId", new ActionMessage("error.userid.required"));
		if(password == null || password.equals(""))
			errors.add("userPassword", new ActionMessage("error.userpwd.required"));
		if(!id.equals(password))
			errors.add("userLog",  new ActionMessage("error.userLog.incorrect"));
		return errors;
	}
}
