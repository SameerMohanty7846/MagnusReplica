package com.magnus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.magnus.bean.UserBean;
import com.magnus.service.UpdateService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		UserBean ub = new UserBean();
		ub.setFirstName(req.getParameter("fname"));
		ub.setLastName(req.getParameter("lname"));
		ub.setEmail(req.getParameter("email"));
		ub.setMobile(req.getParameter("mobile"));
		ub.setDob(req.getParameter("date"));
		ub.setGender(req.getParameter("gender"));

		ub.setAddress(req.getParameter("address"));
		ub.setCountry(req.getParameter("country"));
		ub.setCity(req.getParameter("city"));
		String skills[] = req.getParameterValues("skills");
		ub.setSkills(skills);

		UpdateService is = new UpdateService();
		boolean k = is.update(ub);
		if (k) {
			res.sendRedirect("Employee-Search.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
