package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpBean {


		static final String DB_URL = "jdbc:mysql://localhost:3306/myjavacode";
		
		static final String USER = "root";

		static final String PASS = "root";
		
		static String name;
		static String email;
		static String username;
		static String password;
		static String confirmpassword;
		static String contact;
		static String photo;
		
		
		public SignUpBean(String name, String email, String username, String password, String confirmpassword, String contact, String photo) {
			SignUpBean.name = name;
			SignUpBean.email = email;
			SignUpBean.username = username;
			SignUpBean.password = password;
			SignUpBean.confirmpassword = confirmpassword;
			SignUpBean.contact = contact;
			SignUpBean.photo = photo;
			
		}
		
		public static void MyRecordValue() {
			System.out.println("Query execution steps");
			
			Connection conn = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("conecting to database");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
							
				String SQL = "INSERT INTO employee (name,email,username,password,confirmpassword,contact,photo)"+"VALUES (?,?,?,?,?,?,?)";
				
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				conn.setAutoCommit(false);
				
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, username);
				pstmt.setString(4, password);
				pstmt.setString(5, confirmpassword);
				pstmt.setString(6, contact);
				pstmt.setString(7, photo);
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

