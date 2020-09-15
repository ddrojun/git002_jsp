package com.alex0517.CardlistController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao_1;
import com.alex0517.keywordDto.KeywordDto;

public class CardInfoWriteAction implements BAction_cardlist {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset =utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기	
		KeywordDto dto = new KeywordDto();
		BoardDao_1 dao = new BoardDao_1();
		dto.setName(request.getParameter("name"));
		dto.setIdnum(request.getParameter("idnum"));
		dto.setGender(request.getParameter("gender"));
		dto.setAge(request.getParameter("age"));
		dto.setType1(request.getParameter("type1"));
		dto.setType2(request.getParameter("type2"));
		dto.setBenefit(Integer.parseInt(request.getParameter("benefit")));
		dto.setIp(InetAddress.getLocalHost().getHostAddress());
		dto.setWriter(request.getParameter("writer"));
		dto.setPic(request.getParameter("pic"));
		//2. 데이터 삽입
		int res = dao.write(dto);
		if( res > 0)
		{
			out.println("<script>alert('카드추가 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.do'; </script>");
			request.setAttribute("insert_result", res);
			request.setAttribute("dto", dto);
		}
		else
		{
			out.println("<script>alert('실패 ');</script>");
			out.println("<script> history.go(-1); </scrpit>");
		}

	}

}//end class
