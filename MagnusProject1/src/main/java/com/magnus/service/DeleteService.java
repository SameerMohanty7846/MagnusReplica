package com.magnus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.magnus.dao.DatabaseConnection;

public class DeleteService {
	private static final String DELETE="delete from employee where id=?";
	public boolean isDeleted(String id) {
		try {
			DatabaseConnection dc = new DatabaseConnection();
			Connection con = dc.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1, id);
			int x=ps.executeUpdate();
			if(x>=1) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
