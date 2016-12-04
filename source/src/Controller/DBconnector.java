package Controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Food;

public class DBconnector {
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	private static Session session = null;
	
	public DBconnector() {}
	public static synchronized void newSession() {
		if ( cfg == null ) {
			//creating configuration object  
		    cfg=new Configuration();  
		    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
		    //creating seession factory object
		    factory=cfg.buildSessionFactory();
		}
		if ( session==null)
		    //creating session object  
		    session=factory.openSession();
	}
	public static synchronized void update(Object x) {
		newSession();
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         session.update(x);
	         tx.commit();
	    }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	    }finally {
	    	close();
	    }
	}
	public static synchronized boolean persist(Object x) {
		newSession();
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         session.save(x);
	         tx.commit();
	         return true;
	    }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	    }finally {
	    	close();
	    }
	}
	public static synchronized List list(String query) {
		newSession();
		List result = null ;
		Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	result = session.createQuery(query).list(); 
	    	tx.commit();
	    }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	    } finally {
	    	close();
	    }
		return result;
	}
	public static synchronized void close() {
		System.out.println("Connector closed!");
		if ( session != null ) {
			session.close();
			session=null;
		}
	}
}
