package net.fooddelivery.restaurant.win;
import javax.swing.*;
import java.awt.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
import java.util.List;
import java.util.Iterator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.func.*;
public class FoodPanel extends JPanel {
	public JList foodList;
	public ResManagement resman;
	public FoodPanel(ResManagement r){
		this.setSize(739,320);
		this.setLayout(null);
		resman=r;
		foodList=new JList();
		JScrollPane scr=new JScrollPane(foodList);
		this.add(scr);
		scr.setBounds(0, 0,735, 280);
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
		JButton btnAdd=new JButton("Add Food");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClick();
			}
		});
		btnAdd.setBounds(630,285,100,30);
		this.add(btnAdd);
		reload();
	}
	private void AddClick(){
		Food food=new Food();
		food.setRestaurant(resman.res);
		//System.out.println(resman.res.getId());
		FoodManagement foodman =new FoodManagement(food,this);
		AddFoodWin win=new AddFoodWin(foodman);
		win.show();
	}
	private void DuoClick(Object value){
		Food f=(Food) value;
		FoodManagement foodman =new FoodManagement(f,this);
		UpdateFoodWin win=new UpdateFoodWin(foodman);
		win.show();
		
	}
	public void reload(){
		int index=foodList.getSelectedIndex();
		List<Food> l=resman.fetchFoods();
		Iterator<Food> it=l.iterator();
		DefaultListModel<Food> lm=new DefaultListModel<>();
		while(it.hasNext()){
			lm.addElement(it.next());
		}
		foodList.setModel(lm);
		if(index>=0) foodList.setSelectedIndex(index);
		//orderList.setSelectionBackground(back);

	}
}
