package com.tinkus.backend.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	
//	 Step  2  One time only < if object does not exist  ---------------------------
	 
    public UserServlet() {
    	
    		System.out.println("UserServlet : Object created ");
    	
    }
    
    
//              Step 3   One time only < if object does not exist  ---------------------------
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("UserServlet : inti method ");
	}

//	/      Not in use ------------------------------------- Start
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}
	
//	/      Not in use ------------------------------------- End

//	   Step 4 ----------------------  Start   -----------------------
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : Service method ");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doGet method ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doPost method ");
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doPut method ");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doDelete method ");
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : dohead method ");
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doOption method ");
	}


	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet : doTrace method ");
	}
	

//	   Step 4 ----------------------  Start   -----------------------
	
	
	
//	 						  Step 5 Destroy executes once 
	
	
	public void destroy() {
		System.out.println("UserServlet : destroy method ");
	}

}
