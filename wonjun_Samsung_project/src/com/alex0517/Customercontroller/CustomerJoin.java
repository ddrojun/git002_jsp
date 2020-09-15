package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;

public class CustomerJoin implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.아이디 중복검사
		CustomerDto dto = new CustomerDto();
		CustomerDao dao = new CustomerDao();
		dto.setCid(request.getParameter("cid"));
		int result = dao.iddouble(dto);	//1 , 0
		////
		if(result > 0)
		{
			out.println("<script>alert('아이디 중복');</script>");
			out.println("<script> history.go(-1); </script>");
			return;
		}		
		///
		//2. 회원가입
		dto.setCid(request.getParameter("cid"));
		dto.setCname(request.getParameter("cname"));
		dto.setCpass(request.getParameter("cpass"));
		dto.setCemail(request.getParameter("cemail"));		//.replace("\r\n", "<br>")
		dto.setCbirth(request.getParameter("cbirth"));
		dto.setCphone(request.getParameter("cphone"));
		dto.setCip(InetAddress.getLocalHost().getHostAddress());
		///
		dto.setCpostcode(request.getParameter("postcode"));
		dto.setCpost1(request.getParameter("address"));
		dto.setCpost2(request.getParameter("address2"));
		result = dao.join(dto);
		//3. 회원가입완료 join_com.members 경로넘기기
		if(result > 0)
		{
			out.println("<script>alert('회원가입 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/join_com.customer?cid="+request.getParameter("cid")+"'; </script>");
			
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}		
		//
	
		
		
		///
	}//end execute

}//end class
