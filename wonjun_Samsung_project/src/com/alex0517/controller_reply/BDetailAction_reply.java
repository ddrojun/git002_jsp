package com.alex0517.controller_reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BDetailAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//해당번호의 데이터 가져오기
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao();
		//dao.addhit(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("dto", dao.read(Integer.parseInt(request.getParameter("bno")) ) );
		dao.update_hit(Integer.parseInt(request.getParameter("bno")));
		//request.setAttribute("dto", dao.read(dto) );
		
	}//end execute

}//end class
