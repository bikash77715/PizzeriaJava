package PointOfSale;

import java.util.Scanner;

public class Menu {

	Scanner scanner; 
	OrderHandler orderHandler;

	
	public Menu() {
		this.scanner = new Scanner(System.in); 
		orderHandler = new OrderHandler();
		//				
				// TODO Auto-generated constructor stub
	}


	public void display() {
		boolean addNewPizza = true;
		int size;
		while(addNewPizza){
			
			printSeperator();
			System.out.println(" Select pizza size: ");
			System.out.println(" (1) Small \n (2) Medium \n (3) Large \n (0) Finish order");
			
			printSeperator();

			try {					
				printSeperator();
				
				while(true) {
					size = scanner.nextInt();
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
						
					}
						
				}

			}catch(Exception e) {
				System.out.println(" Unexpected error. Try giving correct inputs. ");
				scanner.nextLine();
			}
			
						
		}
		orderHandler.deliveryOption();
		orderHandler.generateReport();
		
		
	}

	private void processSizeSelection(int size) {
		// TODO Auto-generated method stub
		
		switch (size) {
		case 1:
			System.out.println(" Small pizza is selected!");
			break;
			
		case 2:
			System.out.println(" Medium pizza is selected!");
			break;			
		case 3:
			System.out.println(" Large pizza is selected!");
			break;			
					
		}
		orderHandler.generateOrder(size);
	}

	private void printSeperator() {
		// TODO Auto-generated method stub
		for(int n=0; n<100 ; n++) {
			System.out.print("*");
		}
		System.out.println("");
	}
}
