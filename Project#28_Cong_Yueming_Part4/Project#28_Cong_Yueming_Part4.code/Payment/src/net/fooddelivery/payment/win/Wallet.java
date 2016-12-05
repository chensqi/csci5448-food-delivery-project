package net.fooddelivery.payment.win;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Wallet implements ActionListener,ItemListener{
	
	private List<Account> store;

    DefaultListModel listModel = new DefaultListModel();
    JList list = new JList(listModel);
    FlowLayout flow = new FlowLayout();
    ButtonGroup group = new ButtonGroup();
    JFrame frame = new JFrame("Food Delivery");
    JPanel block_1 = new JPanel();
    JPanel account = new JPanel();
    JPanel transaction = new JPanel();
    JPanel history = new JPanel();

    JRadioButton cc = new JRadioButton("Credit Card");
    JRadioButton dc = new JRadioButton("Debit Card");
    JRadioButton dp = new JRadioButton("Deposit");
    JRadioButton wd = new JRadioButton("Withdraw");

    JLabel a1 = new JLabel("No on card:");
    JLabel a2 = new JLabel("Name on card:");
    JTextField accID = new JTextField(10);
    JTextField accName = new JTextField(10);


    JLabel c1 = new JLabel("Input \n Amount" );
    JLabel currentBal = new JLabel();
    JTextField amount = new JTextField(10);
    JButton button = new JButton("Submit");

    JTextArea area = new JTextArea(10,30);    

public Wallet() 
{
    store = new ArrayList<Account>();           

    //Setting values
    frame.setSize(800,600);
    frame.add(block_1);
    frame.add(account);
    frame.add(transaction);
    frame.add(history);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adding the buttons 
    group.add(cc);
    group.add(dc);
    group.add(dp);
    group.add(wd);

    //panel 1
    frame.getContentPane().setLayout(flow);
    block_1.setPreferredSize(new Dimension(500,200));     
    block_1.setLayout(new GridLayout(10,5));
    block_1.add(cc);
    block_1.add(dc);
    block_1.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Card Type"));

    //panel 2
    account.setPreferredSize(new Dimension(300,150));
    account.setLayout(new GridLayout(4,3));
    account.add(a1);
    account.add(accID);
    account.add(a2);
    account.add(accName);
    account.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Account Details")); 
    account.setVisible(false);

    // 3
    transaction.setPreferredSize(new Dimension(300,150));
    transaction.setLayout(new FlowLayout());
    transaction.add(dp);
    transaction.add(wd);
    transaction.add(amount);
    transaction.add(button);
    transaction.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Transaction"));
    transaction.add(c1);
    transaction.setVisible(false);

    //4
    history.setLayout(new GridLayout(1,2));
    history.add(area);
    history.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Balance History"));
    history.setVisible(false);

     cc.addItemListener(this);
     dc.addItemListener(this);
     dp.addActionListener(this);
     wd.addActionListener(this);

     button.addActionListener(this);            
}
Account acnt = new Account();
public void actionPerformed(ActionEvent no1)
{
    Object source = no1.getSource();
    if(source == button)
    {
        Account amnt = new Account();               
        amnt.setBalance(Integer.parseInt(amount.getText()));
      
        store.add(amnt);                
    }

    if(no1.getSource() == button)
    {               
        if(dp.isSelected())
        {
            acnt.setId(accID.getText());
            acnt.setName(accName.getText());
            acnt.setBalance(Integer.parseInt(amount.getText()));
            
            area.append("\nDeposit-"+ acnt.toString());
            store.add(acnt);
        }

        if(wd.isSelected())
        {
            
            acnt.setId(accID.getText());
            acnt.setName(accName.getText());
            acnt.setBalance(acnt.getBalance()-Integer.parseInt(amount.getText()));
            area.append("\nWithdraw-"+acnt.toString());
            store.add(acnt);
        }  
    }       
}


public void itemStateChanged(ItemEvent no2)
{
    Object source = no2.getSource();
    if(source == cc)
    {
    	account.setVisible(true);
        transaction.setVisible(true);
        history.setVisible(true);
    }
    if(source == dc)
    {
    	account.setVisible(true);
        transaction.setVisible(true);
        history.setVisible(true);
    }
}
}
