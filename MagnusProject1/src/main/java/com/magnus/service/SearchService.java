package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.magnus.bean.RetrievedUserInfoBean;
import com.magnus.dao.DatabaseConnection;

public class SearchService {
	private static final String search=" select firstname,lastname,mobile,email,gender,birthdate,country,city from Employee where firstname=? or mobile=?";
	public ArrayList<RetrievedUserInfoBean> getSearchedData(String fname,String mobile){
		ArrayList<RetrievedUserInfoBean> al=new ArrayList<RetrievedUserInfoBean>();
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps=con.prepareStatement(search);
			ps.setString(1, fname);
			ps.setString(2, mobile);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RetrievedUserInfoBean rui=new RetrievedUserInfoBean();
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
