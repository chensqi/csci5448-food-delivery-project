package CustomerUI;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.rmi.CORBA.UtilDelegate;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.DBconnector;
import Controller.FoodManagemenet;
import Controller.GetCurrentCustomer;
import Models.Food;
import Models.Order;
import Models.Restaurant;
import Models.ShoppingCartEntity;

public class SelectFoodMenuUI extends JFrame {
	Restaurant r ;
	private JButton goBackButton = new JButton("Go back");
	private JButton orderButton = new JButton("Order");
	Vector<ShoppingCartEntity> sc = new Vector<ShoppingCartEntity>();
	JScrollPane p4;
	Dimension size_p4;
	
	ActionListener orderListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	use log out
			Order order = new Order();
			List<Food> foods = new Vector<Food>();
			
			for ( int i = 0 ; i < sc.size() ; ++i ) {
				for ( int j = 0 ; j < sc.get(i).getQuantity() ; ++j )
						foods.add( sc.get(i).getFood() );
			}
			
			order.setCustomer(GetCurrentCustomer.getCustomer());
			order.setRestaurant(r);
			order.setFoods(foods);
			order.setDest(GetCurrentCustomer.getCustomer().getAddress());
			order.setOrderStatus(0);
			java.util.Date today = new java.util.Date();
			order.setTime(today);
			if ( DBconnector.persist(order) ) {
				JOptionPane.showMessageDialog(getContentPane(),"Submit order success!");
				dispose();
				ViewOrdersUI UI = new ViewOrdersUI();
				UI.run();
			}
			else {
				JOptionPane.showMessageDialog(getContentPane(),"Submit order fail!");
			}
		}
	};
	ActionListener goBackListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	use log out
			dispose();
			SelectRestaurantMenuUI UI = new SelectRestaurantMenuUI();
			UI.run();
		}
	};
	
	
	public SelectFoodMenuUI( Restaurant r ) {
		this.r = r;
	}
	void newP4(boolean flag) {	//	flag is false when call this in constructor
		
		p4 = new JScrollPane( new CartList(sc, this) );	//	shopping cart
		if ( flag )
			p4.setPreferredSize(size_p4);
		p4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(p4,BorderLayout.LINE_END);
		pack();
		if ( !flag )
			size_p4 = p4.getSize();

	}
	void addFoodIntoCart( Food f ) {
		getContentPane().remove(p4);
		
		for ( int i = 0 ; i < sc.size() ; i++ ) {
			if ( sc.get(i).getFood().equals(f)) {
				sc.get(i).addOne();
				newP4(true);
				return ;
			}
		}
		sc.add( new ShoppingCartEntity(f) );
		newP4(true);
	}
	void removeCartEntity( ShoppingCartEntity e ) {
		getContentPane().remove(p4);
		sc.remove(e);
		newP4(true);
	}
	
	void run() {
		setTitle("Menu of " + r.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		Vector<Food> foods = FoodManagemenet.fetchAllFoodsFromRestaurant(this.r);
		FoodList foodList = new FoodList(foods,this);
		
		Panel p1 = new Panel(); // back to Restaurant
		JScrollPane p2 = new JScrollPane( foodList );	//	food lists
		Panel p3 = new Panel();	// logout
		
		int width = this.getWidth();	//	width of panel1 and panel3
		int height = 10;	//	height of panel1 and panel3
		
		p1.add(goBackButton);
		p2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p3.add(orderButton);
		
		goBackButton.addActionListener(goBackListener);
		orderButton.addActionListener(orderListener);
		
		p1.setSize(width, height);	//	update profile
		p1.setMaximumSize(p1.getPreferredSize());
		p3.setSize(width, height);	//	log out
		p3.setMaximumSize(p3.getPreferredSize());
		
		setMinimumSize( new Dimension(1200, 500));
		
		
		add(p1,BorderLayout.PAGE_START);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.PAGE_END);
		newP4(false);
		pack();
		setLocationRelativeTo(null);

	}
}
