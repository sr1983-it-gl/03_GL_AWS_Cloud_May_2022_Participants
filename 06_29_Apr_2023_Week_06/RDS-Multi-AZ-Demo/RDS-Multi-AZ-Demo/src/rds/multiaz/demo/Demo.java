package rds.multiaz.demo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Demo {

	public static void main(String[] args) {
		
		String mySqlDriverClassName 
		= ApplicationConstants.DRIVER_CLASS_NAME;
		
		try {
			Class.forName(mySqlDriverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String connectionUrl = ApplicationConstants.CONNECTION_URL;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			
			connection = DriverManager.getConnection(
				connectionUrl,
				ApplicationConstants.USERNAME,
				ApplicationConstants.PASSWORD);

			try {
				InetAddress address 
					= InetAddress.getByName(ApplicationConstants.HOST);

				System.out.println(address.getHostAddress());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			System.out.println("Database Connection DONE");
			System.out.println(new Date().toString());

			
			statement = connection.createStatement();
						
			String selectQuery = String.format(
					"SELECT id, name from mydb.player");		
			
			System.out.println(selectQuery);
			
			resultSet = statement.executeQuery(selectQuery);
			
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
							
				System.out.println(
					String.format("Id is %d, Name is %s ", 
						id, name));
			}
									
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
			
	}
}
