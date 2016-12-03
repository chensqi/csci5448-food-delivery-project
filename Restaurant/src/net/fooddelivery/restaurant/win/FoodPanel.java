package net.fooddelivery.restaurant.win;
import javax.swing.*;
import java.awt.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
public class FoodPanel extends JPanel {
	public JList foodList;
	public ResManagement resman;
	public FoodPanel(ResManagement r){
		resman=r;
		foodList=new JList();
		this.add(new JScrollPane(foodList));
		FoodCell cell=new FoodCell();
		foodList.setCellRenderer(cell);
		foodList.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		reload();
		
	}
	public void reload(){
		List<Food> l=resman.fetchFoods();
		Iterator<Food> it=l.iterator();
		DefaultListModel<Food> lm=new DefaultListModel<>();
		while(it.hasNext()){
			lm.addElement(it.next());
		}
		foodList.setModel(lm);
		//orderList.setSelectionBackground(back);

	}
}
