package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class CreateMovieForm extends ActionForm {
	
	private String id;
	private String title;
	private String duration;
	private String genre;
	private String synopsis;
	private String releaseDate;
	private String cast;
	private String director;
	private String language;
	private int age;
	private String starts;
	private String ends;
	private String link;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public String getStarts(){
		return starts;
	}
	public void setStarts(String starts){
		this.starts = starts;
	}
	
	public String getEnds(){
		return ends;
	}
	public void setEnds(String ends){
		this.ends = ends;
	}
	
	public String getLink(){
		return link;
	}
	public void setLink(String link){
		this.link = link;
	}
	
	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		if(title.equals(""))
			errors.add("formTitle", new ActionMessage("error.form.title"));		
		if(duration.equals(""))
			errors.add("formDuration", new ActionMessage("error.form.duration"));
		if(genre.equals(""))
				errors.add("formGenre", new ActionMessage("error.form.genre"));
		if (releaseDate.equals(""))
			errors.add("formReleaseDate",new ActionMessage("eroor.form.releasedate"));
		if(synopsis.equals(""))
				errors.add("formSynopsis", new ActionMessage("error.form.synopsis"));
		if(language.equals(""))
				errors.add("formLanguage", new ActionMessage("error.form.language"));
		if (cast.equals(""))
				errors.add("formCast", new ActionMessage("error.form.cast"));
		if(director.equals(""))
				errors.add("formDirector", new ActionMessage("error.form.director"));
		if(starts.equals(""))
				errors.add("formStarts", new ActionMessage("error.form.starts"));
		if (ends.equals(""))
				errors.add("formends", new ActionMessage("error.form.ends"));
		return errors;
	}
	
	@Override
	public String toString() {
		return "CreateMovieForm [title=" + title + ", genre="
				+ genre + ", duration=" + duration + ", Release Date="
				+ releaseDate + ", Synopsis=" + synopsis + ", directed by="
				+ director + ", The cast=" + cast + ", language=" + language +", The min age=" + age + "]";
	}
}
