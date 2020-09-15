package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.keywordcontroller.CardListAction;
import com.alex0517.keywordcontroller.KeywordAction;
import com.alex0517.keywordcontroller.Keyword_DeleteAction;
import com.alex0517.keywordcontroller.Keyword_DeleteViewAction;
import com.alex0517.keywordcontroller.Keyword_recommend;
import com.alex0517.keywordcontroller.Keyword_recommend_Add;
import com.alex0517.keywordcontroller.Keyword_recommend_age;
import com.alex0517.keywordcontroller.Keyword_recommend_detail;
import com.alex0517.keywordcontroller.Keyword_recommend_gender;
import com.alex0517.keywordcontroller.Keyword_recommend_mypage;
import com.alex0517.keywordcontroller.Keyword_recommend_type1;
import com.alex0517.keywordcontroller.Keyword_recommend_type2;

/**
 * Servlet implementation class CardSearchFrontController_keyword
 */
//@WebServlet("/CardSearchFrontController_keyword")
@WebServlet("*.keyword")
public class CardSearchFrontController_keyword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardSearchFrontController_keyword() {
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
		String path =request.getRequestURI().substring(request.getContextPath().length());
		//String view ="";
		KeywordAction command =null;
		if(path.equals("/listall.keyword"))	//카드 전체목록 테이블로 먼저 보기
		{
			command = new CardListAction();
			command.execute(request, response);
			request.getRequestDispatcher("/card_search_keyword/all_card.jsp").forward(request, response);
		}
		else if(path.equals("/list.keyword"))
		{ 
			//리스트 뽑아오기
			request.getRequestDispatcher("/card_search_keyword/search_form.jsp").forward(request, response);
		}	

		else if(path.equals("/search.keyword"))	//키워드로 카드찾기
		{
			command = new Keyword_recommend();
			command.execute(request, response);
		}
		else if(path.equals("/search_gender.keyword"))
		{
			command = new Keyword_recommend_gender();
			command.execute(request, response);
		}
		else if(path.equals("/search_age.keyword"))
		{
			command = new Keyword_recommend_age();
			command.execute(request, response);
		}
		else if(path.equals("/search_type1.keyword"))
		{
			command = new Keyword_recommend_type1();
			command.execute(request, response);
		}
		else if(path.equals("/search_type2.keyword"))
		{
			command = new Keyword_recommend_type2();
			command.execute(request, response);
		}
		else if(path.equals("/search_detail.keyword"))
		{
			command = new Keyword_recommend_detail();
			command.execute(request, response);
			request.getRequestDispatcher("/card_search_keyword/detail.jsp").forward(request, response);
		}
		else if(path.equals("/addcard.keyword"))	//카드담기?
		{
			command = new Keyword_recommend_Add();
			command.execute(request, response);
			
			//request.getRequestDispatcher("/card_info_board/mycard.jsp").forward(request, response);
		}
		//
		else if(path.equals("/mycard_view.keyword"))	//Mycard페이지
		{
			command = new Keyword_recommend_mypage();
			command.execute(request, response);
			//request.getRequestDispatcher("/member/agree.jsp").forward(request, response);
		}
		else if(path.equals("/delete_view.keyword"))
		{
			command = new Keyword_DeleteViewAction();
			command.execute(request, response);
			request.getRequestDispatcher("/card_search_keyword/delete.jsp").forward(request, response); 
		}
		else if(path.equals("/delete.do"))
		{ 
			//해당번호의 데이터 삭제하기
			command = new Keyword_DeleteAction();
			command.execute(request, response);
		}

		
	}//end actionTest
	
	

}//end class



