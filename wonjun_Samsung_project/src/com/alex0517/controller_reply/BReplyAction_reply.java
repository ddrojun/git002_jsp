package com.alex0517.controller_reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;

public class BReplyAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기	
		ReplyDto dto = new ReplyDto();
		ReplyDao dao = new ReplyDao(); //dto.setBno(Integer.parseInt(request.getParameter("bno")));
		ReplyDto now = dao.read(Integer.parseInt(request.getParameter("bno")));
		////////////////////////////////////////////////////////////////////////
		//기존에 답변글이 달려있다면 : bstep =bstep -1 성공여부: 
		int prev = ((int)Math.ceil(now.getBstep()/(float)1000 )-1)*1000;		
		int curr = now.getBstep();
		int result_1 = dao.update_reply(prev, curr);	
		
		//ReplyDto redto = new ReplyDto();
		//int max = dao.max_read();
		//답변달기 성공
		ReplyDto redto = new ReplyDto();
		redto.setBname(request.getParameter("bname"));
		redto.setBpass(request.getParameter("bpass"));
		redto.setBtitle(request.getParameter("btitle"));
		redto.setBcontent(request.getParameter("bcontent"));  //.replace("\r\n", "<br>")
		redto.setBip(InetAddress.getLocalHost().getHostAddress());
		///////////////////////
		//   3 :ReplyDto [bno=0, bname=null, btitle=null, bpass=null, bcontent=null, bdate=null, bhit=0, bip=null, bgroup=1, bstep=999, bindent=1]
		redto.setBgroup(now.getBgroup());
		redto.setBstep(now.getBstep()-1);
		redto.setBindent(now.getBindent()+1);
		int res =dao.create_re(redto);
		//System.out.println("1: "+result_1);
		//System.out.println("2: "+res);
		//System.out.println("3 :" +redto);
		
		//2. 데이터 삽입

		if(res > 0)
		{
			out.println("<script>alert('답변달기완료');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.replydo'; </script>");
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
	}//end execute

}//end class
