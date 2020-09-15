package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerFind_Pass implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기
		CustomerDto dto = new CustomerDto();
		CustomerDao dao = new CustomerDao();
		/// 아이디 이름 이메일 핸드폰번호
		HttpSession session = request.getSession(true);
		//dto.setCid((String)session.getAttribute("cid"));
		//dto.setMpass((String)session.getAttribute("mpass"));
		dto.setCid(request.getParameter("id_chk"));
		dto.setCname(request.getParameter("name_chk"));
		dto.setCemail(request.getParameter("email_chk"));
		dto.setCphone(request.getParameter("phone_chk"));
		/////

		//2. 
		if(dao.find_pass(dto) !=null)
		{
			out.println("<script>alert('비밀번호 찾기  성공');</script>");
			request.setAttribute("dto", dao.find_pass(dto));
			request.getRequestDispatcher("/customer_member/find_pass_result.jsp").forward(request, response);
		}
		else
		{
			out.println("<script>alert('정보 확인 바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
//		if(dao.find_pass(dto) != null)
//		{
//			out.println("<script>alert('비밀번호 찾기  성공');</script>");
			//out.println("<script>alert();</script>");
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/detail.do?bno="+Integer.parseInt(request.getParameter("bno"))+"'; </script>");
//			out.println("<script>"+"location.href='"+request.getContextPath()+"/start.customer'; </script>");
//		}
//		else
//		{
//			out.println("<script>alert('정보 확인 바람 ');</script>");
//			out.println("<script> history.go(-1); </script>");
//		}
		
		
	}//end exucute

}//end class
