package com.example.One.to.one.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/onetoone?useSSL=false";
		String user = "root";
		String pass = "18102001";
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection Successful!!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
