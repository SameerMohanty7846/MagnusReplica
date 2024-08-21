package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.magnus.bean.RetrievedUserInfoBean;
import com.magnus.dao.DatabaseConnection;

public class DisplayService {
	private static final String display=" select id,firstname,lastname,mobile,email,gender,birthdate,country,city from Employee";
	public ArrayList<RetrievedUserInfoBean> getData(){
		ArrayList<RetrievedUserInfoBean> al=new ArrayList<RetrievedUserInfoBean>();
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps=con.prepareStatement(display);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RetrievedUserInfoBean rui=new RetrievedUserInfoBean();
				rui.setId(rs.getString("id"));

				rui.setFirstName(rs.getString("firstname"));
				rui.setLastName(rs.getString("lastname"));
				rui.setMobile(rs.getString("mobile"));
				rui.setEmail(rs.getString("email"));
				rui.setGender(rs.getString("gender"));
				rui.setDob(rs.getString("birthdate"));
				rui.setCountry(rs.getString("country"));
				rui.setCity(rs.getString("city"));
				al.add(rui);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
		
	}

}
