package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.fooddelivery.restaurant.func.OrderManagement;
import net.fooddelivery.restaurant.models.Food;
import net.fooddelivery.restaurant.models.Order;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;

public class UpdateOrderWin {

	private JFrame frame;
	private JLabel name,time,address,detail,status;
	private JButton btnDeliver,btnCancelOrder;
	public OrderManagement oman;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOrderWin window = new UpdateOrderWin(oman);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateOrderWin(OrderManagement oman) {
		this.oman=oman;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblNewLabel.setBounds(88, 47, 153, 18);
		frame.getContentPane().add(lblNewLabel);
		
		name = new JLabel("Customer Name:");
		name.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		name.setBounds(342, 47, 153, 18);
		frame.getContentPane().add(name);
		
		JLabel lblOrderTime = new JLabel("Order Time:");
		lblOrderTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderTime.setBounds(88, 113, 153, 18);
		frame.getContentPane().add(lblOrderTime);
		
		time = new JLabel("Customer Name:");
		time.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		time.setBounds(342, 113, 153, 18);
		frame.getContentPane().add(time);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblAddress.setBounds(88, 182, 153, 18);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblOrderStatus = new JLabel("Order Status:");
		lblOrderStatus.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderStatus.setBounds(88, 255, 153, 18);
		frame.getContentPane().add(lblOrderStatus);
		
		address = new JLabel("Customer Name:");
		address.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		address.setBounds(342, 182, 153, 18);
		frame.getContentPane().add(address);
		
		status = new JLabel("Customer Name:");
		status.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		status.setBounds(342, 255, 153, 18);
		frame.getContentPane().add(status);
		
		JLabel lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderDetails.setBounds(88, 325, 153, 18);
		frame.getContentPane().add(lblOrderDetails);
		
		detail = new JLabel("Customer Name:");
		detail.setHorizontalAlignment(SwingConstants.LEFT);
		detail.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		detail.setBounds(342, 310, 239, 151);
		frame.getContentPane().add(detail);
		
		btnDeliver = new JButton("New button");
		btnDeliver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sta=oman.order.getOrderStatus();
				switch (sta) {
				case 0:
					oman.changeStatus(1);
					break;
				case 1:
					oman.changeStatus(2);
					break;
				default:
					oman.changeStatus(1);
					break;
				}
				reload();
			}
		});
		btnDeliver.setBounds(470, 491, 144, 27);
		frame.getContentPane().add(btnDeliver);
		
		btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oman.changeStatus(4);
				reload();
			}
		});
		btnCancelOrder.setBounds(624, 491, 144, 27);
		frame.getContentPane().add(btnCancelOrder);
		reload();
	}
	private void reload(){
		name.setText(oman.order.getCustomer().getName());
		address.setText(oman.order.getDestination());
		time.setText(oman.order.getTime().toString());
		int sta=oman.order.getOrderStatus();
		switch (sta) {
		case 0:
			status.setText("Waiting");
			btnDeliver.setText("Deliver");
			break;
		case 1:
			status.setText("Delivering");
			btnDeliver.setText("Delivered");
			break;
		case 2:
			status.setText("Delivered");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			break;
		case 3:
			status.setText("Completed");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			break;
		case 4:
			status.setText("Cancelled");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			break;
		default:
			status.setText("Waiting");
			btnDeliver.setText("Deliver");
			break;
		}
		HashMap<Food, Integer> mp=new HashMap<Food,Integer>();
		List<Food> list=oman.order.getFoods();
		Iterator<Food> iterator=list.iterator();
		while(iterator.hasNext()){
			Food cur=iterator.next();
			if(!mp.containsKey(cur)){
				mp.put(cur, new Integer(1));
			}
			else mp.put(cur, mp.get(cur)+1);
		}
		String text="<html><body>";
		for (Entry<Food, Integer> entry : mp.entrySet()) {
		    text+="<b>"+entry.getKey().getName()+"</b> "+" X"+entry.getValue().toString()+"<br>";
		}
		text+="</body></html>";
		detail.setText(text);
		

	}

}
