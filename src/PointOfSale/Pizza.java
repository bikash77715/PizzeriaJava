package PointOfSale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pizza {

	protected int size;
	protected Set<String> toppings;
	protected int price;
	
	public int getSize() {
		return size;
	}
	public Pizza(int size) {
		this.size = size;
		switch (size){
		case 1:
			this.toppings = new HashSet<String>(Arrays.asList(new String[] {"Salami", "Ham", "Mushrooms", "Olives"}));
			this.price = 5;

			break;
			
		case 2:
			this.toppings = new HashSet<String>(Arrays.asList(new String[] {"Salami", "Bacon", "Mushrooms", "Olives"}));
			this.price = 8;

			break;
			
		case 3:
			this.toppings = new HashSet<String>(Arrays.asList(new String[] {"Salami", "Ham", "Pineapple", "Anchovies"}));
			this.price = 12;

			break;
			
		}
			
	}
	public Set<String> getToppings() {
		return toppings;
	}
	public void setToppings(Set<String> toppings) {
		this.toppings = toppings;
	}
	public int getPrice() {
		return this.price += toppings.size();;
	}
	
	
}
