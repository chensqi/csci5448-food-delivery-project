package net.fooddelivery.restaurant.win;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
import java.util.List;
import java.util.Iterator;

public class OrderPanel extends JPanel {
	public JList orderList;
	public ResManagement resman;
	public OrderPanel(ResManagement r){
		this.setSize(800,500);
		this.setLayout(null);
		resman=r;
		orderList=new JList();
		JScrollPane scr=new JScrollPane(orderList);
		this.add(scr);
		scr.setBounds(0, 0, 800, 470);
		OrderCell cell=new OrderCell();
		orderList.setCellRenderer(cell);
		orderList.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		orderList.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){  
		        if(e.getClickCount()==2){   //When double click JList  
		            DuoClick(orderList.getSelectedValue());   //Event  
		        }  
		    }  
		});
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
	private void DuoClick(Object value){
		int index=orderList.getSelectedIndex();
		Order o=(Order) value;
		OrderManagement oman=new OrderManagement(o,this);
		UpdateOrderWin win=new UpdateOrderWin(oman);
		win.show();
		if(index>=0) orderList.setSelectedIndex(index);
	}
}
