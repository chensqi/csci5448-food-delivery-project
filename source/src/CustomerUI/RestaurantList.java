package CustomerUI;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;

import Models.Restaurant;

public class RestaurantList extends JList {
	
	public class RestaurantCellRenderer extends JLabel implements ListCellRenderer{
		
		static final int imageWidth = 100;
		static final int imageHeight = 100;
		
		@Override
		public Component getListCellRendererComponent(JList list
				, Object value
				, int index
				, boolean isSelected
				, boolean cellHasFocus) {
			
			Restaurant r = (Restaurant) value;
			this.setText( "<html><b><font size=\"6\">Restaurant name: " + r.getName() + "</font></b><br>"
					+ "Description: " + r.getDescription() + "<br>"
					+ "Location: " + r.getLocation() + "<br>"
					+ "Delivery fee: $" + r.getDeliverFee() + " per order</html>");
			ImageIcon temp=new ImageIcon(((Restaurant)value).getPhoto());
			ImageIcon icon = new ImageIcon(temp.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT));
			
			this.setIcon(icon);
			setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
	        setOpaque(true);
	        
			return this;
		}
		
	}
	
	public RestaurantList(Vector a, SelectRestaurantMenuUI UI) {
		super(a);
		RestaurantCellRenderer renderer = new RestaurantCellRenderer();
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
				Restaurant r = (Restaurant) getSelectedValue();
				UI.selectRestaurant(r);
			}
		});
	}
}
