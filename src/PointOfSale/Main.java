package PointOfSale;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		
		System.out.println(" Pizzeria  ");
		while(loop) {
			Menu menu = new Menu();
			menu.display();
			
			System.out.println(" exit? y/n");
			String input = scanner.next();
			while(true) {
				if(input.equalsIgnoreCase("y")){
					System.out.println(" System terminated.");
					loop = false;
					break;					
				}
				else if(input.equalsIgnoreCase("n"))
					break;
				else {
					System.out.println(" Wrong input: ");
					break;
				}
					
				
			}
		}
		
	}

	
}
