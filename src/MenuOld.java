package PointOfSale;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MenuOld {

	Scanner input; 
	Order newOrder; 
	Set<String> defaultToppings;
	String[] toppings;
	
	public MenuOld() {
		this.input = new Scanner(System.in); 
		this.newOrder = new Order();
//		this.toppings = new HashSet<String>(Arrays.asList(new String[]{"Bacon", "Olives", "Ham", "Mushrooms", "Pineapple", "Salami", "Anchovies"}));
		this.toppings = new String[]{"Bacon", "Olives", "Ham", "Mushrooms", "Pineapple", "Salami", "Anchovies"};
		this.defaultToppings = new HashSet<String>(Arrays.asList(new String[] {"Salami", "Ham", "Mushrooms", "Olives"}));
//				
				// TODO Auto-generated constructor stub
	}


	public void display() {
		boolean addNewPizza = true;
		while(addNewPizza){
			
			printSeperator();
			System.out.println(" Select pizza size: ");
			System.out.println(" (1) Small \n (2) Medium \n (3) Large \n (0) Finish order");
			
			printSeperator();
			int size = input.nextInt();	
			printSeperator();
			
			while(true) {
				if (size == 0) {
					addNewPizza = false;
					System.out.println(" Order is completed. \n Thank you.");
					printSeperator();
					break;
				}
				else if (size>0 && size<4)
				{
					processSizeSelection(size);
					break;
				}
					
					
				else
				{
					System.out.println(" Please enter a valid number: (0-3)");	
					printSeperator();
					
					size = input.nextInt();	
				}
					
			}
			
			
		}
		
	}

	private void processSizeSelection(int size) {
		// TODO Auto-generated method stub
		
		switch (size) {
		case 1:
			System.out.println(" Small pizza is selected!");
			generateOrder(makePizza(size));
			break;
			
		case 2:
			System.out.println(" Medium pizza is selected!");
			break;			
		case 3:
			System.out.println(" Large pizza is selected!");
			break;			
					
		}
	}

	private void generateOrder(Pizza pizza) {
			// TODO Auto-generated method stub
		System.out.println(" Default toppings are: "+ defaultToppings.toString());
		System.out.println(" Default? (y/n): ");
		
		printSeperator();		
		String choice = input.next();
		printSeperator();
		
		while(true) {
			if(choice.trim().equalsIgnoreCase("y")) {
				pizza.setToppings(defaultToppings);				
				newOrder.addPizza(pizza);
				
				System.out.println(" Pizza is added. ");
				printSeperator();
				break;
			}
			else if(choice.trim().equalsIgnoreCase("n")) {
				pizza.setToppings(getToppings(pizza));
				newOrder.addPizza(pizza);
				
				System.out.println(" Pizza is added. ");
				printSeperator();
				break;
			}
			else {
				System.out.println(" PLEASE ENTER VALID INPUT: (Y/N) OR (y/n)");
				printSeperator();
				choice = input.next();
			}
				
		}
			
	}
		
	private Set<String> getToppings(Pizza pizza) {
		// TODO Auto-generated method stub
		
		Set<String> addedToppings = new HashSet<String>();
		System.out.println(" Topping options are: ");
		
		for(int i = 0; i < toppings.length; i++ ) {
			System.out.println(" (" + (i+1) + ") "+ toppings[i]);
		}
		
		System.out.println(" enter 0 to finalize or the topping number to add:");
		int choice = input.nextInt();
		
		while(addedToppings.size()<4) {
			if(choice > 0 && choice <= (toppings.length))
				addedToppings.add(toppings[choice]);
			else if (choice == 0) {
				if(addedToppings.size()==0) {
					System.out.println(" Add at least one topping!");
					choice = input.nextInt();
					continue;
				}
				printSeperator();
				System.out.println(" Toppings have been finalized.");
				printSeperator();
				break;
			}				
			else
				System.out.println(" PLEASE ENTER A VALID NUMBER: (0-"+ (toppings.length+1)+")");
			
			choice = input.nextInt();
		}
		
		
		return addedToppings;
	}


	private Pizza makePizza(int size) {
		// TODO Auto-generated method stub
		Pizza pizza = new Pizza();
		pizza.setSize(size);
		return pizza;
	}

	


	private void printSeperator() {
		// TODO Auto-generated method stub
		for(int n=0; n<65 ; n++) {
			System.out.print("*");
		}
		System.out.println("");
	}
}
