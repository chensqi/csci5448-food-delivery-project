package net.fooddelivery.restaurant.models;

import java.util.Collection;

import javax.persistence.*;
import net.fooddelivery.restaurant.models.*;
@Entity
public class Order {
	@Id
	private int id;
	private String destination;
	private java.sql.Date time;
	private int orderStatus;
	
	@OneToMany
	private Collection<Food> foods;
	@OneToOne @MapsId
	private Customer customers;
	@OneToOne @MapsId
	private Restaurant restaurant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public java.sql.Date getTime() {
		return time;
	}

	public void setTime(java.sql.Date time) {
		this.time = time;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Collection<Food> getFoods() {
		return foods;
	}

	public void setFoods(Collection<Food> foods) {
		this.foods = foods;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
