package com.java.login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDto;

import jdbc.statement.ConnectionProvider;

@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
	  String name = request.getParameter("username");
	  String passString=request.getParameter("password");
			//Connection con= ConnectionProvider.getConnection();
	  
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			
			String string="select * from userdata1 where Username=? and Password=?";
			
			//Statement stmt=con.createStatement();
			PreparedStatement pstmt=con.prepareStatement(string);
			pstmt.setString(1, name);
			pstmt.setString(2, passString);
			ResultSet set=pstmt.executeQuery();
			
			//while(set.next()) {
				/*
				 * int roll=set.getInt(1); String nameString=set.getString(2); String
				 * addressString=set.getString(3);
				 * System.out.println("Roll_no StudentName  Address"); System.out.println(roll
				 * +": "+nameString+": "+addressString);
				 */
				
				  if(set.next()) {
					  
						
						  String username =set.getString(1); 
						  String password=set.getString(2);
						  String name1=set.getString(3);
						  String email=set.getString(4);
						  
						  UserDto userDto=new UserDto(username,password,name1,email);
						  request.setAttribute("userDto", userDto);
				
						 
				  request.getRequestDispatcher("congrats.jsp").forward(request, response);
				  
				  }else {
				  request.setAttribute("msg","you have entered wrong username and password");
				  request.getRequestDispatcher("login.jsp").forward(request, response); }
				 
			//}
			
			con.close();
			
			
		} catch (Exception e) {
			
		  e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
