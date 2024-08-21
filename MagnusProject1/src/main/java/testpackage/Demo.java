package testpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.magnus.bean.RetrievedUserInfoBean;
import com.magnus.bean.UserBean;
import com.magnus.dao.DatabaseConnection;
import com.magnus.service.DeleteService;

public class Demo {
	public static final String GETOLDDATA="select * from employee where email=?";

	public static void main(String[] args) {
		
		try {
			DeleteService ds=new DeleteService();
			boolean k=ds.isDeleted("sameermohanty6369@gmail.com");
			if(k) {
				System.out.println("DELETEED");
			}
			
			
			
		

		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
	}

}
