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
//		String storedPassword = null;
		
		//Asks for username
		System.out.println("Enter username: ");
		Scanner readInput = new Scanner(System.in);
		inputUsername = readInput.nextLine();
		
		//Asks for password
		System.out.println("Enter password: ");
		inputPassword = readInput.nextLine();
		
		MessageDigest mdEnc = MessageDigest.getInstance("MD5");
		mdEnc.update(inputPassword.getBytes(), 0, inputPassword.length());
		String encInputPassword = new BigInteger(1, mdEnc.digest()).toString(16);
		
		//Looks up in DB and pulls login information
		FetchQuery getLogin = new FetchQuery(conn.conn, queryStmt+inputUsername + "'");
		
		if(!getLogin.rs.next()) {
			System.out.println("*** WARNING: invalid username ***");
			System.exit(0);
		}
		else {
			if(!encInputPassword.equals(getLogin.rs.getString("password"))) {
				System.out.println("*** WARNING: password does not match username ***");
				System.exit(0);
			}
			else {
				storedID = getLogin.rs.getInt("empID");
			}
		}
		
		//readInput.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
