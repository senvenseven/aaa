package shuben;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties props= new Properties();
	
	static {
		try {
			props.load(new FileInputStream("database.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection connection=null;
		try {
			String driver=props.getProperty("driver");
			String url=props.getProperty("url");
			String username=props.getProperty("username");
			String password=props.getProperty("password");
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
