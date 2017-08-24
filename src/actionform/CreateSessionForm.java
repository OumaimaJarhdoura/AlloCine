package actionform;

import javax.servlet.http.HttpServletRequest; 

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import daos.SessionDAO;


public class CreateSessionForm  extends ActionForm {
	
	//private String id;
	private String movieid;
	private String theatreid;
	private String begindate;
	
	@Override	
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(begindate.equals(""))
			errors.add("formdate", new ActionMessage("error.form.begindate"));		
		if(movieid.equals(""))
			errors.add("formmovie", new ActionMessage("error.form.movieid"));
		if(theatreid.equals(""))
			errors.add("formtheatre", new ActionMessage("error.form.theatreid"));
		return errors;
	}
	
	@Override
	public String toString() {
		return "CreateSession [Movie title=" + movieid + 
				", Begins =" + begindate + "]";
	}

	

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getMovieid() {
		return this.movieid;

	}


	public String getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(String theatreid) {
		this.theatreid = theatreid;
	}
}
