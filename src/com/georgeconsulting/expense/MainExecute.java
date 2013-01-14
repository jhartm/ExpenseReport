package com.georgeconsulting.expense;

import java.sql.*;
import java.util.Scanner;

public class MainExecute {

	public static void main(String[] args) throws SQLException {
		String inputUsername;
		String inputPassword;
		String storedPass = null;
		int numID = 0;
		
		DBConnect conn = new DBConnect();
		
		System.out.println("Enter username: ");
		Scanner readInput = new Scanner(System.in);
		inputUsername = readInput.nextLine();
		
		FetchQuery getLogin = new FetchQuery(conn.conn, "SELECT * FROM Login WHERE username = '"+inputUsername+"'");
		
		System.out.println("Enter password: ");
		inputPassword = readInput.nextLine();
		
		while(getLogin.rs.next()) {
			storedPass = getLogin.rs.getString("password");
		
			if(inputPassword.equals(storedPass)) {
				System.out.println("***Access Granted***");
				numID = getLogin.rs.getInt("empID");
			}
			else {
				System.out.println("***Access denied - Invalid username/password***");
				
				System.exit(0);
			}
		}
		
		readInput.close();
				
		System.out.println("-------------------------------");
		
		@SuppressWarnings("unused")
		Employee currentUser = new Employee(numID, conn);
		
		conn.conn.close();

	}

}
