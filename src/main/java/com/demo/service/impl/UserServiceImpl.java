package com.demo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.dto.UserDto;
import com.demo.service.UserService;
import com.demo.service.conn.UserServiceConn;

public class UserServiceImpl extends UserServiceConn implements UserService {

	@Override
	public boolean authenticateUser(Connection conn, String email, String password) {
		conn = getConnection();
		String query = "select * from user_details where email = ? and password = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerUser(UserDto user) {
		Connection conn = getConnection();
		String query1 = "select * from user_details where email=?";
		String query2 = "insert into user_details(username, email, password, contact) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query1);
			pstmt.setString(1,user.getEmail());
			ResultSet rst =  pstmt.executeQuery();
			if(rst.next()) {
				return false;
			}else {
				PreparedStatement pstmt1 = conn.prepareStatement(query2);
				pstmt1.setString(1, user.getUsername());
				pstmt1.setString(2,user.getEmail());
				pstmt1.setString(3, user.getPassword());
				pstmt1.setString(4, user.getContact());
				
				int count = pstmt1.executeUpdate();
				
				if(count == 1) {
					return true;
				}
			}
								
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
