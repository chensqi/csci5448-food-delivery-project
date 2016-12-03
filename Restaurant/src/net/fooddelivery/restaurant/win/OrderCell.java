package net.fooddelivery.restaurant.win;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
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
        String Text="<html><HTML><body>Customer: "+o.getCustomer().getName()+" Order Time: "+o.getTime().toString()+"<br>Address: "+o.getDestination()+"</body></html>";
        this.setText(Text);
        if(isSelected){
        	setBackground(new Color(0,127,255));
        	setForeground(Color.white);
        }
        else {
        	setBackground(list.getBackground());
        	setForeground(list.getForeground());
        }

        setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
        setOpaque(true);
        return this;
    }
}
