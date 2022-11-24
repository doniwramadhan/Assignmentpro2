package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SignUpBean;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");

		String email =request.getParameter("email");

		String username =request.getParameter("username");

		String password =request.getParameter("password");

		String confirmpassword =request.getParameter("confirmpassword");
		
		String contact =request.getParameter("contact");
		
		String photo =request.getParameter("photo");
				
		new SignUpBean (name,email,username,password,confirmpassword,contact,photo);
		SignUpBean.MyRecordValue();
	}
}