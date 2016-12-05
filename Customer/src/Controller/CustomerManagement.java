package Controller;

import java.util.List;

import Models.Customer;

public class CustomerManagement {
	/*
	 * Check if there exists matched loginName and password
	 */
	static public boolean checkExist(String loginName, String password) {
		List r = DBconnector.list("FROM Customer WHERE loginName = " 
	+ "\'" + loginName + "\'" 
	+ " AND password = " 
	+ "\'" + password + "\'"
	);
		return r.size() == 1 ;
	}
	/*
	 * Fetch a customer
	 */
	static public Customer fetchCustomer(String loginName) {
		List r = DBconnector.list("FROM Customer WHERE loginName = " 
				+ "\'" + loginName + "\'");
		if ( r.size() == 0 ) return null ;
		return (Customer) r.get(0);
	}
	/*
	 * Check if there exists matched loginName
	 */
	static public boolean checkExist(String loginName) {
		
		List r = DBconnector.list("FROM Customer WHERE loginName = " 
		+ "\'" + loginName + "\'");
		return r.size() == 1;
	}
	
	static public boolean register(Customer c) {
		if ( checkExist(c.getLoginName()) ) 
			return false ;
		DBconnector.persist(c);
		return true;
	}
}
