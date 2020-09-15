package com.alex0517.keywordcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.cardbasketDao.CardbasketDao;
import com.alex0517.keywordDto.KeywordDto;

public class Keyword_recommend_Add implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CustomerDto dto1 = new CustomerDto();
		KeywordDto dto = new KeywordDto();
		CardbasketDao dao = new CardbasketDao();
		
		System.out.println("파라미터 확인 : " +request.getParameter("cardname1"));
		HttpSession session = request.getSession(true);
		//String a_id= (String)session.getAttribute("aid");
		String c_id= (String)session.getAttribute("cid");
		dto1.setCid(c_id);
		dto1.setCid(c_id);
		dto.setName(request.getParameter("cardname1"));
		dto.setName(request.getParameter("cardname1"));
		//dto.setCcard(request.getParameter("cardname"));
		//dto.setCcard(request.getParameter("cardname"));
		
		//dto.setCno(dto1.getNo());
		if(dao.addcard(dto, dto1) >0)
		{
			out.println("<script>alert('카드 담기 성공');</script>");
			//request.setAttribute("addcard", dao.addcard(dto, dto1));		
			//out.println("<script>"+"location.href='"+request.getContextPath()+"/detail.do?bno="+Integer.parseInt(request.getParameter("bno"))+"'; </script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/start.customer'; </script>");
			//request.getRequestDispatcher("/start.customer").forward(request, response);

		}
		else
		{
			out.println("<script>alert('카드담기 실패');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
	}//end execute

}//end class
