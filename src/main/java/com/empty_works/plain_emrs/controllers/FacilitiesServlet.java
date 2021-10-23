package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.dao.FacilityDao;

/**
 * Servlet implementation class FacilitiesServlet
 */
@WebServlet("/FacilitiesServlet")
public class FacilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilitiesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<FacilityBean> facilitiesList = FacilityDao.getList();
		request.setAttribute("facilitiesList", facilitiesList);
		request.getRequestDispatcher("/Facilities.jsp").forward(request, response);
	}
}
