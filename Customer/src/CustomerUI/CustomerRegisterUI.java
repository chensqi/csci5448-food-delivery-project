package CustomerUI;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Controller.CustomerManagement;
import Controller.GetCurrentCustomer;
import Models.Customer;

public class CustomerRegisterUI extends CustomerRegisterOrUpdateUI {
	
	@Override
	public ActionListener getSubmitListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer c = getCustomerFromTextFields();
				
				if ( c.getLoginName() == null || c.getPassword() == null || c.getName() == null ) {
					JOptionPane.showMessageDialog(getContentPane(),"Incomplete information!");
					pack();
				}
				
				else if ( CustomerManagement.register(c) == false ) {
					JOptionPane.showMessageDialog(getContentPane(),"LoginName exist!");
					pack();
				}
				else {	// register success and login
					JOptionPane.showMessageDialog(getContentPane(),"Register success! Log in now...");
					GetCurrentCustomer.setCustomer( CustomerManagement.fetchCustomer(c.getLoginName()) );
					//System.out.println( CustomerManagement.fetchCustomer(c.getLoginName()) );
					dispose();
					SelectRestaurantMenuUI UI = new SelectRestaurantMenuUI();
					UI.run();
				}
			}
		};
	}

	@Override
	public String getSubmitButtonString() {
		return "Register and login";
	}

	@Override
	public boolean updateUI() {
		return false;
	}
}
