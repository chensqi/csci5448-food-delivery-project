package Controller;

import java.util.List;

import Models.Customer;

public class RestaurantManagement {
	static public List fetchAllRestaurants() {
		List r = DBconnector.list("FROM Restaurant" );
		return r;
	}
}
