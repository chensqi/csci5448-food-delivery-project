package net.fooddelivery.restaurant.models;

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
	private int id;
	private String name;
	private String description;
	private double deliverFee;
	private String address;
	private String openTime;
	private String closeTime;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] photo;
	
	@OneToMany
	private Collection<Food> foods;
	@OneToMany
	private Collection<Orders> orders;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(double deliverFee) {
		this.deliverFee = deliverFee;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Collection<Food> getFoods() {
		return foods;
	}
	public void setFoods(Collection<Food> foods) {
		this.foods = foods;
	}
	public Collection<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
}
	