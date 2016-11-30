package Models;

import javax.persistence.*;

@Entity
public class Location {
	@Id
	int id;
	double longtitude, latitude;
	String address;
}
