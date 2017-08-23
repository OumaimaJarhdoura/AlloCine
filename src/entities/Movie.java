package entities;

public class Movie {
	
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
	
	
	public Movie (String id, String title, String genre, String duration, String releasedate, String syno,
			String language, String director, String cast, int age,String starts, String ends, String link){
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releasedate;
		this.synopsis = syno;
		this.language = language;
		this.director = director;
		this.cast = cast;
		this.age = age;
		this.starts = starts;
		this.ends = ends;
		this.link = link;
	}
	public Movie (String title, String genre, String duration, String releasedate, String syno,
			String language, String director, String cast, int age,String starts, String ends, String link){
	
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releasedate;
		this.synopsis = syno;
		this.language = language;
		this.director = director;
		this.cast = cast;
		this.age = age;
		this.starts = starts;
		this.ends = ends;
		this.link = link;
	}
	
	
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
	
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + title + ", genre=" + genre
				+ ", duration=" + duration + ", Released =" + releaseDate + ", Synopsis="
				+ synopsis + ", Directed by ="
				+ director + " Cast = " + cast + "]";
	}


	public String getStarts() {
		return starts;
	}


	public void setStarts(String starts) {
		this.starts = starts;
	}


	public String getEnds() {
		return ends;
	}


	public void setEnds(String ends) {
		this.ends = ends;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	
	
}
