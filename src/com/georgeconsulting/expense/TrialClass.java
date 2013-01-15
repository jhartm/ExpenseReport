package com.georgeconsulting.expense;

//import java.sql.*;
import java.util.Date;
import java.text.*;

public class TrialClass {
	public static void main(String[] args) {
		Date todaysDate = new Date();
		SimpleDateFormat requestDate = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(requestDate.format(todaysDate));
	}
}


