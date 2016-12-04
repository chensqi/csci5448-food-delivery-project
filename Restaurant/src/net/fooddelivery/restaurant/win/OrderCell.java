package net.fooddelivery.restaurant.win;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.security.PublicKey;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.omg.CORBA.PUBLIC_MEMBER;

import net.fooddelivery.restaurant.models.*;

public class OrderCell  extends JLabel implements ListCellRenderer {
	@Override
    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        Order o= (Order)value;
        setHorizontalAlignment(JLabel.LEFT);
        String Text="<html><body>Customer: "+o.getCustomer().getName()+"<br>Order Time: "+o.getTime().toString()+"<br>Address: "+o.getDestination()+"<br>Status:";
		int sta=o.getOrderStatus();
		switch (sta) {
		case 0:
			Text+="<b>Waiting</b>";
			break;
		case 1:
			Text+="<b>Delivering</b>";
			break;
		case 2:
			Text+="Delivered";
			break;
		case 3:
			Text+="Completed";
			break;
		case 4:
			Text+="Cancelled";
			break;
		default:
			Text+="Waiting";
			break;
		}
		Text+="</body></html>";
        this.setText(Text);
        if(isSelected){
        	setBackground(new Color(0,127,255));
        	setForeground(Color.white);
        }
        else {
        	setBackground(list.getBackground());
        	setForeground(list.getForeground());
        }

        setFont(new Font("Gill-Sans", Font.PLAIN, 18));
        setOpaque(true);


        return this;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
