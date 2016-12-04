package net.fooddelivery.restaurant.win;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.fooddelivery.restaurant.func.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginWin {

	private JFrame frmLogIn;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void show(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWin window = new LoginWin();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		final int width=450;
		final int height=300;
		Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    frmLogIn.setBounds(p.x - width / 2, p.y - height / 2, width, height); 
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Func.login(textField.getText(),passwordField.getPassword())==true) frmLogIn.dispose();
				else{
					JOptionPane.showMessageDialog(null, "Username or Password Wrong", "Warning!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(65, 186, 113, 27);
		frmLogIn.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(257, 186, 113, 27);
		frmLogIn.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(184, 64, 149, 24);
		frmLogIn.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(65, 67, 72, 18);
		frmLogIn.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(65, 113, 72, 18);
		frmLogIn.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 110, 149, 24);
		frmLogIn.getContentPane().add(passwordField);
	}
}
