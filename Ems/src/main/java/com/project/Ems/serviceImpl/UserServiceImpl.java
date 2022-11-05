package com.project.Ems.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.project.Ems.dbutil.DBUtil;
import com.project.Ems.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Connection connection;
	int flag=0;
	
	public UserServiceImpl() throws SQLException {
		connection=DBUtil.getConnection();
		
	}

	@Override
	public int loginValidation(String username, String password) {
		
		try {
			PreparedStatement statement=connection.prepareStatement(" select * from employee_management_system.users where username ='"+username+"'");
		
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(username)&& rs.getString(2).equals(password)) {
					flag=1;
				}else {
					System.out.println("Invalid username/password");
					flag=0;
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return flag;
	}
	
	

}
