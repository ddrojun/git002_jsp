package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerJoin_com implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터를 받아와서 데이터 삽입
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//데이터를 넘겨받아 회원가입
		CustomerDao dao = new CustomerDao();
		CustomerDto dto = new CustomerDto();
		dto.setCid(request.getParameter("cid"));
		request.setAttribute("dto", dao.userinfo(dto) );
		//회원가입완료 join_com.jsp 경로넘기기
		request.getRequestDispatcher("/customer_member/join_com.jsp").forward(request, response);
		
	}//end execute

}//end class



