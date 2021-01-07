package com.lec.person;

public class DBInfo {
	
	public DBInfo() {}
	
	public static String ORACLE_DRIVER 	= "oracle.jdbc.driver.OracleDriver";	
	public static String ORACLE_URL 	= "jdbc:oracle:thin:@localhost:1521:xe";	
	public static String ORACLE_ID 		= "scott";
	public static String ORACLE_PWD 	= "tiger";

	public static String MYSQL_DRIVER 	= "com.mysql.cj.jdbc.Driver";
	public static String MYSQL_URL 		= "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
	public static String MYSQL_ID 		= "root";
	public static String MYSQL_PWD 		= "mysql";
}

