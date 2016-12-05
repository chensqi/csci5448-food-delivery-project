package net.fooddelivery.card.win;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CreditCard {
	
	JFrame frame;
    JTextField cardNumField;
    JComboBox creditCardBox;
    JButton checkButton;
    JButton clearButton;
    String[] cards = {"Visa","Mastercard"};
    String selected = null;

    public class CreditCards {

        private String prefix;
        private String length;

        public CreditCards(String p, String l) {

            prefix = p;
            length = l;

        }

        public String getPrefix() {
            return prefix;
        }

        public String getLength() {
            return length;
        }
    }
    
    
    public class MasterCard extends CreditCards {

        public MasterCard(String prefix,String length) {
            super(prefix,length);
        }

        public boolean isMaster() {
            boolean pre = (getPrefix().equals("55") || getPrefix().equals("51"))? true:false;
            boolean len = getLength().equals("16")? true:false;

            if(pre && len) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public class VisaCard extends CreditCards {

        public VisaCard(String pre,String len) {
            super(pre,len);
        }

        public boolean isVisa() {
            boolean pre = getPrefix().equals("4") ? true:false;
            boolean len = (getLength().equals("16") || getLength().equals("13"))? true:false;

            if(pre && len) {
                return true;
            }
            return false;
        }
    }
    
    
    public static void main(String[] args) {

    	CreditCard r1 = new CreditCard();
        r1.go();
    }

    public void go() {
        frame = new JFrame();
        JPanel cardPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(0,2));
        buttonPanel.setLayout(new GridLayout(0,2));

        creditCardBox = new JComboBox(cards);

        //cardNumField = new JTextField("",50);
        cardNumField = new JTextField("",50);
        checkButton = new JButton("check");
        checkButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String selected = creditCardBox.getSelectedItem().toString();
                if (checkCriteria(selected)){
                    if (checkSum(cardNumField.getText())) {
                        JOptionPane.showMessageDialog(null, "Your Credit Card is Valid");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Your Credit Card is Not Valid");

                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Your Credit Card is Not Valid");
                }
            }
        });

        clearButton = new JButton("clear");

        cardPanel.add(creditCardBox);
        cardPanel.add(cardNumField);

        buttonPanel.add(checkButton);
        buttonPanel.add(clearButton);

        frame.getContentPane().add(BorderLayout.CENTER,cardPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
        frame.setSize(250, 200);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public static boolean checkSum(String check){
        int sum = 0;
        String trimCheck = check.replaceAll(" ", "");
        String reverse = new StringBuffer(trimCheck).reverse().toString();
        for(int i =0;i<trimCheck.length();i++) {
            int checkThis = Character.digit(reverse.charAt(i), 10);

            if(i%2==0) {
                sum+=checkThis;
            }
            else {
                sum += checkThis *2;
                if(checkThis >=5) {
                    sum-=9;
                }
            }
        }
        if(sum%10==0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCriteria(String c) {
        int length = cardNumField.getText().replaceAll(" ","").length();
        String len = Integer.toString(length);

        if (c.equals("Mastercard")) {
            String pre = cardNumField.getText().substring(0,2);
            MasterCard masters = new MasterCard(pre,len);

            if(masters.isMaster()) {
                return true;
            }
        }

        if (c.equals("Visa")) {
            String pre = cardNumField.getText().substring(0,1);
            VisaCard visa = new VisaCard(pre,len);

            if (visa.isVisa()) {
                return true;
            }
        }

        return false;
    }


}
