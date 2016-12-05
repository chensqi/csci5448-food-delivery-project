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
	String address;
	java.sql.Date openTime;
	java.sql.Date closeTime;
	@Column(columnDefinition = "LONGBLOB")
	byte[] photo;

	@OneToMany
	private Collection<Food> foods;
	@OneToMany
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public java.sql.Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(java.sql.Date openTime) {
		this.openTime = openTime;
	}
	public java.sql.Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(java.sql.Date closeTime) {
		this.closeTime = closeTime;
	}
	public Collection<Food> getFoods() {
		return foods;
	}
	public void setFoods(Collection<Food> foods) {
		this.foods = foods;
	}
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
}
