package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.models.*;
import net.fooddelivery.restaurant.win.*;
import java.awt.Image;
import java.awt.Point;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import javassist.tools.framedump;
public class MainWin {

	private JFrame frmLogIn;
	public static ResManagement resman;
	public JLabel ResName,ResPhoto,ResDes,ResTime,DelFee;
	public JTextArea ResAdd;
	public OrderPanel orderPanel;
	public FoodPanel foodPanel;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}
	public static void setManagement(Restaurant r){
		resman=new ResManagement(r);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		resman.setMainwin(this);
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Restaurant Management");
		final int width=1024;
		final int height=900;
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    frmLogIn.setBounds(p.x - width / 2, p.y - height / 2, 885, 684); 
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		ResName = new JLabel("New label");
		ResName.setHorizontalAlignment(SwingConstants.CENTER);
		ResName.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		ResName.setBounds(296, 13, 191, 49);
		frmLogIn.getContentPane().add(ResName);
		ResName.setText(resman.res.getName());
		
		ResPhoto = new JLabel("New label");
		ResPhoto.setBounds(63, 37, 120, 120);
		frmLogIn.getContentPane().add(ResPhoto);
		ImageIcon temp=new ImageIcon(resman.res.getPhoto());
		ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(ResPhoto.getWidth(), ResPhoto.getHeight(), Image.SCALE_DEFAULT));
		ResPhoto.setIcon(icon);
		
		ResDes = new JLabel("New label");
		ResDes.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		ResDes.setBounds(621, 54, 204, 18);
		frmLogIn.getContentPane().add(ResDes);
		ResDes.setText(resman.res.getDescription());
		
		ResAdd = new JTextArea("New label");
		ResAdd.setEditable(false);
		ResAdd.setBackground(UIManager.getColor("Label.background"));
		ResAdd.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		ResAdd.setBounds(621, 86, 246, 61);
		frmLogIn.getContentPane().add(ResAdd);
		ResAdd.setText(resman.res.getAddress());
		ResAdd.setLineWrap(true);        //激活自动换行功能 
		ResAdd.setWrapStyleWord(true); 
		
		ResTime = new JLabel("New label");
		ResTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		ResTime.setBounds(621, 197, 181, 18);
		frmLogIn.getContentPane().add(ResTime);
		ResTime.setText(resman.res.getOpenTime()+"-"+resman.res.getCloseTime());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resman.OpenUpdateResWin();
			}
		});
		btnUpdate.setBounds(712, 244, 113, 27);
		frmLogIn.getContentPane().add(btnUpdate);
		
		
		DelFee = new JLabel("New label");
		DelFee.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		DelFee.setBounds(621, 166, 72, 18);
		frmLogIn.getContentPane().add(DelFee);
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		tabbedPane.setBounds(63, 272, 739, 345);
		frmLogIn.getContentPane().add(tabbedPane);
		foodPanel=new FoodPanel(resman);
		foodPanel.setSize(739, 320);
		tabbedPane.addTab("Foods", foodPanel);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		lblDescription.setBounds(478, 54, 129, 18);
		frmLogIn.getContentPane().add(lblDescription);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		lblAddress.setBounds(478, 87, 129, 18);
		frmLogIn.getContentPane().add(lblAddress);
		
		JLabel lblDeliverFee = new JLabel("Deliver Fee:");
		lblDeliverFee.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		lblDeliverFee.setBounds(478, 166, 129, 18);
		frmLogIn.getContentPane().add(lblDeliverFee);
		
		JLabel lblOpenTime = new JLabel("Open Time:");
		lblOpenTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 16));
		lblOpenTime.setBounds(478, 199, 129, 18);
		frmLogIn.getContentPane().add(lblOpenTime);
		orderPanel=new OrderPanel(resman);
		orderPanel.setSize(739, 320);
		tabbedPane.addTab("Orders", orderPanel);
		orderRefersh orderRe=new orderRefersh(orderPanel);
		orderRe.start();
	}
	public void refresh(){
		ResName.setText(resman.res.getName());
		ImageIcon temp=new ImageIcon(resman.res.getPhoto());
		ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(ResPhoto.getWidth(), ResPhoto.getHeight(), Image.SCALE_DEFAULT));
		ResPhoto.setIcon(icon);
		ResDes.setText(resman.res.getDescription());
		ResAdd.setText(resman.res.getAddress());
		ResTime.setText(resman.res.getOpenTime()+"-"+resman.res.getCloseTime());
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
	}

}
class orderRefersh extends Thread{
	private OrderPanel orderPanel;
	public orderRefersh(OrderPanel op){
		orderPanel=op;
	}
	public void run() {
		try {
			while(true){ 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
