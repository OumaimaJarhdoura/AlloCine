package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class SearchMovieForm extends ActionForm{
	private String title;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		return errors;
	}
}
