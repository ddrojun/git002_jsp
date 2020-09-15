package com.alex0517.controller_reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BReplyViewAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//해당번호 던져주기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao();
		ReplyDto result = dao.read(Integer.parseInt(request.getParameter("bno")));
		System.out.println(result);
		result.setBtitle("ㄴre: " +result.getBtitle());
		result.setBcontent("\n\n\n> " +  result.getBcontent().replaceAll("\n", "\n>"));
		//request.setAttribute("dto", dto);
		request.setAttribute("dto",   result);

	}//end execute

}//end class
