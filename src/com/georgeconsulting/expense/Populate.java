package com.georgeconsulting.expense;

import java.sql.*;

public class Populate {
	Statement stmt = null;
	
	public Populate(DBConnect conn, String queryStmt) throws SQLException {
		stmt = conn.conn.createStatement();
		stmt.executeUpdate(queryStmt);
	}
}
