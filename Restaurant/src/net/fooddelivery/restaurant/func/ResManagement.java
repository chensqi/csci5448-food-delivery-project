package net.fooddelivery.restaurant.func;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.fooddelivery.restaurant.models.*;
import net.fooddelivery.restaurant.win.*;
public class ResManagement {
	public Restaurant res;
	public MainWin win;
	public ResManagement(Restaurant r){
		this.res=r;
		System.out.println(r.getName());
	}
	public void OpenUpdateResWin(){
		UpdateResWin r=new UpdateResWin(this);
		r.show();
	}
	public void UpdateRes(Restaurant newres){
		res.setName(newres.getName());
		res.setDescription(newres.getDescription());
		res.setPhoto(newres.getPhoto());
		res.setAddress(newres.getAddress());
		res.setDeliverFee(newres.getDeliverFee());
		res.setOpenTime(newres.getOpenTime());
		res.setCloseTime(newres.getCloseTime());
		Session session=Func.factory.openSession(); 
        Transaction tx =session.beginTransaction();
		session.update(res);
		tx.commit();
		session.close();
		win.refresh();
	}
	public void setMainwin(MainWin w){
		win=w;
	}
}
