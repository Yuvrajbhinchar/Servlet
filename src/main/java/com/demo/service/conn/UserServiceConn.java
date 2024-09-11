package com.demo.service.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserServiceConn {
	
	protected Connection getConnection(){
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/grras";
		String username = "root";
		String password = "yuvraj@3933";
		Connection conn = null;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
