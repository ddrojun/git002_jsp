package com.alex0517.keywordcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.cardbasketDao.CardbasketDao;
import com.alex0517.cardbasketDto.CardbasketDto;

public class Keyword_DeleteAction implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//해당번호의 데이터 삭제하기
		//1. 데이터 받아오기
		CardbasketDto dto = new CardbasketDto();
		String cardname ="%"+request.getParameter("cardname")+"%";
		System.out.println("확인 : " +request.getParameter("cardname"));
		//dto.setCardname(request.getParameter("cardname"));
		dto.setCardname(cardname);
		//dto.setBpass(request.getParameter("bpass"));
	
		//2. 데이터 삭제
		CardbasketDao dao = new CardbasketDao();
		if(dao.delete(dto) > 0)
		{
			out.println("<script>alert('삭제 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/mycard_view.keyword'; </script>");
		}
		else
		{
			out.println("<script>alert('카드이름 확인 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
		
	}//end execute

}//end class
