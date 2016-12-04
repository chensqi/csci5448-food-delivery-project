package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.SwingConstants;

import net.fooddelivery.restaurant.func.OrderManagement;
import net.fooddelivery.restaurant.models.Food;
import net.fooddelivery.restaurant.models.Order;

import javax.net.ssl.HostnameVerifier;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class UpdateOrderWin {

	private JFrame frmUpdateOrder;
	private JLabel name,time,address,status;
	private JTextArea detail;
	private JButton btnDeliver,btnCancelOrder;
	public OrderManagement oman;
	private JLabel lblPhone;
	private JLabel phone;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOrderWin window = new UpdateOrderWin(oman);
					window.frmUpdateOrder.setVisible(true);
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
		frmUpdateOrder = new JFrame();
		frmUpdateOrder.setTitle("Update Order");
		final int width=800;
		final int height=600;
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    frmUpdateOrder.setBounds(p.x - width / 2, p.y - height / 2, width, height); 
		frmUpdateOrder.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmUpdateOrder.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblNewLabel.setBounds(88, 47, 153, 18);
		frmUpdateOrder.getContentPane().add(lblNewLabel);
		
		name = new JLabel("Customer Name:");
		name.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		name.setBounds(342, 47, 153, 18);
		frmUpdateOrder.getContentPane().add(name);
		
		JLabel lblOrderTime = new JLabel("Order Time:");
		lblOrderTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderTime.setBounds(88, 151, 153, 18);
		frmUpdateOrder.getContentPane().add(lblOrderTime);
		
		time = new JLabel("Customer Name:");
		time.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		time.setBounds(342, 151, 300, 18);
		frmUpdateOrder.getContentPane().add(time);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblAddress.setBounds(88, 205, 153, 18);
		frmUpdateOrder.getContentPane().add(lblAddress);
		
		JLabel lblOrderStatus = new JLabel("Order Status:");
		lblOrderStatus.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderStatus.setBounds(88, 260, 153, 18);
		frmUpdateOrder.getContentPane().add(lblOrderStatus);
		
		address = new JLabel("Customer Name:");
		address.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		address.setBounds(342, 205, 317, 18);
		frmUpdateOrder.getContentPane().add(address);
		
		status = new JLabel("Customer Name:");
		status.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		status.setBounds(342, 260, 153, 18);
		frmUpdateOrder.getContentPane().add(status);
		
		JLabel lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblOrderDetails.setBounds(88, 318, 153, 18);
		frmUpdateOrder.getContentPane().add(lblOrderDetails);
		
		detail = new JTextArea("Customer Name:");
		detail.setBackground(UIManager.getColor("Label.background"));
		detail.setEditable(false);
		detail.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		detail.setBounds(342, 307, 239, 151);
		frmUpdateOrder.getContentPane().add(detail);
		
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
				frmUpdateOrder.dispose();
				//reload();
			}
		});
		btnDeliver.setBounds(470, 491, 144, 27);
		frmUpdateOrder.getContentPane().add(btnDeliver);
		
		btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int n = JOptionPane.showConfirmDialog(null,"Are you Sure to Cancel this Order?","Confirm Cancel", JOptionPane.YES_NO_OPTION);
		        if(n==JOptionPane.YES_OPTION){			        
					oman.changeStatus(4);
					reload();
					frmUpdateOrder.dispose();
					JOptionPane.showMessageDialog(null, "The Order has been Cancelled.", "Success!", JOptionPane.INFORMATION_MESSAGE);

		        }
		        else if(n==JOptionPane.NO_OPTION){
		        	
		        }

			}
		});
		btnCancelOrder.setBounds(624, 491, 144, 27);
		frmUpdateOrder.getContentPane().add(btnCancelOrder);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblPhone.setBounds(88, 99, 153, 18);
		frmUpdateOrder.getContentPane().add(lblPhone);
		
		phone = new JLabel("Order Time:");
		phone.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		phone.setBounds(342, 101, 153, 18);
		frmUpdateOrder.getContentPane().add(phone);
		reload();
	}
	private void reload(){
		name.setText(oman.order.getCustomer().getName());
		address.setText(oman.order.getDestination());
		time.setText(oman.order.getTime().toString());
		phone.setText(oman.order.getCustomer().getPhone());
		int sta=oman.order.getOrderStatus();
		switch (sta) {
		case 0:
			status.setText("Waiting");
			btnDeliver.setText("Deliver");
			break;
		case 1:
			status.setText("Delivering");
			btnDeliver.setText("Delivered");
			btnCancelOrder.setEnabled(false);
			break;
		case 2:
			status.setText("Delivered");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			btnCancelOrder.setEnabled(false);
			break;
		case 3:
			status.setText("Completed");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			btnCancelOrder.setEnabled(false);
			break;
		case 4:
			status.setText("Cancelled");
			btnDeliver.setText("Delivered");
			btnDeliver.setEnabled(false);
			btnCancelOrder.setEnabled(false);
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
		String text="";
		for (Entry<Food, Integer> entry : mp.entrySet()) {
		    text+=entry.getKey().getName()+" X"+entry.getValue().toString()+"\n";
		}
		detail.setText("");
		

	}

}
