package com.alex0517.Customercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerLogout implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		///
		HttpSession session = request.getSession(true);
		//session.removeAttribute("mid");
		session.invalidate();
		//request.getRequestDispatcher("/login_view.members").forward(request, response);
		request.getRequestDispatcher("/layout/mainpage.jsp").forward(request, response);
	}

}
