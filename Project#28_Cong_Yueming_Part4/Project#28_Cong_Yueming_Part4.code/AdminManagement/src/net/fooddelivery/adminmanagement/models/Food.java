package net.fooddelivery.adminmanagement.models;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table( name = "Food" )
public class Food {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	private String name;
	private double price;
	private int calorie;
	private String description;
	@Column(columnDefinition = "LONGBLOB")
	byte[] photo;
	
	@ManyToOne
	private Restaurant restaurant;
	
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
	public void setPhoto(byte[] photo){
		this.photo=photo;
	}
	public byte[] getPhoto(){
		return photo;
	}
	
}
