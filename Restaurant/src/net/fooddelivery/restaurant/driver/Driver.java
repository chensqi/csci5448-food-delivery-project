package net.fooddelivery.restaurant.driver;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.fooddelivery.restaurant.win.*;
import net.fooddelivery.restaurant.func.*;
import net.fooddelivery.restaurant.models.*;
public class Driver {
	public static void main (String[] args){
		Func.init();
		LoginWin log=new LoginWin();
		log.show();
		/*Restaurant r=new Restaurant();
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
		Location l=new Location();
		l.setLatitude(100);
		l.setLongtitude(100);
		l.setAddress("Boulder");
		r.setLocation(l);
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.persist(r);
		tx.commit();
		session.getTransaction().commit();*/
	}
}
