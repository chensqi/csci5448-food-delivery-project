package Models;

public class ShoppingCartEntity {
	Food food;
	int quantity;
	
	public ShoppingCartEntity() {
		quantity = 1;
	}
	public ShoppingCartEntity(Food f) {
		food = f ;
		quantity = 1;
	}
	
	public void addOne() {
		quantity++;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
