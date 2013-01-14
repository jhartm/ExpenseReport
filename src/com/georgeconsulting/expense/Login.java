package com.georgeconsulting.expense;

import java.sql.*;

public class Login {

	String inputUsername;
	String inputPassword;
	String attachedID;
	
	String queryStmt = "SELECT * FROM Login WHERE username = ";
	
	public Login (DBConnect conn, String inUser, String inPass) throws SQLException {
		FetchQuery loginQuery = new FetchQuery(conn.conn, queryStmt+inUser);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
