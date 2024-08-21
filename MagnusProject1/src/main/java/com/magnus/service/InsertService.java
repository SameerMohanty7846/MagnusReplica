package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.magnus.bean.UserBean;
import com.magnus.dao.DatabaseConnection;

public class InsertService {
	public static final String INSERT = "INSERT INTO Employee(firstname,lastname,mobile ,email,gender,birthdate ,country ,city,skills)\r\n"
			+ "     values(?,?,?,?,?,?,?,?,?);";

	public boolean insert(UserBean ub) {
		boolean k=false;
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, ub.getFirstName());
			ps.setString(2, ub.getLastName());
			ps.setString(3, ub.getMobile());
			ps.setString(4, ub.getEmail());
			ps.setString(5, ub.getGender());
			ps.setString(6, ub.getDob());
			ps.setString(7, ub.getCountry());
			ps.setString(8, ub.getCity());
			String resultSkill = String.join(",", ub.getSkills());
			ps.setString(9, resultSkill);
			int x=ps.executeUpdate();//error
			if(x==1) {
				k=true;
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return k;
	}

}
