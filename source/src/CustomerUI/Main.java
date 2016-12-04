package CustomerUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.*;

import Controller.DBconnector;
import Controller.RestaurantManagement;
import Models.Food;
import Models.Location;
import Models.Restaurant;
public class Main  {
	
	
	public static void main(String[] args) {
		(new Main()).run();
	}
	public void loadTEMPdata() {
		
		File file = new File("src/grass.png");
        byte[] bFile = new byte[(int) file.length()];

        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
		
        Restaurant test1 = new Restaurant();
        test1.setId(1);
        test1.setPhoto( bFile );
		test1.setName("restaurant1");
		test1.setLocation(new Location("AABB street"));
		test1.setDescription("No description");
		test1.setDeliverFee(3.5);
		DBconnector.persist(test1);
		
		Restaurant test2 = new Restaurant();
		test2.setId(2);
		test2.setPhoto( bFile );
		test2.setName("restaurant2");
		test2.setLocation(new Location("BBCC street"));
		test2.setDescription("No description too");
		test2.setDeliverFee(1000);
		DBconnector.persist(test2);
		
		Restaurant test3 = new Restaurant();
		test3.setId(3);
		test3.setPhoto( bFile );
		test3.setName("restaurant3");
		test3.setLocation(new Location("AACC street"));
		test3.setDescription("No description too, too");
		test3.setDeliverFee(1000000);
		DBconnector.persist(test3);
		
		
		Food food1 = new Food();
		//food1.setId(1);
		food1.setPhoto(bFile);
		food1.setName("grass1");
		food1.setDescription("empty");
		food1.setPrice(0.5);
		food1.setRestaurant(test1);
		DBconnector.persist(food1);
		
		Food food2 = new Food();
		//food2.setId(2);
		food2.setPhoto(bFile);
		food2.setName("grass2");
		food2.setDescription("empty too");
		food2.setPrice(0.49);
		food2.setRestaurant(test1);
		DBconnector.persist(food2);
	}
	public void run() {
		init();
		
		loadTEMPdata();
		
		LoginUI login = new LoginUI();
		login.run();
		
		close();
		java.util.Date today = new java.util.Date();
		System.out.println(today);
		System.out.println( new java.sql.Time(today.getTime()) );
		System.out.println("Main ends!");
	}
	public void init() {
		DBconnector.newSession();
	}
	public void close() {
		DBconnector.close();
	}
}
