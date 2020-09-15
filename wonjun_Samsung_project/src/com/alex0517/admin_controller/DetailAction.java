package com.alex0517.admin_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.adminDao.AdminDao;

public class DetailAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//해당번호의 데이터 가져오기
		AdminDao dao = new AdminDao();
		request.setAttribute("dto", dao.detail(Integer.parseInt(request.getParameter("cno")) ) );
//		request.setAttribute("dto", dao.detail(request.getParameter("cid")) );
		///

		
		
	}//end execute

}//end class
