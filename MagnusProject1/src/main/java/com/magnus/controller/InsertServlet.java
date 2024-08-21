package com.magnus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.magnus.bean.UserBean;
import com.magnus.service.InsertService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {

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
//		pw.println("<h1>"+ub.getFirstName()+"</h1>");
//		pw.println("<h1>"+ub.getLastName()+"</h1>");
//		pw.println("<h1>"+ub.getAddress()+"</h1>");
//		pw.println("<h1>"+ub.getCity()+"</h1>");
//		pw.println("<h1>"+ub.getCountry()+"</h1>");
//		pw.println("<h1>"+ub.getDob()+"</h1>");
//		pw.println("<h1>"+ub.getEmail()+"</h1>");
//		pw.println("<h1>"+ub.getGender()+"</h1>");
//		pw.println("<h1>"+ub.getMobile()+"</h1>");
//		
//		for(String s:skills) {
//			pw.println("<h1>"+s+"</h1>");
//
//		}

		InsertService is = new InsertService();
		boolean k = is.insert(ub);
		if (k) {
			res.sendRedirect("Employee-Search.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
