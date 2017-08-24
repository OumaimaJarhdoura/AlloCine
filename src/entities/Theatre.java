package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Theatre {
	
	private Long id;
	private String name;
	private String city;
	private Long zipcode;
	
	public Theatre(){
		
	}
	
	public Theatre(Long id, String name, String city, Long zip){
		this.setId(id);
		this.setName(name);
		this.setCity(city);
		this.setZipcode(zip);

	}
	
	public Theatre(String name, String city, Long zip){
		this.setName(name);
		this.setCity(city);
		this.setZipcode(zip);

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

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
