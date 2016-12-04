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

import CustomerUI.FoodList.FoodCellRenderer;
import Models.Food;
import Models.ShoppingCartEntity;

public class CartList extends JList {
	
	public class CartCellRenderer extends JLabel implements ListCellRenderer{

		public Component getListCellRendererComponent(JList list
				, Object value
				, int index
				, boolean isSelected
				, boolean cellHasFocus) {
			
			ShoppingCartEntity f = (ShoppingCartEntity) value;
			this.setText( "<html><b>Food name: " + f.getFood().getName() + "</b><br>"
					+ "Quantity: " + f.getQuantity() + "<br>"
					+ "</html>");
			setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
	        setOpaque(true);
	        
			return this;
		}
	}
	
	public CartList(Vector a, SelectFoodMenuUI selectFoodMenuUI) {
		super(a);
		setName("Shopping cart");
		CartCellRenderer renderer = new CartCellRenderer();
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
				selectFoodMenuUI.removeCartEntity((ShoppingCartEntity) getSelectedValue());
			}
		});
	}
}
