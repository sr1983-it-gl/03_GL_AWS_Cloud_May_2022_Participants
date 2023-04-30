package rds.multiaz.demo;

public class ApplicationConstants {

	public static String DRIVER_CLASS_NAME 
		= "com.mysql.cj.jdbc.Driver";

	public static String 
//		HOST = "1.2.3.4" [pI]
				
		HOST = "rds-multi-instance-1.chlb1cfae6do.us-east-1.rds.amazonaws.com";
	
	public static String DB_NAME = "mynewdb";
	
	public static String USERNAME = "admin";
	
	public static String PASSWORD = "password";
	
	public static String CONNECTION_URL
		=	"jdbc:mysql://" + HOST + ":3306/" + DB_NAME;
	
}
