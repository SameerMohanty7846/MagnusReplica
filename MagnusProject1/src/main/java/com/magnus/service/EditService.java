package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.magnus.bean.UserBean;
import com.magnus.dao.DatabaseConnection;

public class EditService {
	public static final String GETOLDDATA="select * from employee where email=?";
	public UserBean getOldData(String email){
		UserBean finalUserBean=new UserBean();
		
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(GETOLDDATA);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				finalUserBean=new UserBean();
				finalUserBean.setAddress("ADD NEW ADDRESS");
				finalUserBean.setFirstName(rs.getString("firstname"));
				finalUserBean.setLastName(rs.getString("lastname"));
				finalUserBean.setMobile(rs.getString("mobile"));
				finalUserBean.setEmail(rs.getString("email"));
				finalUserBean.setGender(rs.getString("gender"));
				finalUserBean.setDob(rs.getString("birthdate"));
				finalUserBean.setCountry(rs.getString("country"));
				finalUserBean.setCity(rs.getString("city"));
				finalUserBean.setSkills(null);
				
			
			}
			
		

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return finalUserBean;
		
	}

}
