package com.alex0517.keywordcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.keywordDao.KeywordDao;

public class CardListAction implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 리스트 뽑아오기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		KeywordDao dao = new KeywordDao();
		request.setAttribute("list", dao.listAll());	//테이블 리스트
		//request.setAttribute("total", dao.listcnt() );	//테이블 갯수 
		
	}//end execute

}//end class
