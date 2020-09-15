package com.alex0517.controller_reply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BEditAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao();
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent") );  //.replace("\r\n", "<br>") 
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBpass(request.getParameter("bpass"));
		request.setAttribute("dto", dao.update(dto));
		//2. 데이터 수정
		
		if(dao.update(dto) >0)
		{
			out.println("<script>alert('수정 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/detail.replydo?bno="+Integer.parseInt(request.getParameter("bno"))+"'; </script>");
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
	}//end execute

}//end class
