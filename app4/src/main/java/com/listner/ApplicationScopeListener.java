package com.listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationScopeListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	ServletContext applicationScope=sce.getServletContext();
    	
    	applicationScope.setAttribute("email", "jonnyjonny@gmail.com");
    }
	
}
