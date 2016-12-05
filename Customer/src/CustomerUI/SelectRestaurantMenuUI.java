package CustomerUI;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import Controller.GetCurrentCustomer;
import Controller.RestaurantManagement;
import Models.Location;
import Models.Restaurant;

public class SelectRestaurantMenuUI extends JFrame{
	
	private JButton updateProfileButton = new JButton("Welcome, "
	+ GetCurrentCustomer.getCustomer().getName()
	+ "! Update user profile");
	private JButton logOutButton = new JButton("log out");
	ActionListener updateProfileListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	switch into update profile
			dispose();
			CustomerUpdateUI UI = new CustomerUpdateUI();
			UI.run();
		}
	};
	ActionListener logOutListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	use log out
			dispose();
			GetCurrentCustomer.setCustomer(null);
			LoginUI UI = new LoginUI();
			UI.run();
		}
	};
	void selectRestaurant( Restaurant r ) {
		dispose();
		SelectFoodMenuUI UI = new SelectFoodMenuUI(r);
		UI.run();
	}
	
	void run() {
		setTitle("Choose restaurant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		setVisible(true);
		
		Vector<Restaurant> r = new Vector<Restaurant>();
		List t = RestaurantManagement.fetchAllRestaurants();
		for ( Iterator it = t.iterator(); it.hasNext() ; ) {
			r.add((Restaurant) it.next());
		}
		
		Panel p1 = new Panel(); // update user profile
		JScrollPane p2 = new JScrollPane( new RestaurantList(r, this) );
		Panel p3 = new Panel();	// logout
		
		int width = this.getWidth();	//	width of panel1 and panel3
		int height = 10;	//	height of panel1 and panel3
		
		p1.add(updateProfileButton);
		p2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p3.add(logOutButton);
		
		updateProfileButton.addActionListener(updateProfileListener);
		logOutButton.addActionListener(logOutListener);
		
		p1.setSize(width, height);	//	update profile
		p1.setMaximumSize(p1.getPreferredSize());
		p3.setSize(width, height);	//	log out
		p3.setMaximumSize(p3.getPreferredSize());

		
		add(p1);
		add(p2);
		add(p3);
		
		setMinimumSize( new Dimension(1200, 500));
		
		pack();
	}
}
