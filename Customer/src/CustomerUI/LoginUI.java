package CustomerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.DBconnector;
import Controller.GetCurrentCustomer;
import Controller.CustomerManagement;

public class LoginUI extends JFrame{
	TextField loginnameTextField = new TextField(30);
	JPasswordField passwordTextField= new JPasswordField(20);
	Label loginnameLabel = new Label("Loginname");
	Label passwordLabel = new Label("Password");
	
	private JButton loginButton = new JButton("Log in");
	private JButton cancelButton = new JButton("Exit");
	private JButton registerButton = new JButton("Register");
	
	
	ActionListener registerListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			CustomerRegisterUI registerUI = new CustomerRegisterUI();
			registerUI.run();
		}
	};
	ActionListener loginListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	//	check loginname and password correct in db.
			//System.out.println("name: " + loginnameTextField.getText() );
			//System.out.println("password: " + passwordTextField.getText());
			if ( CustomerManagement.checkExist(loginnameTextField.getText(), passwordTextField.getText()) ) {	//	matched
				
				JOptionPane.showMessageDialog(getContentPane(),"Login success!");
				GetCurrentCustomer.setCustomer( CustomerManagement.fetchCustomer(loginnameTextField.getText()) );
				pack();
				dispose();
				SelectRestaurantMenuUI UI = new SelectRestaurantMenuUI();
				UI.run();
			}
			else {	//	Does not exists!
				
				JOptionPane.showMessageDialog(getContentPane(),"Invalid login name or pasword!");
				pack();
			}
		}
	};
	ActionListener cancelListener = new ActionListener() {	//	Close the window when click "Cancel"
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	void run() {
		setTitle("Customer login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		setVisible(true);
		
		Panel panel1 = new Panel();
		panel1.add(loginnameLabel);
		panel1.add(loginnameTextField);
		
		Panel panel2 = new Panel();
		panel2.add(passwordLabel);
		panel2.add(passwordTextField);
		
		Panel panel3 = new Panel();
		panel3.add(loginButton);
		panel3.add(cancelButton);
		panel3.add(registerButton);
		loginButton.addActionListener(loginListener);
		cancelButton.addActionListener(cancelListener);
		registerButton.addActionListener(registerListener);
		
		getContentPane().add(panel1);
		getContentPane().add(panel2);
		getContentPane().add(panel3);
		pack();
	}
}
