package com.company.controller1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
import com.alex0517.BoardDto.BoardDto;

public class BDeleteViewAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//해당번호 던져주기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		request.setAttribute("dto", dao.detail(Integer.parseInt(request.getParameter("bno")) ) );
		
		
		
	}//end execute

}//end class
