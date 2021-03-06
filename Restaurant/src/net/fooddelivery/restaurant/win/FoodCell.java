package net.fooddelivery.restaurant.win;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import net.fooddelivery.restaurant.models.*;
import java.util.*;

public class FoodCell  extends JLabel implements ListCellRenderer {
	@Override
    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        Food f= (Food)value;
        setHorizontalAlignment(JLabel.LEFT);
        String Text="<html><body><b>"+f.getName()+"</b><br/>"+" Description: "+f.getDescription()+"</b><br />Price: "+String.valueOf(f.getPrice())+" Calorie: "+String.valueOf(f.getCalorie())+"</body></html>";
        this.setText(Text);
		ImageIcon temp=new ImageIcon(f.getPhoto());
		ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		this.setIcon(icon);
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
