package com.georgeconsulting.expense;

import java.sql.*;
import java.sql.SQLException;

public class Contract {
	int contractID;
	String contractName;
	
	String queryStmt = "SELECT * FROM ChargeTo";
	
	public Contract(Connection conn) throws SQLException {
		FetchQuery list = new FetchQuery(conn, queryStmt);
		
		System.out.println("Available contracts:");
		while(list.rs.next()) {
			contractID = list.rs.getInt("contractID");
			contractName = list.rs.getString("contract");
			
			System.out.println(contractID + "  " + contractName);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
