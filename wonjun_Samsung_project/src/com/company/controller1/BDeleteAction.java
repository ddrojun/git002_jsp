package com.company.controller1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
import com.alex0517.BoardDto.BoardDto;

public class BDeleteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//해당번호의 데이터 삭제하기
		//1. 데이터 받아오기
		BoardDto dto = new BoardDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBpass(request.getParameter("bpass"));
	
		//2. 데이터 삭제
		BoardDao dao = new BoardDao();
		if(dao.delete(dto) > 0)
		{
			out.println("<script>alert('삭제 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.do'; </script>");
		}
		else
		{
			out.println("<script>alert('비밀번호 확인 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
		
	}//end execute

}//end class
