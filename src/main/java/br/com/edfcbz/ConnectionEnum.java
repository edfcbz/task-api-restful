package br.com.edfcbz.api.enumeration;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * This enumeration define the ConnectionFactory 
 * 
 * Advantage: Serializable 
 * 
 * */
public enum ConnectionEnum {
	
	INSTANCE;	
	
	private static Connection conn = null;
	
	/*
	 * Optionally these String attributes of configuration can be moved to application.properties file	 * 
	 * */
	public Connection getConnection(){
	
		if (conn == null) {
			String userName = "root";
			String password = "admin123";
			String timeZone = "&useTimezone=true&serverTimezone=UTC";
			String ssl 		= "?autoReconnect=true&useSSL=false";
			String connectionType = "jdbc";
			String database = "mysql";
			String host = "localhost";
			String port = "3306";
			String schema = "apirest";
			
			//String url = "jdbc:mysql://localhost:3306/apirest"+ssl+timeZone;
			String url = connectionType +':' + database + ':' + "//" + host + ':' + port + '/' + schema + ssl + timeZone;
			
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

