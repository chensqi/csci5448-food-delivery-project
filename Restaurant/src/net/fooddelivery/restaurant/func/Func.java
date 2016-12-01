package net.fooddelivery.restaurant.func;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.Iterator;
import java.util.List;

import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.models.*;
public class Func {
	public static SessionFactory factory;
	public static void init(){
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	public static boolean login(String usn, char[] pwd){
		Session session=factory.openSession(); 
		String hql = "SELECT R.password FROM ResLog R WHERE R.username="+usn;
		Query<String> query = session.createQuery(hql);
		List<String> results = query.getResultList();
		if(results.isEmpty()||!results.iterator().next().equals(new String(pwd))){
			session.close();
			return false;
		}
		else{
			hql="FROM Restaurant R WHERE R.id=(SELECT R.resId FROM ResLog R WHERE R.username="+usn+")";
			List<Restaurant> res=session.createQuery(hql).getResultList();
			MainWin.setManagement(res.iterator().next());
			MainWin win=new MainWin();
			win.show();
			session.close();
			return true;
		}
	}
}
