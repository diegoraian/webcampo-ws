package com.sharedtractor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.sharedtractor.utils.Constantes;
import com.sharedtractor.utils.SiteUtil;
import com.mysql.jdbc.Driver;
public class DAO implements IDAO{
	
	private DAO() {
	}
	
	@SuppressWarnings("finally")
	public static Connection getConnection()  {
		Connection conn = null; 
		try{
			Object dbms = Class.forName("com.mysql.jdbc.Driver");
			
			Properties connectionProps = new Properties();
			connectionProps.put("user", username);
			connectionProps.put("password", password);

		    if (SiteUtil.isNotNull(dbms)) {
		        conn = DriverManager.getConnection(
		                   "jdbc:mysql://" +
		                   serverName +
		                   ":" + portNumber + "/",
		                   connectionProps);
		    }
			} catch(SQLException ae){
		    	System.out.println(ae.getMessage());
		    }finally {
		    	return conn;	
			}
	}
	
	
	public static void closeConnection(Connection conn,ResultSet rs, PreparedStatement ps){
		try {
			if(conn != null){
				conn.close();
			}else if(rs != null){
				rs.close();
			}else if(ps != null){
				ps.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
