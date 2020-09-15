package com.alex0517.keywordcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.keywordDao.KeywordDao;

public class Keyword_recommend_detail implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//해당번호의 데이터 가져오기
		KeywordDao dao = new KeywordDao();
		

		request.setAttribute("dto", dao.detail_name(Integer.parseInt(request.getParameter("no")) ) );
		request.setAttribute("dto1", dao.detail_benefit(Integer.parseInt(request.getParameter("no"))));

	}//end execute

}//end class
