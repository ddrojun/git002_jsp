package com.alex0517.Customercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerMypage_pass_view implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		CustomerDto dto = new CustomerDto();
		CustomerDao dao = new CustomerDao();
		//dto.setMid(request.getParameter("mid"));
		HttpSession session = request.getSession(true);
		//session.getAttribute("mid");
		dto.setCid((String)session.getAttribute("cid"));
		dto.setCpass((String)session.getAttribute("cpass"));
		request.setAttribute("dto", dao.userinfo(dto) );
		///
		request.getRequestDispatcher("/customer_member/mypage_pass.jsp").forward(request, response);

	}//end execute

}//end class
