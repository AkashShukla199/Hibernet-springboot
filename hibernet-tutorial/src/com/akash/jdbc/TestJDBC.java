package com.akash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:sqlserver://localhost:1433;databaseName=akash";
		String user="sa";
		String pass="enter";
		try {
			System.out.println("connection started");
			@SuppressWarnings("unused")
			Connection conn=DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successfull"+conn);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
