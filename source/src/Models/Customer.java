package Models;

import java.util.Collection;

import javax.persistence.*;
@Entity
public class Customer {
	@Id
	int id;
	String name;
	String loginName;
	String password;
	@ManyToMany
	private Collection<Order> orders;
}
