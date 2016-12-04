package Models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Orders")
@GenericGenerator(name="increment", strategy = "increment")
public class Order {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	int id;
	String destination;
	@Temporal(TemporalType.TIMESTAMP)
	java.util.Date time;
	int orderStatus;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
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
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public Customer getCustomers() {
		return customer;
	}
	public String getDest() {
		return destination;
	}
	public void setDest(String dest) {
		this.destination = dest;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCustomers(Customer customers) {
		this.customer = customers;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getfoodsString() {
		
		if ( foods == null || foods.isEmpty() ) return "";
		
		java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();
		for ( Iterator<Food> it = foods.iterator() ; it.hasNext() ; ) {
			String food = it.next().getName();
			int v ;
			if ( !map.containsKey(food) )
				v = 0 ;
			else
				v = map.get(food);
			map.put(food, v+1);
		}
		String res = "";
		for ( Iterator<Entry<String, Integer>> it = map.entrySet().iterator() ; it.hasNext() ; ) {
			Entry<String, Integer> t = it.next();
			res += t.getKey() + ", quantity: " + t.getValue() + "\n";
		}
		return res ;
	}
}
