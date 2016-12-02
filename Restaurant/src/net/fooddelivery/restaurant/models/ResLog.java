package net.fooddelivery.restaurant.models;
import java.util.Collection;

import javax.persistence.*;
@Entity
@Table( name = "ResLog" )
public class ResLog {
	@Id
	private String username;
	private String password;
	private int	 resId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}

}
