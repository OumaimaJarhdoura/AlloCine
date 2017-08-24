package entities;


public class Session {
	
	private Long id;
	private ProjectionRoom projectionroom;
	private Movie movie;
	private String begindate;

	public Session(){
		
	}
	
	public Session(Long id, ProjectionRoom room, Movie movie, String begindate){
		this.id = id;
		this.projectionroom = room;
		this.movie = movie;
		this.begindate = begindate;
	}
	
	public Session (ProjectionRoom room, Movie movie, String begindate){
		this.projectionroom = room;
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
	public ProjectionRoom getProjectionroom() {
		return projectionroom;
	}
	public void setProjectionroom(ProjectionRoom projectionroom) {
		this.projectionroom = projectionroom;
	}
	
	

}

