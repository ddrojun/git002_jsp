package com.company.controller1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
import com.alex0517.BoardDto.BoardDto;

public class BEditViewAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//해당번호의 데이터 가져오기
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		BoardDto result = dao.detail(Integer.parseInt(request.getParameter("bno")));
		result.setBcontent(result.getBcontent());
		request.setAttribute("dto", result  );
//		dto.setBcontent(request.getParameter("bcontent").replace("\r\n", "<br>"));
		
		
	}//end execute

}//end class


