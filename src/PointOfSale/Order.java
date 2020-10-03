package PointOfSale;

import java.util.ArrayList;

public class Order {
	private ArrayList<Pizza> pizzaList;
	private boolean deliver;
	private String custInfo;
	private int cost;
	
	public Order() {
		this.pizzaList = new ArrayList<Pizza>();
	}
	
	public ArrayList<Pizza> getPizzaList() {
		return pizzaList;
	}
	public void addPizza(Pizza pizza) {
		this.pizzaList.add(pizza);
	}
	public boolean getDeliveryType() {
		return deliver;
	}
	public void setDeliveryType(boolean deliver) {
		this.deliver = deliver;
	}
	public String getInfo() {
		return custInfo;
	}
	public void setInfo(String info) {
		this.custInfo = info;
	}

	public int getCost() {
		cost = 0;

		for(Pizza p: this.pizzaList) {
			cost+= p.getPrice();
		}
		
		if(deliver) {
			if(cost<30)
				cost += 8;	
			
		}
						
		return cost;
	}
	
	
	

}
