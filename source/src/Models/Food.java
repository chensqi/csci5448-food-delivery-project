package Models;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table( name = "Food" )
public class Food {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	int id;
	String name;
	double price;
	int calorie;
	String description;
	
	@ManyToOne
	private Restaurant restaurant;
	@ManyToMany
	private Collection<Order> orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
