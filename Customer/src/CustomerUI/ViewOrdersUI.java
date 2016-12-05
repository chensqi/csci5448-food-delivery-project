package CustomerUI;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import Controller.GetCurrentCustomer;
import Controller.OrderManagement;
import Models.Order;

public class ViewOrdersUI extends JFrame{
	private JButton gobackButton = new JButton("Go back ");
	ActionListener goBackListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	use log out
			dispose();
			SelectRestaurantMenuUI UI = new SelectRestaurantMenuUI();
			UI.run();
		}
	};
	void showOrderDetail(Order o) {
		dispose();
		ViewOrderDetailUI UI = new ViewOrderDetailUI(o);
		UI.run();
	}
	
	void run() {
		setTitle("View orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		setVisible(true);
		
		int width = this.getWidth();	//	width of panel1 and panel3
		int height = 10;	//	height of panel1 and panel3
		
		Vector<Order> orders = OrderManagement.fetchAllOrdersOfCustomer( GetCurrentCustomer.getCustomer() );
		
		Panel p1 = new Panel(); // Go back
		JScrollPane p2 = new JScrollPane( new OrderList(orders, this) );

		gobackButton.addActionListener(goBackListener);
		p1.add(gobackButton);
		p1.setSize(width, height);	//	update profile
		p1.setMaximumSize(p1.getPreferredSize());
		
		add(p1);
		add(p2);
		
		setMinimumSize( new Dimension(1200, 500));
		
		pack();
	}
}
