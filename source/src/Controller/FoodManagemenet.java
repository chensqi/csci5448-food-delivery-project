package Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Models.Food;
import Models.Restaurant;

public class FoodManagemenet {
	static public Vector<Food> fetchAllFoods() {
		List r = DBconnector.list("FROM Food" );
		Vector<Food> res = new Vector<Food>();
		for ( Iterator it = r.iterator() ; it.hasNext() ; ) {
			res.add((Food)it.next());
		}
		return res;
	}
	static public Vector<Food> fetchAllFoodsFromRestaurant( Restaurant rest ) {
		List r = DBconnector.list("FROM Food WHERE restaurant_id = " + rest.getId() );
		Vector<Food> res = new Vector<Food>();
		for ( Iterator it = r.iterator() ; it.hasNext() ; ) {
			res.add((Food)it.next());
		}
		return res;
	}

}
