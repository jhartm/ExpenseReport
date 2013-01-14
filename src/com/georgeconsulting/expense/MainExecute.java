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
		
		@SuppressWarnings("unused")
		Menu choice = new Menu(currentUser.privLevel);
		
		//Closes the connection when done
		conn.conn.close();
	}

}
