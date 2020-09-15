package com.company.controller1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
public class BDetailAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//해당번호의 데이터 가져오기
		BoardDao dao = new BoardDao();
		dao.addhit(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("dto", dao.detail(Integer.parseInt(request.getParameter("bno")) ) );
		
		
	}//end execute

}//end class
