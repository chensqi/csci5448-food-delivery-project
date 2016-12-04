package net.fooddelivery.restaurant.driver;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.*;
import java.util.Iterator;
import java.util.List;
import java.util.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.models.*;
public class Driver {
	public static void insertRes(){
		Restaurant r=new Restaurant();
		r.setName("Lin");
		r.setDescription("Most Handsome Man");
    	File file = new File("D:\\images.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
		r.setPhoto(bFile);
		r.setAddress("Boulder");
		r.setOpenTime("9:00");
		r.setCloseTime("20:00");
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.persist(r);
		tx.commit();
		session.close();
	}
	public static void insertResLog(){
		ResLog r=new ResLog();
		r.setUsername("123");
		r.setPassword("123");
		r.setResId(1);
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.persist(r);
		tx.commit();
		session.close();
	}
	public static void insertCustomer(){
		Customer c=new Customer();
		c.setLoginName("123");
		c.setName("Yuhan");
		c.setPassword("123456");
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.persist(c);
		tx.commit();
		session.close();
	}
	public static void insertFood(){
		Session session=Func.factory.openSession(); 
		String hql = "FROM Restaurant r";
		Query<Restaurant> query = session.createQuery(hql);
		List<Restaurant> results = query.getResultList();
		
		Restaurant r=results.iterator().next();
		Food f=new Food();
		f.setRestaurant(r);
		f.setName("Rice");
		f.setCalorie(300);
		f.setDescription("White Rice");
		f.setPrice(1.5);
    	File file = new File("D:\\food.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        f.setPhoto(bFile);
        Transaction tx =session.beginTransaction();
		session.persist(f);
		tx.commit();
		session.close();
		
	}
	public static void insertOrder(){
		Session session=Func.factory.openSession(); 
		String hql = "FROM Restaurant r";
		Query<Restaurant> query = session.createQuery(hql);
		List<Restaurant> results = query.getResultList();

		
		Restaurant r=results.iterator().next();
		
		hql = "FROM Customer C";
		Query<Customer> query2 = session.createQuery(hql);
		List<Customer> results2 = query2.getResultList();
		
		Customer c=results2.iterator().next();
		
		hql = "FROM Food F";
		Query<Food> query3 = session.createQuery(hql);
		List<Food> results3 = query3.getResultList();
		results3.add(results3.iterator().next());
		Food f=results3.iterator().next();
		
		Order o=new Order();
		o.setCustomer(c);
		o.setRestaurant(r);
		o.setDestination("Colorado Ave");
		o.setOrderStatus(0);
		o.setTime(new java.sql.Date(1000000));
		Collection<Food> v=new Vector<Food>();
		v.add(f);
		o.setFoods(results3);
		
		//o.setTime();
		
        Transaction tx =session.beginTransaction();
		session.save(o);
		//session.save(o);
		tx.commit();
		session.close();
		
	}
	public static void main (String[] args){
		Func.init();
		LoginWin log=new LoginWin();
		log.show();
	    /*insertRes();
		insertResLog();
		insertCustomer();
		insertFood();*/
		//insertOrder();
	}
}
