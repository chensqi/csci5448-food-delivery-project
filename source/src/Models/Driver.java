package Models;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Driver {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //cfg.addClass(Models.Food.class);
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction tx = null;//=session.beginTransaction();  
	    try{
	         tx = session.beginTransaction();
	         Food f = new Food();
	         //f.setId(1);
	         f.setName("Chicken");
	         f.setPrice(10.98);
	         session.persist(f);
	         
	         f = new Food();
	         f.setName("Beef");
	         f.setPrice(9.98);
	         session.persist(f);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }

	    
	    System.out.println("successfully saved");  
		
	}
}
