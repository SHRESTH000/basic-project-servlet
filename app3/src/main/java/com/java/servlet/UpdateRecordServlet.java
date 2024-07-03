package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2735523237679005356L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      String username=request.getParameter("username");	
	      String password=request.getParameter("password");	
	      String name=request.getParameter("name");	
	      String email=request.getParameter("email");
	      
	     // System.out.println(username+" "+password+" "+name+" "+email);
	      
			
			  try {
			  
			  Class.forName("com.mysql.jdbc.Driver");
			  
			  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			  
			  String sqlquery=" UPDATE userdata1 SET Password=?,Name=?,EmailID=? where Username=?";
			  
			  
			  PreparedStatement psmst=connection.prepareStatement(sqlquery);
			  
			  psmst.setString(1, password); 
			  psmst.setString(2, name);
			  psmst.setString(3, email);
			  psmst.setString(4, username);
			  
			  int noofRowUpdated=psmst.executeUpdate();
			  
			  if (noofRowUpdated>0) 
			  { 
				  request.setAttribute("msg", "Data is updated");
			      System.out.println("rows update");
			      request.getRequestDispatcher("showAllRecordServlet").forward(request,response); 
			      }  
			  else  
			  {    
				  request.setAttribute("msg", "Data is not updated");
			      System.out.println("rows is not updated");
			     request.getRequestDispatcher("showAllRecordServlet").forward(request,response);
			  
			  }
			  
			  
			  
			  } catch (Exception e) {
			  
			  e.printStackTrace(); }
			 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
