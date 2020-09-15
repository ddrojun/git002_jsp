package com.alex0517.Customercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.CustomerDao.CustomerDao;
import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.adminDto.AdminDto;

public class CustomerLogin implements CustomerAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터를 받아와서 데이터 삽입
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//데이터를 넘겨받아 로그인  //아이디, 패스워드
		CustomerDao dao = new CustomerDao();
		CustomerDto dto = new CustomerDto();
		///////////////
		AdminDto dto1 = new AdminDto();
		dto1.setAid(request.getParameter("cid"));		//관리자 아이디
		dto1.setApass(request.getParameter("cpass"));	//
		request.setAttribute("dto1", dao.admin_login(dto1));
		/////////////
		dto.setCid(request.getParameter("cid"));
		dto.setCpass(request.getParameter("cpass"));
		request.setAttribute("dto", dao.login(dto));

		////
		String remember = request.getParameter("remember");	//checkbox
		if(dao.admin_login(dto1)>0)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("aid", request.getParameter("cid"));
			request.setAttribute("dto1", dao.admin_login(dto1));
			//
			session.setAttribute("welcome1", "Alex카드 관리자님 환영합니다.");	//로그인시 인사하기
			out.println("<script>alert('관리자 로그인 성공');</script>");
			//메인페이지로 이동하자
			out.println("<script>"+"location.href='"+request.getContextPath()+"/mainpage_view.customer'; </script>");
		}
		/////
		if(dao.login(dto) > 0)
		{
			//Session 선언하기
			HttpSession session = request.getSession(true);
			session.setAttribute("cid", request.getParameter("cid"));
			session.setAttribute("cpass", request.getParameter("cpass"));
			///
			//session.setAttribute("welcome", "welcome");	//로그인시 인사하기
			session.setAttribute("welcome", "Alex카드 환영합니다.");	//로그인시 인사하기
			if(remember != null)  // 체크박스 체크
			{
				Cookie cookie1 = new Cookie("remember", "remember");
				Cookie cookie2 = new Cookie("cid", request.getParameter("cid"));
				//
				Cookie cookie3 = new Cookie("welcome", "welcome");	//로그인시 인사하기
				
				cookie1.setMaxAge(1*60*2);
				cookie2.setMaxAge(1*60*2);
				cookie3.setMaxAge(1*60*2);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.addCookie(cookie3);
			}	
			else	//체크박스 안한경우
			{
				String cookie = request.getHeader("Cookie");
				if(cookie != null)
				{
					Cookie[] cookies = request.getCookies();
					for(int i=0; i<cookies.length; i++)
					{
						if(cookies[i].getName().equals("remember") || cookies[i].getName().equals("cid"))
						{
							cookies[i].setMaxAge(0); response.addCookie(cookies[i]);
						}
					}
				}
			}		
			out.println("<script>alert('로그인 성공');</script>");
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/mypage_view.members?mid="+request.getParameter("mid")+"'; </script>");
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/mypage_view.customer'; </script>");
			//메인페이지로 이동하자
			out.println("<script>"+"location.href='"+request.getContextPath()+"/mainpage_view.customer'; </script>");
			
		}
		else
		{
			out.println("<script>alert('아이디와 비밀번호 확인바람');</script>");
			out.println("<script> history.go(-1); </script>");
		}

	}

}
