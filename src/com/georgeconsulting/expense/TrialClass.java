package com.georgeconsulting.expense;

import java.sql.*;

public class TrialClass {
	
	
	
	
	
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:8889/expenseReport";
			String password = "root";
			String user = "root";
         
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("select lastName,firstName from Employee");
			while ( rs.next() ) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				System.out.println("Employee: " + firstName + " " + lastName);
			}
			conn.close();
		}
		catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}


