package com.georgeconsulting.expense;

import java.sql.*;

public class MainExecute {

	public static void main(String[] args) throws SQLException {
		//Create new DB connection
		DBConnect conn = new DBConnect();
		
		//Login process
		Login user = new Login(conn);
				
		System.out.println("-------------------------------");
		
		//Pulls employee (current user) information from DB
		Employee currentUser = new Employee(user.storedID, conn);
		
		Menu choice = new Menu();
		System.out.println(choice.getChoice(currentUser.privLevel));
		
		@SuppressWarnings("unused")
		TravelExpenseReport newReport = new TravelExpenseReport(conn.conn, currentUser);
		
		//Closes the connection when done
		conn.conn.close();
	}

}
