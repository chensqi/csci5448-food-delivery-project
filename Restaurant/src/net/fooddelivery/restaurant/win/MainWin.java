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
		list.setBounds(82, 228, 204, 361);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(729, 228, 204, 361);
		frame.getContentPane().add(list_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(437, 37, 209, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(685, 140, 183, 36);
		frame.getContentPane().add(textArea);
		
		JLabel ResPhoto = new JLabel("New label");
		ResPhoto.setBounds(766, 18, 100, 100);
		frame.getContentPane().add(ResPhoto);
		ImageIcon icon = new ImageIcon(resman.res.getPhoto());
		ResPhoto.setIcon(icon);
	}
}
