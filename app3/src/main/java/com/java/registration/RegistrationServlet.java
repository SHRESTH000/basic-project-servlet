package com.java.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			 
			 String sqlQuery="insert into userdata1 values (?,?,?,?)";
			 
			 PreparedStatement pmtst=connection.prepareStatement(sqlQuery);
			 pmtst.setString(1, username);
			 pmtst.setString(2, password);
			 pmtst.setString(3, name);
			 pmtst.setString(4, email);
			 
			 int NoOfRowsInsert=pmtst.executeUpdate();
			 
			 if (NoOfRowsInsert>0) {
				 
				 System.out.println("new user is register");
				 request.setAttribute("msgFromRegister", "You have sucessfully register");
				 request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				
				request.setAttribute("msgFromRegister", "you have not sucessfully register please try Again");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				System.out.println(NoOfRowsInsert);
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
