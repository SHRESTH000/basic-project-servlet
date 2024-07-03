package com.java.servlet;

import java.io.IOException;
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
import com.mysql.cj.protocol.Resultset;

@WebServlet("/showAllRecordServlet")
public class ShowAllRecordServet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserDto> userlist=new ArrayList<UserDto>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			
			String sqlquery="select * from userdata1";
			
			PreparedStatement psmst=connection.prepareStatement(sqlquery);
			ResultSet resultset=psmst.executeQuery();
			
			while(resultset.next()) {
				
				String username=resultset.getString(1);
				String password=resultset.getString(2);
				String name=resultset.getString(3);
				String email=resultset.getString(4);
				
				UserDto userDto=new UserDto(username,password,name,email);
				
				userlist.add(userDto);
				
			}
			
			//System.out.println(userlist);
			
			
			  request.setAttribute("userlist", userlist);
			  request.getRequestDispatcher("NewShowAllRecord.jsp").forward(request,
			  response);
			 
			
		} catch (Exception e) {
          
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
