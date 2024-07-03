package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/factorialServlet")
public class FactorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		long nums=Integer.parseInt(num);
		 int fact=1;
		for(int i=1;i<=nums;i++) {
			fact=fact*i;
		}
		
		/*
		 * request.setAttribute("result", fact);
		 * request.getRequestDispatcher("fact.jsp").forward(request, response);
		 */
		
		HttpSession session=request.getSession();
		session.setAttribute("result", fact);
		
		ServletContext servletContext=getServletContext();
		servletContext.setAttribute("email", "email@gmail.com");
		request.getRequestDispatcher("fact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
