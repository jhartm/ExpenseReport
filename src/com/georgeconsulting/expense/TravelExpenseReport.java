package com.georgeconsulting.expense;

import java.sql.*;

public class TravelExpenseReport {
	int reportID;
	int empID;
	int contractID;
	int estExpenses;
	int actExpenses;
	Date dates;
	int approvalStatus;
	int reportStatus;
	
	public TravelExpenseReport(Employee user) {
		empID = user.empID;
		
		
	}
}
