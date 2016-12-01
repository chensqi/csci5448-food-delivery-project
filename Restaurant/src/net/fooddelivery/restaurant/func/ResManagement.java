package net.fooddelivery.restaurant.func;
import net.fooddelivery.restaurant.models.*;
public class ResManagement {
	public Restaurant res;
	public ResManagement(Restaurant r){
		this.res=r;
		System.out.println(r.getName());
	}
}
