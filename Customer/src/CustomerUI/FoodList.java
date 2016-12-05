package CustomerUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CustomerUI.RestaurantList.RestaurantCellRenderer;
import Models.Food;

public class FoodList extends JList {
	
public class FoodCellRenderer extends JLabel implements ListCellRenderer{
		
		static final int imageWidth = 60;
		static final int imageHeight = 60;
		
		@Override
		public Component getListCellRendererComponent(JList list
				, Object value
				, int index
				, boolean isSelected
				, boolean cellHasFocus) {
			
			Food f = (Food) value;
			this.setText( "<html><b>Food name: " + f.getName() + "</b><br>"
					+ "Description: " + f.getDescription() + "<br>"
					+ "Price: " + f.getPrice() + "<br>"
					+ "</html>");
			ImageIcon temp=new ImageIcon(f.getPhoto());
			ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT));
			
			this.setIcon(icon);
			setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
	        setOpaque(true);
	        
			return this;
		}
		
	}


	public FoodList(Vector foods, SelectFoodMenuUI selectFoodMenuUI) {
		super(foods);
		FoodCellRenderer renderer = new FoodCellRenderer();
	    this.setCellRenderer(renderer);
	    this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Food f = (Food)getSelectedValue();
				selectFoodMenuUI.addFoodIntoCart(f);
			}
		});
	}
}
