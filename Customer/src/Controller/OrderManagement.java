package Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Models.Customer;
import Models.Order;

public class OrderManagement {
	static public Vector<Order> fetchAllOrders() {
		List r = DBconnector.list("FROM Order" );
		Vector<Order> res = new Vector<Order>();
		for ( Iterator it = r.iterator() ; it.hasNext() ; )
			res.add((Order)it.next());
		return res ;
	}
	static public Vector<Order> fetchAllOrdersOfCustomer(Customer c) {
		List r = DBconnector.list("FROM Order WHERE customer_id = " + c.getId() );
		Vector<Order> res = new Vector<Order>();
		for ( Iterator it = r.iterator() ; it.hasNext() ; )
			res.add((Order)it.next());
		return res ;
	}
}
