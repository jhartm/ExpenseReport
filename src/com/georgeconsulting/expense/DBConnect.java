package com.georgeconsulting.expense;

import java.sql.*;

public class DBConnect {

	//Creates a new connection
	Connection conn;
	
	//Database access fields
	String url = "jdbc:mysql://localhost:8889/expenseReport";
	String password = "root";
	String user = "root";
	
	//Constructor
	public DBConnect() throws SQLException {
		try {
			//Dynamically loads class named "com.mysql.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver");
		
			//Sets the connection
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}