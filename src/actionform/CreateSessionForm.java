package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;




@SuppressWarnings("serial")
public class CreateSessionForm  extends ActionForm {
	
	//private String id;
	private String movieTitle;
	private String roomID;
	private String begindate;
	
	public ActionErrors validate(ActionErrors map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(begindate.equals(""))
			errors.add("formdate", new ActionMessage("error.form.begindate"));		
		if(movieTitle.equals(""))
			errors.add("formDuration", new ActionMessage("error.form.movieid"));
		if(roomID.equals(""))
				errors.add("formGenre", new ActionMessage("error.form.roomid"));
		return errors;
	}
	
	@Override
	public String toString() {
		return "CreateSession [Movie title=" + movieTitle + ", projection room ID="
				+ roomID + ", Begins =" + begindate + "]";
	}

	

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getMovieTitle() {
		return this.movieTitle;

	}

	public String getRoomID() {
		return this.roomID;
	}
}
