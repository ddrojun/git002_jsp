package com.alex0517.controller_reply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BDeleteAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//해당번호의 데이터 삭제하기
		//1. 데이터 받아오기
		ReplyDto dto = new ReplyDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBpass(request.getParameter("bpass"));
	
		//2. 데이터 삭제
		ReplyDao dao = new ReplyDao();
		if(dao.delete(dto) > 0)
		{
			out.println("<script>alert('삭제 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.replydo'; </script>");
		}
		else
		{
			out.println("<script>alert('비밀번호 확인 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
		
	}//end execute

}//end class
