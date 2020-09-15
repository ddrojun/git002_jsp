package com.alex0517.keywordcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.cardbasketDao.CardbasketDao;
import com.alex0517.cardbasketDto.CardbasketDto;

public class Keyword_recommend_mypage implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CustomerDto dto = new CustomerDto();
		CardbasketDao dao = new CardbasketDao();
		CardbasketDto dto1 = new CardbasketDto();
		//dto.setMid(request.getParameter("mid"));
		HttpSession session = request.getSession(true);
		String c_id= (String)session.getAttribute("cid");
		dto.setCid(c_id);
		//
		//request.setAttribute("dto", dao.basketinfo(dto) );
		//request.setAttribute("dto", dao.basketinfo_1(dto));
		request.setAttribute("dto111", dao.basketinfo_1(dto));
		

		//회원가입완료 join_com.jsp 경로넘기기
		request.getRequestDispatcher("/card_info_board/mycard.jsp").forward(request, response);
		//request.getRequestDispatcher("/customer_member/mypage.jsp").forward(request, response);	//마이페이지 통합함
	}//end execute

}//end class
