package net.fooddelivery.restaurant.func;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.fooddelivery.restaurant.models.*;
import net.fooddelivery.restaurant.win.FoodPanel;
import net.fooddelivery.restaurant.win.MainWin;
public class FoodManagement {
	public Food food;
	public FoodPanel foodPanel;
	public FoodManagement(Food f,FoodPanel fp){
		food=f;
		foodPanel=fp;
	}
	public void UpdateFood(Food newf){
		food.setCalorie(newf.getCalorie());
		food.setDescription(newf.getDescription());
		food.setName(newf.getName());
		food.setPhoto(newf.getPhoto());
		food.setPrice(newf.getPrice());
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.update(food);
		tx.commit();
		session.close();
		foodPanel.reload();
	}
	public void AddFood(Food newf){ 
		food.setCalorie(newf.getCalorie());
		food.setDescription(newf.getDescription());
		food.setName(newf.getName());
		food.setPhoto(newf.getPhoto());
		food.setPrice(newf.getPrice());
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.save(food);
		tx.commit();
		session.close();
		foodPanel.reload();
	}
	public void DeleteFood(){
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.delete(food);
		tx.commit();
		session.close();
		foodPanel.reload();
	}
}
