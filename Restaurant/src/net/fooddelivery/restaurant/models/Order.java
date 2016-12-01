package net.fooddelivery.restaurant.models;

import java.util.Collection;

import javax.persistence.*;
@Entity
public class Order {
	@Id
	int id;
	@Embedded
	Location dest;
	java.sql.Date time;
	int orderStatus;
	
	@ManyToMany
	private Collection<Food> foods;
	@ManyToMany
	private Collection<Customer> customers;
	@ManyToMany
	private Collection<Restaurant> restaurant;
}
