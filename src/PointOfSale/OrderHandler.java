package PointOfSale;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrderHandler {
	
	Scanner scanner;
	Order newOrder; 
	String[] toppings;
	
	public OrderHandler() {
		this.scanner = new Scanner(System.in);
		this.newOrder = new Order();
//		this.toppings = new HashSet<String>(Arrays.asList(new String[]{"Bacon", "Olives", "Ham", "Mushrooms", "Pineapple", "Salami", "Anchovies"}));
		this.toppings = new String[]{"Bacon", "Olives", "Ham", "Mushrooms", "Pineapple", "Salami", "Anchovies"};
//		this.defaultToppings = new HashSet<String>(Arrays.asList(new String[] {"Salami", "Ham", "Mushrooms", "Olives"}));

	}
	
	// adds pizza to the orderlist
	public void generateOrder(int size) {
		// TODO Auto-generated method stub
		Pizza pizza = new Pizza(size);
		
		System.out.println(" Default toppings are: "+ pizza.getToppings().toString());
		printSeperator();		

		System.out.print(" Default? (y/n): ");
		
		String choice = scanner.next();
		printSeperator();
		
		while(true) {
			if(choice.trim().equalsIgnoreCase("y")) {
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
				choice = scanner.next();
			}
				
		}			
	}
		
	// sets toppings for current pizza
	private Set<String> getToppings(Pizza pizza) {
		// TODO Auto-generated method stub
		
		Set<String> addedToppings = new HashSet<String>();
		System.out.println(" Topping options are: ");
		
		for(int i = 0; i < toppings.length; i++ ) {
			System.out.println(" (" + (i+1) + ") "+ toppings[i]);
		}
		
		System.out.print(" enter 0 to finalize or the topping number to add: ");
		int choice;
		while(true) {
			try {
				while(addedToppings.size()<4) {
					choice = scanner.nextInt();
					if(choice > 0 && choice <= (toppings.length))
						addedToppings.add(toppings[choice-1]);
					else if (choice == 0) {
						if(addedToppings.size()==0) {
							System.out.println(" Add at least one topping!");
							choice = scanner.nextInt();
							continue;
						}
						printSeperator();
						System.out.println(" Toppings have been finalized.");
						printSeperator();
						break;
					}				
					else
						System.out.println(" PLEASE ENTER A VALID NUMBER: (0-"+ (toppings.length+1)+")");
					
//					choice = scanner.nextInt();
				}
				break;
				
			}catch(Exception e) {
				System.out.println(" Wrong inputs! Try again.");
				scanner.nextLine();
			}
		}
		
				
		return addedToppings;
	}
	
			


	public void deliveryOption() {
		// TODO Auto-generated method stub
		boolean loop = true;
		while(loop) {
			System.out.println(" Delivery option: \n (1) Collected \n (2) Delivered");

			printSeperator(); 
			switch (scanner.nextInt()) {
			case 1:
				newOrder.setDeliveryType(false);
				loop = false;
				break;
				
			case 2:
				newOrder.setDeliveryType(true);
				loop = false;
				break;
				
			default:
				System.out.println(" Wrong input! try again ");
				break;
			}
			getCustInfo();

		}
	}

	private void getCustInfo() {
		// TODO Auto-generated method stub
		String name, address;
		int phone;
		System.out.print(" Enter name: ");
		name = scanner.next();
		System.out.print(" Enter phone: ");
		while(true) {
			try {
				phone = scanner.nextInt();
				if(newOrder.getDeliveryType()) {
					System.out.print(" Enter address: ");
					address = scanner.next();
					newOrder.setInfo(" Name: "+ name+"\n Phone "+phone+"\n Address: "+ address);
					
				}
				else
					newOrder.setInfo(" Name: "+ name+" \n Phone "+phone);
								
			}catch(Exception e) {
				System.out.println(" Unexpected input. Try again");
				scanner.nextLine();
				continue;
			}
			break;
			
		}		
			
	}

	public void generateReport() {
		// TODO Auto-generated method stub
		printSeperator();
		printSeperator();
		System.out.println("Order Report");
		printSeperator();
		printSeperator();
		System.out.println(" Customer info: "+ newOrder.getInfo());
		String[] size = {"Small", "Medium", "Large"};
		printSeperator();
		System.out.println(" Pizza size \t\t Toppings \t \t \t Price");
		for(Pizza p: newOrder.getPizzaList()) {
			System.out.println(" "+size[p.getSize()-1]+" \t\t "+p.getToppings().toString()+" \t "+ p.getPrice());
		}
		System.out.println(" Total cost: "+ newOrder.getCost());
		printSeperator();
	}
	
	
	private void printSeperator() {
		// TODO Auto-generated method stub
		for(int n=0; n<100 ; n++) {
			System.out.print("*");
		}
		System.out.println("");
	}
}
