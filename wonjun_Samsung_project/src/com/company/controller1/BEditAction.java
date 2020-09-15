package com.company.controller1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
import com.alex0517.BoardDto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BEditAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		///////////////////////////
		String path = "/upload/";
		path = request.getServletContext().getRealPath(path);	//호스팅용		//호스팅할때 꼭!!!!!! 주석풀기
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy() );	//1024*1024*1 ==> 1메가
		String bfile = multi.getFilesystemName("bfile");
		/////////////////////////////////
		if(bfile ==null)
		{
			//dto.setBfile("no.jpg");
			dto.setBfile(multi.getParameter("default_file"));
		}
		else
		{
			dto.setBfile(bfile);
		}
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setBcontent(multi.getParameter("bcontent") );
		//dto.setBfile(bfile);
		dto.setBno(Integer.parseInt(multi.getParameter("bno")));
		dto.setBpass(multi.getParameter("bpass"));
		//2. 데이터 수정

		if(dao.update(dto) >0)
		{
			out.println("<script>alert('수정 성공');</script>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/detail.do?bno="+Integer.parseInt(request.getParameter("bno"))+"'; </script>");
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</script>");
			out.println("<script> history.go(-1); </script>");
		}
		
		
	}//end execute

}//end class
