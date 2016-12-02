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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainWin {

	private JFrame frame;
	public static ResManagement resman;
	public JLabel ResName,ResPhoto,ResAdd,ResDes,ResTime,DelFee;

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
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(63, 299, 300, 361);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(650, 299, 300, 361);
		frame.getContentPane().add(list_1);
		
		ResName = new JLabel("New label");
		ResName.setHorizontalAlignment(SwingConstants.CENTER);
		ResName.setFont(new Font("Gill Sans MT", Font.PLAIN, 40));
		ResName.setBounds(374, 37, 209, 62);
		frame.getContentPane().add(ResName);
		ResName.setText(resman.res.getName());
		
		ResPhoto = new JLabel("New label");
		ResPhoto.setBounds(63, 37, 150, 150);
		frame.getContentPane().add(ResPhoto);
		ImageIcon icon = new ImageIcon(resman.res.getPhoto());
		ResPhoto.setIcon(icon);
		
		ResDes = new JLabel("New label");
		ResDes.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResDes.setBounds(719, 81, 204, 18);
		frame.getContentPane().add(ResDes);
		ResDes.setText(resman.res.getDescription());
		
		ResAdd = new JLabel("New label");
		ResAdd.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResAdd.setBounds(719, 133, 209, 18);
		frame.getContentPane().add(ResAdd);
		ResAdd.setText(resman.res.getAddress());
		
		ResTime = new JLabel("New label");
		ResTime.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		ResTime.setBounds(719, 221, 181, 18);
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
		DelFee.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		DelFee.setBounds(719, 180, 72, 18);
		frame.getContentPane().add(DelFee);
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
	}
	public void refresh(){
		ResName.setText(resman.res.getName());
		ImageIcon icon = new ImageIcon(resman.res.getPhoto());
		ResPhoto.setIcon(icon);
		ResDes.setText(resman.res.getDescription());
		ResAdd.setText(resman.res.getAddress());
		ResTime.setText(resman.res.getOpenTime()+"-"+resman.res.getCloseTime());
		DelFee.setText(Double.toString(resman.res.getDeliverFee()));
	}
}
