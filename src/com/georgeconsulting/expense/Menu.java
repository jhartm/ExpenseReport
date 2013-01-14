package com.georgeconsulting.expense;

import java.util.Scanner;

public class Menu {
	int menuChoice;
	
	public void basicChoices() {
		System.out.println("User level choices:");
		System.out.println("0  - Done");
		System.out.println("1  - Create new expense request");
		System.out.println("2  - Edit existing expense request");
		System.out.println("3  - Delete existing expense request");
		System.out.println("4  - View pending expense requests");
		System.out.println("5  - View approved expense requests");
		System.out.println("6  - View completed expense reports");
	}
	
	public void managerChoices() {
		System.out.println("--------------------------------------");
		System.out.println("Manager level choices:");
		System.out.println("7  - View pending requests awaiting manager approval");
		System.out.println("8  - Approve/reject a pending expense request");
		System.out.println("9  - View all approved expense request");
		System.out.println("10 - View all completed expense reports");
	}
	
	public Menu(int privLevel) {
		int menuChoice;
//		Boolean valid = false;
		
		if(privLevel == 1) {
			this.basicChoices();
		}
		else if(privLevel > 1) {
			this.basicChoices();
			this.managerChoices();
		}

		Scanner readInput = new Scanner(System.in);
		menuChoice = readInput.nextInt();
		System.out.println(menuChoice);


		
		
		//menuChoice = Integer.parseInt(readInput.nextLine());
				
//		while(valid == false) {
//			System.out.println("Enter choice (#): ");
//			//menuChoice = Integer.parseInt(readInput.nextLine());
//			System.out.println("TEST");
//			
//			if(privLevel == 1 && (menuChoice >= 0 && menuChoice <= 6)) {
//				valid = true;
//			}
//			else if(privLevel > 1 && (menuChoice >= 0 && menuChoice <= 10)) {
//				valid = true;
//			}
//		}
		
		//System.out.println(menuChoice);
	}

	public static void main(String[] args) {
		
	}
}
