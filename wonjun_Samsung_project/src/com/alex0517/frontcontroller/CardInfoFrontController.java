package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.CardlistController.BAction_cardlist;
import com.alex0517.CardlistController.CardInfoListAction;
import com.alex0517.CardlistController.CardInfoWriteAction;

/**
 * Servlet implementation class CardInfoFrontController
 */
//@WebServlet("/CardInfoFrontController")
@WebServlet("*.cardinfo")
public class CardInfoFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardInfoFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}//end post
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String path =request.getRequestURI().substring(request.getContextPath().length()); //uri
		//String view ="";
		BAction_cardlist command =null;
		if(path.equals("/board.cardinfo"))
		{
			request.getRequestDispatcher("/card_info_board/first_view.jsp").forward(request, response);
		}
		else if(path.equals("/list.cardinfo"))
		{ 
			//리스트 뽑아오기
			command = new CardInfoListAction();
			command.execute(request, response);
		}
		else if(path.equals("/menual.cardinfo"))
		{
			request.getRequestDispatcher("/card_info_board/menual.jsp").forward(request, response);
		}
		else if(path.equals("/write_view.cardinfo"))
		{
			request.getRequestDispatcher("card_info_board/write.jsp").forward(request, response);
		}
		else if(path.equals("/write.cardinfo"))
		{
			command = new CardInfoWriteAction();
			command.execute(request, response);
		}
		
		
	}//end actionTest

}//end class
