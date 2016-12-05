package CustomerUI;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Models.Order;

public class ViewOrderDetailUI extends JFrame {
	Order o ;
	private JButton gobackButton = new JButton("Go back ");
	
	ActionListener goBackListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	use log out
			dispose();
			ViewOrdersUI UI = new ViewOrdersUI();
			UI.run();
		}
	};
	
	public ViewOrderDetailUI(Order o ) {
		this.o = o ;
	}
	
	void run() {
		setTitle("View orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		setVisible(true);
		
		JTextArea textArea = new JTextArea(5, 30);
		textArea.setText("Restaurant name: " + o.getRestaurant().getName() + "\n"
				+ "Delivery destination: " + o.getDest() + "\n"
				+ "Order time: " + o.getTime() + "\n"
				+ "Foods:" + "\n" + o.getfoodsString());
		
		
		Panel p1 = new Panel(); // Go back
		JScrollPane p2 = new JScrollPane(textArea); // Show Details
		
		
		gobackButton.addActionListener(goBackListener);
		p1.add(gobackButton );
		
		add(p1);
		add(p2);
		
		pack();

	}
}
