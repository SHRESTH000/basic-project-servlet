package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDto;
import com.mysql.cj.protocol.Resultset;

@WebServlet("/editRecordServlet")
public class EditRecordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			
			 String sqlquery="select * from userdata1 where username=?";
			 
			 PreparedStatement psmst=connection.prepareStatement(sqlquery);
			 
			 psmst.setString(1, username);
			 ResultSet resultset=psmst.executeQuery();
			 
			 if (resultset.next()) {
				 
				 String username1=resultset.getString(1);
				 String password=resultset.getString(2);
				 String name=resultset.getString(3);
				 String email=resultset.getString(4);
				 
				 UserDto userDto=new UserDto(username1,password,name,email);
				 
				 request.setAttribute("userDto", userDto);
				 request.getRequestDispatcher("Edit.jsp").forward(request, response);
			}
			 else {
				 request.setAttribute("msg", "no data is present here to update please try another data");
				 request.getRequestDispatcher("showAllRecordServlet").forward(request, response);
			 }
		} catch (Exception e) {

			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
