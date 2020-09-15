package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerFind_Id implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기
		CustomerDto dto = new CustomerDto();
		CustomerDao dao = new CustomerDao();
		///  이름 비밀번호 이메일 핸드폰번호
		HttpSession session = request.getSession(true);
		//dto.setCid((String)session.getAttribute("cid"));
		//dto.setMpass((String)session.getAttribute("mpass"));
		dto.setCname(request.getParameter("name_chk"));
		dto.setCpass(request.getParameter("pass_chk"));
		dto.setCemail(request.getParameter("email_chk"));
		dto.setCphone(request.getParameter("phone_chk"));
		/////

		//2. 
		if(dao.find_id(dto) !=null)
		{
			out.println("<script>alert('아이디 찾기  성공');</script>");
			request.setAttribute("dto", dao.find_id(dto));
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/customer_member/find_id_result.jsp'; </script>");
			request.getRequestDispatcher("/customer_member/find_id_result.jsp").forward(request, response);
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/start.customer'; </script>");
			
		}
		else
		{
			out.println("<script>alert('정보 확인 바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
	}//end execute

}//end class
