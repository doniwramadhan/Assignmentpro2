<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.*"%>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver");%>
<% ResultSet rs = null; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
      Connection connection = null;
      try
      {
         String url = "jdbc:mysql://localhost:3306/myjavacode";
         String user = "root";
         String password = "root";
         connection = DriverManager.getConnection(url, user, password);
         Statement statement = connection.createStatement() ;
         String sql = "select * from employee";
         rs = statement.executeQuery(sql);
     }
     catch(SQLException e)
     {
         System.out.println("Error!!!!!!" + e);
     }
 %>
 <div align="center">
  <h1>You have login successfully <br> Welcome 
   <% while(rs.next()){ %>
   <%= rs.getString("name") %>
   <% } %>
  </h1>
  
  <a href="logout.jsp">
 <button>Logout</button>
 </a>
 <a href="recorddata.html">
 <button>Add New Record</button>
 </a>
  
 </div>
</body>
</html>