package com.emids.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://172.16.138.29:3306/javatest", "developer", "developer");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
