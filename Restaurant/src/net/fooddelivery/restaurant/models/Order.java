package net.fooddelivery.restaurant.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.mapping.Bag;

import net.fooddelivery.restaurant.models.*;
@Entity
@Table( name = "Orders" )
@GenericGenerator(name="increment", strategy = "increment")
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
//      设置中间表名
      name="Order_Food",
//      指定当前对象的外键,本表在中间表的外键名称
      joinColumns={@JoinColumn(name="Order_Id")},
//      指定关联对象的外键,另一个表在中间表的外键名称。
      inverseJoinColumns={@JoinColumn(name="Food_Id")}
     )*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Orders_Food")
    @CollectionId(
        columns = @Column(name="ID"), 
        generator="increment", 
        type = @Type(type="int")
    )
	private List<Food> foods;
	@ManyToOne
	private Customer customer;
	@ManyToOne
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

	public Customer getCustomer() {
		return customer;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public List<Food> getFoods() {
		return foods;
	}
}
