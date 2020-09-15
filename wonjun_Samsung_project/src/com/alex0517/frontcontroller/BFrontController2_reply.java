package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.controller_reply.BAction_reply;
import com.alex0517.controller_reply.BDeleteAction_reply;
import com.alex0517.controller_reply.BDeleteViewAction_reply;
import com.alex0517.controller_reply.BDetailAction_reply;
import com.alex0517.controller_reply.BEditAction_reply;
import com.alex0517.controller_reply.BEditViewAction_reply;
import com.alex0517.controller_reply.BListAction_reply;
import com.alex0517.controller_reply.BReplyAction_reply;
import com.alex0517.controller_reply.BReplyViewAction_reply;
import com.alex0517.controller_reply.BWriteAction_reply;

/**
 * Servlet implementation class BFrontController2_reply
 */
//@WebServlet("/BFrontController2_reply")
@WebServlet("*.replydo")
public class BFrontController2_reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController2_reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end post
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String path =request.getRequestURI().substring(request.getContextPath().length()); //uri
		//String view ="";
		BAction_reply command =null;
		if(path.equals("/list.replydo"))
		{ 
			//System.out.println("/cont> list.do start1");
			//리스트 뽑아오기
			command = new BListAction_reply();
			command.execute(request, response);
			request.getRequestDispatcher("/board_reply/list.jsp").forward(request, response);
		}	
		else if(path.equals("/write_view.replydo"))
		{ request.getRequestDispatcher("/board_reply/write.jsp").forward(request, response); }
		else if(path.equals("/write.replydo"))
		{ 
			//데이터를 받아와서 데이터 삽입
			command = new BWriteAction_reply();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			out.println("<script>" + "location.href='list.replydo';</script>");
		}
		else if(path.equals("/detail.replydo"))
		{ 
			//해당번호의 데이터 가져오기
			command = new BDetailAction_reply();
			command.execute(request, response);
			request.getRequestDispatcher("/board_reply/detail.jsp").forward(request, response);
		}
		else if(path.equals("/edit_view.replydo"))
		{ 
			//해당번호의 데이터 가져오기
			command = new BEditViewAction_reply();
			command.execute(request, response);
			request.getRequestDispatcher("/board_reply/edit.jsp").forward(request, response); 
		}
		else if(path.equals("/edit.replydo"))
		{
			//해당번호의 데이터 수정하기
			command = new BEditAction_reply();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/detail.jsp").forward(request, response);		
		}
		else if(path.equals("/delete_view.replydo"))
		{ 
			//해당번호 던져주기
			command = new BDeleteViewAction_reply();
			command.execute(request, response);
			request.getRequestDispatcher("/board_reply/delete.jsp").forward(request, response); 
		}
		else if(path.equals("/delete.replydo"))
		{ 
			//해당번호의 데이터 삭제하기
			command = new BDeleteAction_reply();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		}
		else if(path.equals("/reply_view.replydo"))	//답변 수정폼 이동
		{			
			command = new BReplyViewAction_reply();
			command.execute(request, response);
			request.getRequestDispatcher("/board_reply/reply_view.jsp").forward(request, response);
		}
		else if(path.equals("/reply.replydo"))	//답변 기능
		{
			command =new BReplyAction_reply();
			command.execute(request, response);
			//request.getRequestDispatcher("/list.do").forward(request, response);
		}
		
		
	}//end actionTest

}//end class
