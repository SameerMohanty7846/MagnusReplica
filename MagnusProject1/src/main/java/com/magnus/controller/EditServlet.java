package com.magnus.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.magnus.bean.UserBean;
import com.magnus.service.EditService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		EditService es=new EditService();
		UserBean ub=es.getOldData(email);
		req.setAttribute("user", ub);
		RequestDispatcher rd=req.getRequestDispatcher("EditFormData.jsp");
		rd.forward(req, res);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
