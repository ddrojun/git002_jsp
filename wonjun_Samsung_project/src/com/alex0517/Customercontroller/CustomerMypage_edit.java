package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerMypage_edit implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기
		CustomerDto dto = new CustomerDto();
		CustomerDao dao = new CustomerDao();
		///
		dto.setCname(request.getParameter("cname"));
		dto.setCemail(request.getParameter("cemail") );   //.replace("\r\n", "<br>") 
		dto.setCbirth(request.getParameter("cbirth") );
		dto.setCphone(request.getParameter("cphone") );
		///
		dto.setCpostcode(request.getParameter("cpostcode"));
		dto.setCpost1(request.getParameter("cpost1"));
		dto.setCpost2(request.getParameter("cpost2"));
		///
		HttpSession session = request.getSession(true);
		dto.setCid((String)session.getAttribute("cid"));
		dto.setCpass((String)session.getAttribute("cpass"));
		/////

		//2. 데이터 수정
		
		if(dao.user_edit(dto) >0)
		{
			out.println("<script>alert('수정 성공');</script>");
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/detail.do?bno="+Integer.parseInt(request.getParameter("bno"))+"'; </script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/mainpage_view.customer'; </script>");
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
			
		
		
	}//end execute

}//end class
