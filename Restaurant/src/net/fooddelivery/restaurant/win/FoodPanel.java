package net.fooddelivery.restaurant.win;
import javax.swing.*;
import java.awt.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.func.*;
public class FoodPanel extends JPanel {
	public JList foodList;
	public ResManagement resman;
	public FoodPanel(ResManagement r){
		resman=r;
		foodList=new JList();
		foodList.setSize(800, 500);
		JScrollPane scr=new JScrollPane(foodList);
		this.add(scr);
		scr.setSize(800,500);
		FoodCell cell=new FoodCell();
		foodList.setCellRenderer(cell);
		foodList.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		foodList.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){  
		        if(e.getClickCount()==2){   //When double click JList  
		            DuoClick(foodList.getSelectedValue());   //Event  
		        }  
		    }  
		});  
		reload();
	}
	private void DuoClick(Object value){
		Food f=(Food) value;
		FoodManagement foodman =new FoodManagement(f);
		UpdateFoodWin win=new UpdateFoodWin(foodman);
		win.show();
		
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
