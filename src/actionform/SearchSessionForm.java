package actionform;

import javax.servlet.http.HttpServletRequest; 

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;



@SuppressWarnings("serial")
public class SearchSessionForm  extends ActionForm {
	
	private Long movie;
	
	@Override	
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(movie.equals(""))
			errors.add("formmovie", new ActionMessage("error.form.movie"));		
		return errors;
	}
	
	@Override
	public String toString() {
		return "CreateSession [Movie title=" + movie+ "]";
	}

	
	public void setMovie(Long title){
		this.movie= title;
	}
	public Long getMovie(){
		return this.movie;
	}

	
}
