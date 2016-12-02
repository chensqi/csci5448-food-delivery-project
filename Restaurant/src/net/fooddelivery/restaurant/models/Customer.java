package net.fooddelivery.restaurant.models;
import java.util.Collection;

import javax.persistence.*;
@Entity
public class Customer {
	@Id
	private int id;
	private String name;
	private String loginName;
	private String password;
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
}
