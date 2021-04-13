package br.com.edfcbz.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static Connection conn = null;

	
	public static Connection getConnection(){
	
		if (conn == null) {
			String userName = "root";
			String password = "admin123";
			String timeZone = "&useTimezone=true&serverTimezone=UTC";
			String ssl 		= "?autoReconnect=true&useSSL=false";
			
			String url = "jdbc:mysql://localhost:3306/apirest"+ssl+timeZone;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn =  DriverManager.getConnection(url, userName, password );
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		return conn;
	}

}
