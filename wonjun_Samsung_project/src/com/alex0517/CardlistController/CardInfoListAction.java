package com.alex0517.CardlistController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alex0517.BoardDao.BoardDao_1;

public class CardInfoListAction implements BAction_cardlist {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 리스트 뽑아오기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//InvestmentDao_1 dao = new InvestmentDao_1();
		//request.setAttribute("item", dao.read());	//테이블 리스트
		
		BoardDao_1 dao = new BoardDao_1();		
		request.setAttribute("item", dao.listAll());
		HttpSession session = request.getSession();
		String a_id= (String)session.getAttribute("aid");
		String c_id= (String)session.getAttribute("cid");
		
		//request.setAttribute("dto1", dao.admin_login(dto1));
		if(a_id!=null){
			//request.getAttribute("dto1");
			//session.setAttribute("aid", request.getParameter("cid"));
			//session.getAttribute("aid");
			request.getRequestDispatcher("/card_info_board/second_view_table.jsp").forward(request, response);	//관리자용
			
		}
		else {
			request.getRequestDispatcher("/card_info_board/second_view_table_1.jsp").forward(request, response);	//고객용
		}
		//request.getRequestDispatcher("/card_info_board/second_view_table.jsp").forward(request, response);	
		

	}//end execute

}//end class
