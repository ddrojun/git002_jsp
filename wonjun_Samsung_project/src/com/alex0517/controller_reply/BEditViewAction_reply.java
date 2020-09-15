package com.alex0517.controller_reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BEditViewAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//해당번호의 데이터 가져오기
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao();
		ReplyDto result = dao.read(Integer.parseInt(request.getParameter("bno")));
		result.setBcontent(result.getBcontent());
		request.setAttribute("dto", result  );
//		dto.setBcontent(request.getParameter("bcontent").replace("\r\n", "<br>"));
		
		
	}//end execute

}//end class
