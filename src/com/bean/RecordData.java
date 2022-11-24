package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecordData {
	static final String DB_URL = "jdbc:mysql://localhost:3306/myjavacode";
	
	static final String USER = "root";

	static final String PASS = "root";
	
	static String file;
	static String comment;
	
	
	public RecordData(String file, String comment ) {
		SignUpBean.name = file;
		SignUpBean.email = comment;
	
		
	}
	
	public static void MyRecordValue() {
		System.out.println("Query execution steps");
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("conecting to database");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
						
			String SQL = "INSERT INTO record (name,email)"+"VALUES (?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, file);
			pstmt.setString(2, comment);
			
			pstmt.addBatch();
			
			pstmt.executeBatch();
			conn.commit();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(conn!=null)
				conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
}
