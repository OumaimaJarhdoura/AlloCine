package entities;

public class ProjectionRoom {
	
	private Long id;
	private boolean occupation;
	
	public ProjectionRoom(){
		
	}
	
	public ProjectionRoom(Long id, boolean occupation){
		this.setId(id);
		this.setOccupation(occupation);
	}
	
	public ProjectionRoom(boolean occupation){
		this.setOccupation(occupation);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isOccupation() {
		return occupation;
	}

	public void setOccupation(boolean occupation) {
		this.occupation = occupation;
	}

}
