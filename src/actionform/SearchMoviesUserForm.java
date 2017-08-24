package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class SearchMoviesUserForm extends ActionForm {

	private String city;


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		return errors;
	}
}
