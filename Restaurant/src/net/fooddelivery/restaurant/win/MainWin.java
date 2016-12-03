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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
public class MainWin {

	private JFrame frame;
	public static ResManagement resman;
	public JLabel ResName,ResPhoto,ResAdd,ResDes,ResTime,DelFee;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ResName = new JLabel("New label");
		ResName.setHorizontalAlignment(SwingConstants.CENTER);
		ResName.setFont(new Font("Gill Sans MT", Font.PLAIN, 40));
		ResName.setBounds(387, 13, 209, 62);
		frame.getContentPane().add(ResName);
		ResName.setText(resman.res.getName());
		
		ResPhoto = new JLabel("New label");
		ResPhoto.setBounds(63, 37, 150, 150);
		frame.getContentPane().add(ResPhoto);
		ImageIcon temp=new ImageIcon(resman.res.getPhoto());
		ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(ResPhoto.getWidth(), ResPhoto.getHeight(), Image.SCALE_DEFAULT));
		ResPhoto.setIcon(icon);
		
		ResDes = new JLabel("New label");
		ResDes.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		ResDes.setBounds(746, 81, 204, 18);
		frame.getContentPane().add(ResDes);
		ResDes.setText(resman.res.getDescription());
		
		ResAdd = new JLabel("New label");
		ResAdd.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		ResAdd.setBounds(746, 126, 209, 18);
		frame.getContentPane().add(ResAdd);
		ResAdd.setText(resman.res.getAddress());
		
		ResTime = new JLabel("New label");
		ResTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		ResTime.setBounds(746, 228, 181, 18);
		frame.getContentPane().add(ResTime);
		ResTime.setText(resman.res.getOpenTime()+"-"+resman.res.getCloseTime());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resman.OpenUpdateResWin();
			}
		});
		btnUpdate.setBounds(848, 259, 113, 27);
		frame.getContentPane().add(btnUpdate);
		
		
		DelFee = new JLabel("New label");
		DelFee.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		DelFee.setBounds(746, 175, 72, 18);
		frame.getContentPane().add(DelFee);
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		tabbedPane.setBounds(73, 307, 877, 517);
		frame.getContentPane().add(tabbedPane);
		orderPanel=new OrderPanel(resman);
		tabbedPane.addTab("Orders", orderPanel);
		foodPanel=new FoodPanel(resman);
		tabbedPane.addTab("Foods", foodPanel);
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
