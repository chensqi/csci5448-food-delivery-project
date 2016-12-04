package CustomerUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import CustomerUI.CartList.CartCellRenderer;
import Models.Order;
import Models.Restaurant;
import Models.ShoppingCartEntity;

public class OrderList extends JList{
	public class OrderCellRenderer extends JLabel implements ListCellRenderer{

		public String getStatue( int s ) {
			String [] a = { "Waiting", "Delivering", "Delivered", "Completed" };
			return a[s];
		}
		public Component getListCellRendererComponent(JList list
				, Object value
				, int index
				, boolean isSelected
				, boolean cellHasFocus) {
			
			Order order = (Order) value;
			this.setText( "<html><b>Restaurant: " + order.getRestaurant().getName() + "</b><br>"
					+ "Date: " + order.getTime() + "<br>"
					+ "Status: " + getStatue(order.getOrderStatus() ) + "<br>"
					+ "</html>");
			setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
	        setOpaque(true); 
	        
			return this;
		}
	}

	public OrderList(Vector orders, ViewOrdersUI UI ) {
		super(orders);
		OrderCellRenderer renderer = new OrderCellRenderer();
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
				Order o = (Order) getSelectedValue();
				UI.showOrderDetail(o);
			}
		});
		
	}
}
