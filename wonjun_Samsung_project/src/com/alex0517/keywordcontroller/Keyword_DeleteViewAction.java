package com.alex0517.keywordcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.cardbasketDao.CardbasketDao;
import com.alex0517.cardbasketDto.CardbasketDto;

public class Keyword_DeleteViewAction implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//해당번호 던져주기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		CardbasketDto dto = new CardbasketDto();
		CardbasketDao dao = new CardbasketDao();
		String cardname ="%"+request.getParameter("cardname")+"%";
		request.setAttribute("dto1", dao.detail(cardname));
		
		
		
	}//end execute

}//end class
