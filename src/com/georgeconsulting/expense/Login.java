package com.georgeconsulting.expense;

import java.sql.*;
import java.util.Scanner;
import java.math.*;
import java.security.*;

public class Login {

	String inputUsername;
	String inputPassword;
	int storedID;
	
	String queryStmt = "SELECT * FROM Login WHERE username = '";
	
	public Login (DBConnect conn) throws SQLException, NoSuchAlgorithmException{
		String storedPassword = null;
		
		//Asks for username
		System.out.println("Enter username: ");
		Scanner readInput = new Scanner(System.in);
		inputUsername = readInput.nextLine();
		
		//Looks up in DB and pulls login information
		FetchQuery getLogin = new FetchQuery(conn.conn, queryStmt+inputUsername + "'");
		
		//Asks for password
		System.out.println("Enter password: ");
		inputPassword = readInput.nextLine();
		
		MessageDigest mdEnc = MessageDigest.getInstance("MD5");
		mdEnc.update(inputPassword.getBytes(), 0, inputPassword.length());
		String encInputPassword = new BigInteger(1, mdEnc.digest()).toString(16);
		
		//Checks password
		while(getLogin.rs.next()) {
			storedPassword = getLogin.rs.getString("password");
		
			if(encInputPassword.equals(storedPassword)) {
				System.out.println("***Access Granted***");
				storedID = getLogin.rs.getInt("empID");
			}
			else {
				System.out.println("***Access denied - Invalid username/password***");
				
				System.exit(0);
			}
		}
		
		//readInput.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
