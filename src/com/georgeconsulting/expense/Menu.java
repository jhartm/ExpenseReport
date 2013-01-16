package com.georgeconsulting.expense;

import java.util.Scanner;

public class Menu {
//	private static final int Integer.parseInt(menuChoice) = 0;
	String menuChoice;
	String[] basic = new String[12];
	String logout;
	
	public void setChoice() {
		basic[0] = "Done";
		basic[1] = "Create";
		basic[2] = "Edit";
		basic[3] = "Delete";
		basic[4] = "View pending";
		basic[5] = "View approved";
		basic[6] = "View completed";
		basic[7] = "View all pending";
		basic[8] = "Approve/reject pending";
		basic[9] = "View all approved";
		basic[10] = "View all completed";
	}
	
	
	
	public void getChoice(int privLevel) {
		Boolean valid = false;
		
		this.setChoice();
		
		System.out.println("Basic user level options:");
		if(privLevel == 1) {
			for(int i = 0; i < 7; i++) {
				System.out.println(i + "  - " + basic[i]);
			}
				System.out.println("Logout - [L]");
			
		}
		else if(privLevel > 1) {
			for(int i = 0; i < 11; i++) {
				if(i == 7) {
					System.out.println("Manager level options:");
				}
				System.out.println(i + "  - " + basic[i]);
			}
				System.out.println("Logout - [L]");
			
		}

		Scanner readInput = new Scanner(System.in);
						
		while(valid == false) {
			System.out.println("Enter choice (#): ");
			menuChoice = readInput.nextLine();
			
			if(!menuChoice.equalsIgnoreCase("L")){
			
			int choice = Integer.parseInt(menuChoice); 
			
			if(privLevel == 1 && (choice >= 0 && choice <= 6)) {
				valid = true;
			}
			else if(privLevel > 1 && (choice >= 0 && choice <= 10)) {
				valid = true;
			}
			}
			else {
				
				System.exit(0);
			}
				
			}
				
		//return menuChoice;
	}



//	private int IntegerParseInt(String menuChoice2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
}
