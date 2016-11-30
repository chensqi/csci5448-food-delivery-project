package Models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "Restaurant" )
public class Restaurant {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	int id;
	String name;
	String description;
	double deliverFee;
	double averageRate;
	@Embedded
	Location location;
	java.sql.Date openTime;
	java.sql.Date closeTime;
	
	@OneToMany
	private Collection<Food> foods;
	@ManyToMany
	private Collection<Order> orders;
}
