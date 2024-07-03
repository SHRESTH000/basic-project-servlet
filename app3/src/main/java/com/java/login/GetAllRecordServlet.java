package com.java.login;

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

@WebServlet("/getallrecord")
public class GetAllRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabases","root","shresth@12345");
			
			String sqlQuery="select * from userdata1;";
			
			PreparedStatement pstmt=connection.prepareStatement(sqlQuery);
			ResultSet rs=pstmt.executeQuery();
			
			List<UserDto> userDtos=new ArrayList<>();
			
			if(rs!=null) 
			{
			       while(rs.next())			    	   
			       {
				       String username=rs.getString(1);
				       String password=rs.getString(2);
				       String name=rs.getString(3);
				       String email=rs.getString(4);
				
				       UserDto  userDto=new UserDto(username,password,name,email);
				       userDtos.add(userDto);
			       }
			   request.setAttribute("userDtos", userDtos);
			   request.getRequestDispatcher("alluser.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Your data base have no data record");
				request.getRequestDispatcher("ShowAllRecord.jsp").forward(request, response);
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
