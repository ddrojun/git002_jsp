package com.alex0517.controller_reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BWriteAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset =utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 데이터 받아오기	
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao();
		int max = dao.max_read();
		dto.setBname(request.getParameter("bname"));
		dto.setBpass(request.getParameter("bpass"));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		dto.setBgroup( ((int)(Math.ceil(max/(float)1000 )))+1 );
		dto.setBstep((((int)(Math.ceil(max/(float)1000 )))+1)*1000 );
		//dto.setBgroup(request.getParameter("bgroup"));
		//request.setAttribute("result_write", dao.create(dto));
		//2. 데이터 삽입
		
		if(dao.create(dto) > 0)
		{
			out.println("<script>alert('글쓰기성공');</scrpit>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.replydo'; </script>");
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</scrpit>");
			out.println("<script> history.go(-1); </scrpit>");
		}

	}//end execute

}//end class
