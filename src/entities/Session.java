package entities;


public class Session {
	
	private Long id;
	private Theatre theatre;
	private Movie movie;
	private String begindate;

	public Session(){
		
	}
	
	public Session(Long id, String begindate){
		this.id = id;
		this.begindate = begindate;
	}
	public Session(Long id, Movie movie, Theatre theatre, String begindate){
		this.id = id;
		this.movie = movie;
		this.theatre = theatre;
		this.begindate = begindate;
	}
	
	public Session(Movie movie, Theatre theatre, String begindate){
		this.movie = movie;
		this.theatre = theatre;
		this.begindate = begindate;
	}
	
	public Session(Long id, Movie movie, String begindate){
		this.id = id;
		this.movie = movie;
		this.begindate = begindate;
	}
	
	public Session (Movie movie, String begindate){
		this.movie = movie;
		this.begindate = begindate;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
	

}

