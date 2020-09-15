package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.condition_controller.BAction;
import com.alex0517.condition_controller.Condition_recommend_age;
import com.alex0517.condition_controller.Condition_recommend_air;
import com.alex0517.condition_controller.Condition_recommend_coffee;
import com.alex0517.condition_controller.Condition_recommend_company;
import com.alex0517.condition_controller.Condition_recommend_fastfood;
import com.alex0517.condition_controller.Condition_recommend_gender;
import com.alex0517.condition_controller.Condition_recommend_mart;
import com.alex0517.condition_controller.Condition_recommend_movie;
import com.alex0517.condition_controller.Condition_recommend_oil;
import com.alex0517.condition_controller.Condition_recommend_phone;
import com.alex0517.condition_controller.Condition_recommend_shopping;
import com.alex0517.condition_controller.Condition_recommend_transportation;
import com.alex0517.condition_controller.Condition_recommend_type1;
import com.alex0517.condition_controller.Condition_recommend_type2;


/**
 * Servlet implementation class CardSearchFrontController_condition
 */
//@WebServlet("/CardSearchFrontController_condition")
@WebServlet("*.condition")

public class CardSearchFrontController_condition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardSearchFrontController_condition() {
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
		String path =request.getRequestURI().substring(request.getContextPath().length());
		//String view ="";
		BAction command =null;
		if(path.equals("/list.condition"))
		{ 
			//리스트 뽑아오기
			//command = new BListAction();
			//command.execute(request, response);
			request.getRequestDispatcher("/card_search_condition/search_form.jsp").forward(request, response);
		}	
		else if(path.equals("/search_gender.condition"))
		{
			command = new Condition_recommend_gender();
			command.execute(request, response);
		}
		//else if(path.equals("/search_result.condition"))
		//{
		//	request.getRequestDispatcher("/card_search_condition/result.jsp").forward(request, response);
		//}
		else if(path.equals("/search_age.condition"))
		{
			command = new Condition_recommend_age();
			command.execute(request, response);
		}
		else if(path.equals("/search_company.condition"))
		{
			command = new Condition_recommend_company();
			command.execute(request, response);
		}
		else if(path.equals("/search_type1.condition"))
		{
			command = new Condition_recommend_type1();
			command.execute(request, response);
		}
		else if(path.equals("/search_type2.condition"))
		{
			command = new Condition_recommend_type2();
			command.execute(request, response);
		}
		////////////////////////////////////////////////////////여기서부터 혜택선택
		else if(path.equals("/search_oil.condition"))
		{
			command = new Condition_recommend_oil();
			command.execute(request, response);
		}
		else if(path.equals("/search_movie.condition"))
		{
			command = new Condition_recommend_movie();
			command.execute(request, response);
		}
		else if(path.equals("/search_coffee.condition"))
		{
			command = new Condition_recommend_coffee();
			command.execute(request, response);
		}
		else if(path.equals("/search_transportation.condition"))
		{
			command = new Condition_recommend_transportation();
			command.execute(request, response);
		}
		else if(path.equals("/search_air.condition"))
		{
			command = new Condition_recommend_air();
			command.execute(request, response);
		}
		else if(path.equals("/search_shopping.condition"))
		{
			command = new Condition_recommend_shopping();
			command.execute(request, response);
		}
		else if(path.equals("/search_fastfood.condition"))
		{
			command = new Condition_recommend_fastfood();
			command.execute(request, response);
		}
		else if(path.equals("/search_phone.condition"))
		{
			command = new Condition_recommend_phone();
			command.execute(request, response);
		}
		else if(path.equals("/search_mart.condition"))
		{
			command = new Condition_recommend_mart();
			command.execute(request, response);
		}
		
		//else if(path.equals("/search_benefit.condition"))		//혜택 버튼
		//{
		//	command = new Condition_recommend_benefit();
		//	command.execute(request, response);
		//}
		//else if(path.equals("/search_result.condition"))
		//{
		//	command = new Condition_recommend_result();
		//	command.execute(request, response);
		//	request.getRequestDispatcher("/card_search_condition/result.jsp").forward(request, response);
		//}
		
		
		
		
		
	}//end actionTest
}//end class
