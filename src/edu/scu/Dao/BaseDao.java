package edu.scu.Dao;

import java.sql.*;

/*
 * database setup
 * get Connection and Statement object
 * */

public class BaseDao {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/2048Game?user=root&password=root&useSSL=false&serverTimezone=GMT";
    static final String USER = "root";
    static final String PASS = "rootroot";// please change the password according to your local mysql password
    static Connection conn = null;
    Statement stmt = null;
    
    public BaseDao() {
    	try {
    		Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
