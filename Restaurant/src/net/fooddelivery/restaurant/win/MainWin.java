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
import java.awt.Font;
import javax.swing.SwingConstants;
public class MainWin {

	private JFrame frame;
	public static ResManagement resman;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(63, 245, 209, 361);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(743, 267, 204, 361);
		frame.getContentPane().add(list_1);
		
		JLabel ResName = new JLabel("New label");
		ResName.setHorizontalAlignment(SwingConstants.CENTER);
		ResName.setFont(new Font("Gill Sans MT", Font.PLAIN, 40));
		ResName.setBounds(394, 37, 209, 62);
		frame.getContentPane().add(ResName);
		ResName.setText(resman.res.getName());
		
		JLabel ResPhoto = new JLabel("New label");
		ResPhoto.setBounds(63, 37, 150, 150);
		frame.getContentPane().add(ResPhoto);
		ImageIcon icon = new ImageIcon(resman.res.getPhoto());
		ResPhoto.setIcon(icon);
		
		JLabel ResDes = new JLabel("New label");
		ResDes.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResDes.setBounds(766, 89, 204, 18);
		frame.getContentPane().add(ResDes);
		ResDes.setText(resman.res.getDescription());
		
		JLabel ResAdd = new JLabel("New label");
		ResAdd.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResAdd.setBounds(766, 137, 209, 18);
		frame.getContentPane().add(ResAdd);
		ResAdd.setText(resman.res.getAddress());
		
		JLabel ResTime = new JLabel("New label");
		ResTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResTime.setBounds(766, 186, 181, 18);
		frame.getContentPane().add(ResTime);
		ResTime.setText(resman.res.getOpenTime()+"-"+resman.res.getCloseTime());
	}
}
