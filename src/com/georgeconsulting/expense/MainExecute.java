package com.georgeconsulting.expense;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class MainExecute {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		//Create new DB connection
		DBConnect conn = new DBConnect();
		
		//Login process
		Login user = new Login(conn);
				
		System.out.println("-------------------------------------------");
		
		//Pulls employee (current user) information from DB
		Employee currentUser = new Employee(user.storedID, conn);
		
		Menu choice = new Menu();
		choice.getChoice(currentUser.privLevel);
		
		TravelExpenseReport newReport = new TravelExpenseReport();
		newReport.newEntry(conn.conn, currentUser);
		
		//Closes the connection when done
		conn.conn.close();
	}

}
