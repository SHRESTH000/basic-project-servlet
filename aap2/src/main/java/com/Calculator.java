package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator1")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw=response.getWriter();
		
		String number1=request.getParameter("num1");
		String number2=request.getParameter("num2");
	    String op=request.getParameter("operator");
	    String opt=request.getParameter("+");
	    char oper=op.charAt(0);
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);
		int result=0;
		String data=" "; 
		
//		pw.println(num1);
		
		
		switch(oper){
		
		case '+' :{
			result=num1+num2;
			data="sum";
			break;
		}
		case '-':{
			result=num1-num2;
			data="difference";
			break;
		}
		case '*':{
			result=num1*num2;
			data="multiplication";
			break;
		}
		case '/':{
			result=num1/num2;
			data="division";
			break;
		}
		default:{
			pw.println("your enter symbol is wrong");
		}
		
		}
//		response.setContentType("text/html");
//		pw.println("your result is "+result);
		
		
		
		
//		   pw.println(opt);
		
		 		
		request.setAttribute("result", result);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
		request.setAttribute("detail", data);
	    request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}
	

}
