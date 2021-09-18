package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.LoginBean;
import com.empty_works.plain_emrs.dao.LoginDao;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request = request;
		this.response = response;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();
		
		String userRole = loginDao.authenticateUser(loginBean);
		if(userRole.equals(PlainEmrsRoles.adminRole)) {
			
			
		}
	}

	/**
	 * 
	 * @param role
	 * @param username
	 */
	private void setSessionUserAndRole(String role, String username) {
		
		System.out.println(role + "'s " + "Home");
		HttpSession session = request.getSession();
		session.setAttribute(username, username);
		try {
			request.getRequestDispatcher("/jsp/" + role + ".jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
