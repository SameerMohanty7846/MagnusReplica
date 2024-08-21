package com.magnus.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.magnus.bean.RetrievedUserInfoBean;
import com.magnus.service.SearchService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SearchEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fname=req.getParameter("fname");
		String mobile=req.getParameter("mobile");
		SearchService ss=new SearchService();
		ArrayList<RetrievedUserInfoBean> al=ss.getSearchedData(fname,mobile);
		req.setAttribute("arraylist", al);
		RequestDispatcher rd=req.getRequestDispatcher("SearchEmployee.jsp");
		rd.forward(req, res);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
