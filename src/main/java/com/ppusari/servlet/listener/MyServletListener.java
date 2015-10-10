package com.ppusari.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

 
public class MyServletListener implements ServletContextListener {

    public MyServletListener() {
    	System.out.println("MyServletListener");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("contextInitialized");
    }
	
}
