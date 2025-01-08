package com.tinkus.backend.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	private final String URL="jdbc:mysql://127.0.0.1:3306/tinkus_backend";
	private final String USERNAME="root";
	private final String PASSWORD ="Sawan@2144";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//connection
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName (DRIVER);
		Connection connection = DriverManager.getConnection (URL, USERNAME, PASSWORD);
		System.out.println("Message: Database connected successfully..");
		return connection;
	}
	

	

//Close

public void close(Connection conn, PreparedStatement pstmt) throws SQLException {
	pstmt.close();
	conn.close();
}



}