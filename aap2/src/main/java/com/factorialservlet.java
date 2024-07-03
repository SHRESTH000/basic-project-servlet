package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/factorialservlet")
public class factorialservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String number=request.getParameter("num");
		int num=Integer.parseInt(number);
		int factorial=1;
		for(int i=1; i<=num;i++) {
			factorial=factorial*i;
		}
		String string="Factorial";
		
//		response.setContentType("text/html");
//		PrintWriter pw=response.getWriter();
//		pw.println("your factorial is "+factorial);
		
		request.setAttribute("result", factorial);
		request.getRequestDispatcher("result.jsp").forward(request,response);
		
		request.setAttribute("detail", string);
		request.getRequestDispatcher("result.jsp").forward(request,response);
		
		
//		response.sendRedirect("result.jsp");
	}
	
	


}
