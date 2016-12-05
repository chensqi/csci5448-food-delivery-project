package Models;

import javax.persistence.*;

@Entity
public class Location {
	@Id
	int id;
	double longtitude, latitude;
	String address;
	
	public Location() {
		address = "empty";
	}
	
	public Location(String address) {
		this.address = new String(address);
	}
	@Override
	public String toString() {
		return address;
	}
}
