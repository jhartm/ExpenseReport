package com.georgeconsulting.expense;

//import java.sql.*;
//import java.util.Date;
//import java.text.*;
import java.util.Scanner;
import java.math.*;
import java.security.*;


public class TrialClass {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String text;
		String encText;
		
		System.out.println("Enter text: ");
		Scanner readInput = new Scanner(System.in);
		text = readInput.nextLine();
		
		MessageDigest mdEnc = MessageDigest.getInstance("MD5");
		mdEnc.update(text.getBytes(), 0, text.length());
		
		encText = new BigInteger(1, mdEnc.digest()).toString(16);
		
		System.out.println("Encrypted text: " + encText);
		//5f4dcc3b5aa765d61d8327deb882cf99
	}
}


