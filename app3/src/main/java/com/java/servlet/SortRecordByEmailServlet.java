package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserDto;

@WebServlet("/sortRecordByEmailServlet")
public class SortRecordByEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<UserDto> userDtoslist=new ArrayList<UserDto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			String sqlquery="select * from userdata1 ORDER BY EmailID;";
			
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(sqlquery);
			
			while(rs.next()) {
				String username=rs.getString(1);
				String password=rs.getString(2);
				String name=rs.getString(3);
				String email=rs.getString(4);
				
				UserDto userDto=new UserDto(username,password,name,email);
				userDtoslist.add(userDto);
				
			}
			if(userDtoslist!=null) {
				
				HttpSession session=request.getSession();
				session.setAttribute("userDtolist", userDtoslist);
				request.setAttribute("link", "	<a href=\"removeSortRecordServlet\"><button type=\"button\" class=\"btn btn-danger\">Remove</button></a>");
				request.getRequestDispatcher("showAllRecordServlet").forward(request, response);
				
			}
		
		
	} 
		
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
