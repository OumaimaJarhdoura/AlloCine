package entities;

public class Theatre {
	
	private Long id;
	private String city;
	private Long zipcode;
	private ProjectionRoom [] rooms;
	
	public Theatre(){
		
	}
	
	public Theatre(Long id, String city, Long zip, ProjectionRoom[] pr){
		this.setId(id);
		this.setCity(city);
		this.setZipcode(zip);
		this.rooms = pr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	public ProjectionRoom [] getRooms() {
		return rooms;
	}

	public void setRooms(ProjectionRoom [] rooms) {
		this.rooms = rooms;
	}

}
