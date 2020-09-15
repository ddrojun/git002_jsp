package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerMypage_view implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		CustomerDao dao = new CustomerDao();
		CustomerDto dto = new CustomerDto();
		//dto.setMid(request.getParameter("mid"));
		HttpSession session = request.getSession(true);
		//session.getAttribute("mid");
		dto.setCid((String)session.getAttribute("cid"));
		request.setAttribute("dto", dao.userinfo(dto) );
		//회원가입완료 join_com.jsp 경로넘기기
		request.getRequestDispatcher("/customer_member/mypage_edit.jsp").forward(request, response);

	}

}
