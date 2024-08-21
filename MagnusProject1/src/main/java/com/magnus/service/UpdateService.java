package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.magnus.bean.UserBean;
import com.magnus.dao.DatabaseConnection;

public class UpdateService {
	public static final String UPDATE = " update employee set firstname=?,lastname=?,mobile=?,gender=?,birthdate=?,country=?,city=?, skills=? where email=?";

	public boolean update(UserBean ub) {
		boolean k = false;
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, ub.getFirstName());
			ps.setString(2, ub.getLastName());
			ps.setString(3, ub.getMobile());
			ps.setString(4, ub.getGender());
			ps.setString(5, ub.getDob());
			ps.setString(6, ub.getCountry());
			ps.setString(7, ub.getCity());
			String resultSkill = String.join(",", ub.getSkills());
			ps.setString(8, resultSkill);
			
			ps.setString(9, ub.getEmail());

			
			int x = ps.executeUpdate();// error
			if (x == 1) {
				k = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return k;
	}

}
