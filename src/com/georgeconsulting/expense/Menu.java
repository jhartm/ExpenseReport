package com.georgeconsulting.expense;

import java.util.Scanner;

public class Menu {
	int menuChoice;
	String[] basic = new String[11];
	
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
	
	public int getChoice(int privLevel) {
		Boolean valid = false;
		
		this.setChoice();
		
		System.out.println("Basic user level options:");
		if(privLevel == 1) {
			for(int i = 0; i < 7; i++) {
				System.out.println(i + "  - " + basic[i]);
			}
		}
		else if(privLevel > 1) {
			for(int i = 0; i < 11; i++) {
				if(i == 7) {
					System.out.println("Manager level options:");
				}
				System.out.println(i + "  - " + basic[i]);
			}
		}

		Scanner readInput = new Scanner(System.in);
						
		while(valid == false) {
			System.out.println("Enter choice (#): ");
			menuChoice = readInput.nextInt();
			
			if(privLevel == 1 && (menuChoice >= 0 && menuChoice <= 6)) {
				valid = true;
			}
			else if(privLevel > 1 && (menuChoice >= 0 && menuChoice <= 10)) {
				valid = true;
			}
		}
				
		return menuChoice;
	}

	
}
