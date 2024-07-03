package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDto;

@WebServlet("/deleteRecordServlet")
public class DeleteRecordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     String username=request.getParameter("username"); 
		
		//List<UserDto> userlist=new ArrayList<UserDto>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			
			String sqlquery="delete from userdata1 where username=?";
			String sqlquery1="Select * from userdata1;";
			
			PreparedStatement psmst=connection.prepareStatement(sqlquery);
			
			psmst.setString(1, username);
			
			
			int NoofDeletedRows=psmst.executeUpdate();
			
			/*
			 * psmst=connection.prepareStatement(sqlquery1); ResultSet
			 * rs=psmst.executeQuery(); while(rs.next()) { String username1=rs.getString(1);
			 * String password=rs.getString(2); String name=rs.getString(3); String
			 * email=rs.getString(4);
			 * 
			 * UserDto userDto=new UserDto(username1,password,name,email);
			 * 
			 * userlist.add(userDto); }
			 */
			
			if(NoofDeletedRows>0) {
				
				//request.setAttribute("userlist", userlist);
				
				request.getRequestDispatcher("showAllRecordServlet").forward(request, response);
				
				System.out.println("Data is deleted");
			}else {
				System.out.println("Error is found");
				response.setContentType("text/html");
				PrintWriter pWriter=response.getWriter();
				pWriter.println("error is sound so soory");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
