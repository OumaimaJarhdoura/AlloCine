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
	private String nationality;
	
	public Movie (String id, String title, String genre, String duration, String releasedate, String syno,
			String nationality, String director, String cast){
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releasedate;
		this.synopsis = syno;
		this.nationality = nationality;
		this.director = director;
		this.cast = cast;
		
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
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + title + ", genre=" + genre
				+ ", duration=" + duration + ", Released =" + releaseDate + ", Synopsis="
				+ synopsis + ", Directed by ="
				+ director + " Cast = " + cast + "]";
	}
	
	
}
