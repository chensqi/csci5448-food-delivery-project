package net.fooddelivery.restaurant.models;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import net.fooddelivery.restaurant.models.*;
@Entity
@Table( name = "Orders" )
public class Order {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
	private String destination;
	private java.sql.Date time;
	private int orderStatus;
	
  /*  @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
//      �����м����
      name="Order_Food",
//      ָ����ǰ��������,�������м����������
      joinColumns={@JoinColumn(name="Order_Id")},
//      ָ��������������,��һ�������м���������ơ�
      inverseJoinColumns={@JoinColumn(name="Food_Id")}
     )*/
	@ManyToMany
	private Collection<Food> foods;
	@OneToOne
	private Customer customer;
	@OneToOne
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
