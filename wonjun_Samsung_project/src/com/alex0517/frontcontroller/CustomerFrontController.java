package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.Customercontroller.CustomerAction;
import com.alex0517.Customercontroller.CustomerDelete;
import com.alex0517.Customercontroller.CustomerFind_Id;
import com.alex0517.Customercontroller.CustomerFind_Pass;
import com.alex0517.Customercontroller.CustomerJoin;
import com.alex0517.Customercontroller.CustomerJoin_com;
import com.alex0517.Customercontroller.CustomerLogin;
import com.alex0517.Customercontroller.CustomerLogout;
import com.alex0517.Customercontroller.CustomerMypage;
import com.alex0517.Customercontroller.CustomerMypage_edit;
import com.alex0517.Customercontroller.CustomerMypage_pass_edit;
import com.alex0517.Customercontroller.CustomerMypage_pass_view;
import com.alex0517.Customercontroller.CustomerMypage_view;


/**
 * Servlet implementation class JFrontController
 */
//@WebServlet("/JFrontController")
//@WebServlet("*.members")
@WebServlet("*.customer")
public class CustomerFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String path =request.getRequestURI().substring(request.getContextPath().length());
		//String view ="";
		CustomerAction command =null;
//		if(path.equals("/join_agree.admin"))	//회원가입 동의
//		{
//			System.out.println("회원가입 동의");
//			request.getRequestDispatcher("/admin_member/join_agree.jsp").forward(request, response);
//		}
		if(path.equals("/start.customer"))
		{
			request.getRequestDispatcher("/layout/mainpage.jsp").forward(request, response);
			//request.getRequestDispatcher("/dashboard/dashboard_2.jsp").forward(request, response);
		}
		else if(path.equals("/join_agree.customer")) //회원가입폼
		{
			System.out.println("회원가입 폼");
			request.getRequestDispatcher("/customer_member/join.jsp").forward(request, response);
		}
		else if(path.equals("/join.customer")) //회원가입기능
		{
			System.out.println("회원가입 기능");
			//데이터를 받아와서 데이터 삽입
			command = new CustomerJoin();
			command.execute(request, response);
			//request.getRequestDispatcher("/member/join_success_view.jsp").forward(request, response);
			//out.println("<script>"+"location.href='join_com.members'; </script>");
		}	
		///
		else if(path.equals("/join_com.customer")) //회원가입완료
		{
			System.out.println("회원가입 완료");
			command = new CustomerJoin_com();
			command.execute(request, response);
			//request.getRequestDispatcher("/member/join_success_view.jsp").forward(request, response);	
		}
		//////////////////////
		if(path.equals("/login_view.customer")) //로그인폼
		{
			System.out.println("1. 로그인 폼");
			request.getRequestDispatcher("/customer_member/login.jsp").forward(request, response);
		}
		else if(path.equals("/login.customer")) //로그인 가능
		{
			System.out.println("로그인 가능");
			command = new CustomerLogin();
			command.execute(request, response);
		}
		else if(path.equals("/logout.customer"))
		{
			System.out.println("로그아웃 기능");
			command = new CustomerLogout();
			command.execute(request, response);
		}
		///////////////////////////////
		else if(path.equals("/mainpage_view.customer"))
		{
			request.getRequestDispatcher("/layout/mainpage.jsp").forward(request, response);
			//request.getRequestDispatcher("/layout/mainpage_login_success.jsp").forward(request, response);
		}
		//////////////////////////////
		if(path.equals("/mypage_view.customer"))	//나의 페이지
		{
			System.out.println("1. 나의페이지 폼");
			command = new CustomerMypage();
			command.execute(request, response);
			//request.getRequestDispatcher("/member/agree.jsp").forward(request, response);
		}
		else if(path.equals("/mypage_edit_view.customer")) //수정폼
		{
			System.out.println("2. 나의 페이지 수정폼");
			command = new CustomerMypage_view();
			command.execute(request, response);
			//request.getRequestDispatcher("/member/mypage_edit.jsp").forward(request, response);
		}
		else if(path.equals("/mypage_edit.customer")) //수정기능
		{
			System.out.println("3. 나의페이지 수정기능");
			command = new CustomerMypage_edit();
			command.execute(request, response); 
		}		
		else if(path.equals("/mypage_pass_view.customer")) //비번수정폼
		{
			System.out.println("4. 비번수정폼");
			command = new CustomerMypage_pass_view();
			command.execute(request, response);
		}
		else if(path.equals("/mypage_pass.customer")) //비번수정기능
		{
			System.out.println("5. 비번수정기능");
			command = new CustomerMypage_pass_edit();
			command.execute(request, response);
		}
		else if(path.equals("/mypage_delete.customer")) //탈퇴
		{
			System.out.println("6. 탈퇴기능");
			command = new CustomerDelete();
			command.execute(request, response);
		}
		///
		else if(path.equals("/find.customer")) //아이디, 비밀번호 찾기 탭
		{
			request.getRequestDispatcher("/customer_member/find.jsp").forward(request, response);
		}
		else if(path.equals("/find_pass.customer"))	//비밀번호 찾기 폼
		{
			request.getRequestDispatcher("/customer_member/find_pass.jsp").forward(request, response);
		}
		else if(path.equals("/find_id_action.customer"))	//아이디 찾기 기능
		{
			command = new CustomerFind_Id();
			command.execute(request, response);
		}
		else if(path.equals("/find_pass_action.customer"))	//비밀번호 찾기 기능
		{
			command = new CustomerFind_Pass();
			command.execute(request, response);
		}
		
		
		
		
	}//end actionTest

}//end class
