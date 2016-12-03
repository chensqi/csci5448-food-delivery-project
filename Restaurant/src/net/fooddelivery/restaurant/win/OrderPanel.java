package net.fooddelivery.restaurant.win;
import javax.swing.*;
import java.awt.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
import java.util.List;
import java.util.Iterator;

public class OrderPanel extends JPanel {
	public JList orderList;
	public ResManagement resman;
	public OrderPanel(ResManagement r){
		resman=r;
		orderList=new JList();
		this.add(new JScrollPane(orderList));
		OrderCell cell=new OrderCell();
		orderList.setCellRenderer(cell);
		orderList.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		reload();
		
	}
	public void reload(){
		List<Order> l=resman.fetchOrders();
		Iterator<Order> it=l.iterator();
		DefaultListModel<Order> lm=new DefaultListModel<>();
		while(it.hasNext()){
			lm.addElement(it.next());
		}
		orderList.setModel(lm);
	}
}
