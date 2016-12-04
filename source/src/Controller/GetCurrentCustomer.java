package Controller;
import Models.Customer;

public class GetCurrentCustomer {
	static Customer customer = null;

	static public Customer getCustomer() {
		return customer;
	}

	static public void setCustomer(Customer _customer) {
		customer = _customer;
	}
}
