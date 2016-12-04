package net.fooddelivery.restaurant.func;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.fooddelivery.restaurant.models.Order;
import net.fooddelivery.restaurant.win.OrderPanel;

public class OrderManagement {
	public Order order;
	public OrderPanel op;
	public OrderManagement(Order o,OrderPanel p){
		order=o;
		op=p;
	}
	public void changeStatus(int status){
		order.setOrderStatus(status);
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.merge(order);
		tx.commit();
		session.close();
		op.reload();
	}
}
