package com.demo.service;

import java.sql.Connection;

import com.demo.dto.UserDto;

public interface UserService {
	 boolean authenticateUser( Connection con, String email,String password);
	 
	 boolean registerUser(UserDto user);
}
