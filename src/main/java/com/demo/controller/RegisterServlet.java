package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.dto.UserDto;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class RegisterServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		UserDto user = new UserDto();
		user.setUsername(request.getParameter("firstname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setContact(request.getParameter("contact"));
		
		PrintWriter out = response.getWriter();
		UserService userservice = new UserServiceImpl();
		boolean result = userservice.registerUser(user);
		if(result== true) {
			out.print("Resigstration Successful");
		}
		else {
			out.print("Invalid Details");
		}
		
	}

}
