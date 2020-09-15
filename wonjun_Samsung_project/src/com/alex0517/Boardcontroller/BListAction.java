package com.alex0517.Boardcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao_1;

public class BListAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 리스트 뽑아오기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		BoardDao_1 dao = new BoardDao_1();
		request.setAttribute("list", dao.listAll());	//테이블 리스트
		//request.setAttribute("total", dao.listcnt());	//테이블 갯수 
		

	}//end execute

}//end class
