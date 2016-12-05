package net.fooddelivery.adminmanagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerManagement implements ActionListener{
	
	
	Connection con;
	Statement stmt;
	String sql;
	ResultSet rs;
	StringBuffer sb = new StringBuffer();
	JTextField jtf2 = new JTextField(10);
	JTextField jtf3 = new JTextField(10);
	JTextField jtf4 = new JTextField(10);
	JTextField jtf7 = new JTextField(10);
	JTextField jtf5 = new JTextField(10);
	JTextField jtf6 = new JTextField(10);
	JTextField jtf8 = new JTextField(10);
	JTextField jtf9 = new JTextField(10);
	JTextArea jta10 = new JTextArea(50, 40);
	public void actionPerformed(ActionEvent e) {
	String str = e.getActionCommand();
	if ("Inquire".equals(str)) {
	//if check the button, go to method of searchEmp()
	searchEmp();
	} else if ("Add".equals(str)) {
	//if check the button，then go to method of addEmp()
	addEmp();
	} else if ("Ban".equals(str)) {
	//if check the button, go to method of alterEmp()
	alterEmp();
	} else if ("Amend".equals(str)) {
	//if check the button, go to method of deleteEmp()
	deleteEmp();
	}
	}
	//this is the constructor.
	CustomerManagement() {
	createGUI();
	connectToDataBase();

	alterEmp();
	}
	//connect to the database by using the method getConnection from the class of JdbcUtil.
	//find the class of JdbcUtil at the button of this page.
	public Connection connectToDataBase() {
	con = MysqlControll.getConnection();
	System.out.println(con);
	return con;
	}
	public void searchEmp() {
	jta10.setText("");//customer info list
	try {
	stmt = con.createStatement();
	// sql = "select * from Yueming where Password=" + jtf3.getText();
	// sql1="select * from Yueming where LastName ="+jtf3.getText();
	sql = "select * from Mstar where FirstName="
	+ jtf2.getText().toLowerCase().trim() + "or Password="
	+ jtf3.getText().toLowerCase().trim() + "or LastName="
	+ jtf4.getText().toLowerCase().trim() + "or PhoneNO.="
	+ jtf5.getText().toLowerCase().trim() + "or Postcode="
	+ jtf6.getText().toLowerCase().trim() + "or State="
	+ jtf7.getText().toLowerCase().trim() + "or City="
	+ jtf8.getText().toLowerCase().trim() + "or Adress="
	+ jtf9.getText().toLowerCase().trim();
	stmt.executeQuery(sql);
	rs = stmt.getResultSet();
	ResultSetMetaData meta = rs.getMetaData();
	int cols = meta.getColumnCount();
	while (rs.next()) {
	for (int i = 1; i <= cols; i++) {
	sb.append(" " + meta.getColumnName(i) + " =");
	sb.append(rs.getString(i));
	}
	sb.append("\n");
	jta10.setText(sb.toString());
	}
	} catch (SQLException e11) {
	e11.printStackTrace();
	}
	}
	public void addEmp() {
	try {
	stmt = con.createStatement();
	sql = "update Mstar values(" + jtf2.getText() + jtf3.getText()
	+ jtf4.getText() + jtf5.getText() + jtf6.getText()
	+ jtf7.getText() + jtf8.getText() + jtf9.getText() + ")";
	int i = stmt.getUpdateCount();
	if ((jtf2.getText() != null) && (jtf4.getText() != null)
	&& (jtf6.getText() != null) && (jtf7.getText() != null)) {
	stmt.executeUpdate(sql);
	jta10.setText("Successfully add to the table" + i + "items");
	} else {
	jta10.setText("Can not be NULL");
	}
	} catch (SQLException e1) {
	e1.printStackTrace();
	}
	}
	public void deleteEmp() {
	searchEmp();
	try {
	stmt = con.createStatement();
	sql = "delete from Mstar where FirstName="
	+ jtf2.getText().toLowerCase().trim() + "or Password="
	+ jtf3.getText().toLowerCase().trim() + "or LastName="
	+ jtf4.getText().toLowerCase().trim() + "or PhoneNO.="
	+ jtf5.getText().toLowerCase().trim() + "or Postcode="
	+ jtf6.getText().toLowerCase().trim() + "or State="
	+ jtf7.getText().toLowerCase().trim() + "or City="
	+ jtf8.getText().toLowerCase().trim() + "or Adress="
	+ jtf9.getText().toLowerCase().trim();
	stmt.executeUpdate(sql);
	int i = stmt.getUpdateCount();
	jta10.setText("Successfully Ban" + i + "items");
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	public void alterEmp() {
	searchEmp();
	sql = "update Mstar set FirstName="
	+ jtf2.getText().toLowerCase().trim() + "and Password"
	+ jtf3.getText().toLowerCase().trim() + "and LastName="
	+ jtf4.getText().toLowerCase().trim() + "and PhoneNO.="
	+ jtf5.getText().toLowerCase().trim() + "and Postcode="
	+ jtf6.getText().toLowerCase().trim() + "and State="
	+ jtf7.getText().toLowerCase().trim() + "and City="
	+ jtf8.getText().toLowerCase().trim() + "and Adress="
	+ jtf9.getText().toLowerCase().trim();
	int i = 0;
	try {
	stmt.executeUpdate(sql);
	i = stmt.getUpdateCount();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	jta10.setText("Successfully Amend " + i + "items");
	}
	public void createGUI() {
	JFrame jf = new JFrame("User Information Management System");
	jf.setLayout(new GridLayout(2, 1));
	// jf.setLayout(new GridLayout(10,2));
	JPanel jp00 = new JPanel(new GridLayout(5, 4));
	JPanel jp1 = new JPanel();
	JButton jb11 = new JButton("Query");
	jb11.addActionListener(this);
	JButton jb12 = new JButton("Add");
	jb12.addActionListener(this);
	jp1.add(jb11);
	jp1.add(jb12);
	jp00.add(jp1);
	JPanel jp11 = new JPanel();
	JButton jb111 = new JButton("Ban");
	jb111.addActionListener(this);
	JButton jb112 = new JButton("Amend");
	jb112.addActionListener(this);
	jp11.add(jb111);
	jp11.add(jb112);
	jp00.add(jp11);
	JPanel jp2 = new JPanel();
	JLabel jl2 = new JLabel("FirstName ");
	jp2.add(jl2);
	jp2.add(jtf2);
	jp00.add(jp2);
	JPanel jp3 = new JPanel();
	JLabel jl3 = new JLabel("Password");
	jp3.add(jl3);
	jp3.add(jtf3);
	jp00.add(jp3);
	JPanel jp4 = new JPanel();
	JLabel jl4 = new JLabel("LastName");
	jp4.add(jl4);
	jp4.add(jtf4);
	jp00.add(jp4);
	JPanel jp5 = new JPanel();
	JLabel jl5 = new JLabel("PhoneNO. ");
	jp5.add(jl5);
	jp5.add(jtf5);
	jp00.add(jp5);
	JPanel jp6 = new JPanel();
	JLabel jl6 = new JLabel("Postcode");
	jp6.add(jl6);
	jp6.add(jtf6);
	jp00.add(jp6);
	JPanel jp7 = new JPanel();
	JLabel jl7 = new JLabel("State");
	jp7.add(jl7);
	jp7.add(jtf7);
	jp00.add(jp7);
	JPanel jp8 = new JPanel();
	JLabel jl8 = new JLabel("City");
	jp8.add(jl8);
	jp8.add(jtf8);
	jp00.add(jp8);
	JPanel jp9 = new JPanel();
	JLabel jl9 = new JLabel("Adress");
	jp9.add(jl9);
	jp9.add(jtf9);
	jp00.add(jp9);
	jf.add(jp00);
	JPanel jp01 = new JPanel();
	jta10.setText("manualbook");
	jp01.add(jta10);
	jf.add(jp01);
	jf.setSize(700, 500);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
	}
	public static void main(String[] args) {
	new CustomerManagement();
	}
	

}
