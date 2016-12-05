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
import Models.Customer;

public abstract class CustomerRegisterOrUpdateUI extends JFrame {
	TextField loginnameTextField = new TextField(30);
	TextField usernameTextField = new TextField(30);
	TextField phoneTextField = new TextField(30);
	JPasswordField passwordTextField= new JPasswordField(20);
	TextField addressTextField = new TextField(30);
	
	Label loginnameLabel = new Label("Loginname");
	Label passwordLabel = new Label("Password");
	Label usernameLabel = new Label("Username");
	Label phoneLabel = new Label("Phone");
	Label addressLabel = new Label("Address");
	
	
	private JButton submitButton = new JButton( getSubmitButtonString() );
	private JButton cancelButton = new JButton("Exit");
	
	ActionListener submitListener = getSubmitListener();
	ActionListener cancelListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	
	abstract public ActionListener getSubmitListener();
	abstract public String getSubmitButtonString() ;
	abstract public boolean updateUI();
	
	public Customer getCustomerFromTextFields() {
		Customer c = new Customer();
		if ( loginnameTextField.getText().length() > 0 ) c.setLoginName(loginnameTextField.getText());
		if ( passwordTextField.getText().length() > 0 ) c.setPassword(passwordTextField.getText());
		if ( usernameTextField.getText().length() > 0 ) c.setName(usernameTextField.getText());
		if ( phoneTextField.getText().length() > 0 ) c.setPhone(phoneTextField.getText());
		if ( addressTextField.getText().length() > 0 ) c.setAddress(addressTextField.getText());
		return c;
	}
	
	void run() {
		setTitle("Customer register");
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
		panel3.add(usernameLabel);
		panel3.add(usernameTextField);
		
		Panel panel4 = new Panel();
		panel4.add(phoneLabel);
		panel4.add(phoneTextField);
		
		Panel panel5 = new Panel();
		panel5.add(addressLabel);
		panel5.add(addressTextField);
		
		Panel panelButtons = new Panel();
		panelButtons.add(submitButton);
		panelButtons.add(cancelButton);
		submitButton.addActionListener(submitListener);
		cancelButton.addActionListener(cancelListener);
		
		
		if ( !updateUI() ) add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panelButtons);
		pack();
	}
}
