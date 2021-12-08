package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.dao.RoleDao;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/FacilityServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RoleBean rb = new RoleBean();
		rb.setId(request.getParameter("roleId"));
		rb.setName(request.getParameter("roleName"));
		rb.setGroup(request.getParameter("roleGroup"));
		rb.setDescription(request.getParameter("roleDescription"));
		
		String result = RoleDao.add(rb);
		System.out.println("RoleServlet result = " + result);
		if(result.equals(RoleDao.ROLEDAO_SUCCESS)) {
			
			doGet(request, response);
		}
	}

}
