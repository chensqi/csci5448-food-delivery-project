package CustomerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.CustomerManagement;
import Controller.DBconnector;
import Controller.GetCurrentCustomer;
import Models.Customer;

public class CustomerUpdateUI extends CustomerRegisterOrUpdateUI {

	@Override
	public ActionListener getSubmitListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer c = getCustomerFromTextFields();
				Customer me = GetCurrentCustomer.getCustomer();
				
				if ( c.getLoginName() != null ) {
					JOptionPane.showMessageDialog(getContentPane(),"Cannot modify login name!");
					pack();
					return ;
				}
				c.setLoginName(me.getLoginName());
				DBconnector.update(c);
				
				if ( CustomerManagement.register(c) == false ) {
					JOptionPane.showMessageDialog(getContentPane(),"LoginName exist!");
					pack();
				}
				else {	// register success and login
					JOptionPane.showMessageDialog(getContentPane(),"Register success!");
					dispose();
					
					SelectRestaurantMenuUI UI = new SelectRestaurantMenuUI();
					UI.run();
				}
			}
		};
	}

	@Override
	public String getSubmitButtonString() {
		return "Update profile";
	}

	@Override
	public boolean updateUI() {
		return true;
	}
	
}
