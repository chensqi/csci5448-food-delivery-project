package net.fooddelivery.restaurant.models;
import java.util.Collection;

import javax.persistence.*;
@Entity
@Table( name = "ResLog" )
public class ResLog {
	@Id
	String username;
	String password;
	int	 resId;

}
