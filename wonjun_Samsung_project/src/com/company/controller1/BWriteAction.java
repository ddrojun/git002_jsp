package com.company.controller1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.BoardDao;
import com.alex0517.BoardDto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BWriteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset =utf-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 받아오기	
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		///
		String path = "/upload/";
		path = request.getServletContext().getRealPath(path);	//호스팅용		//호스팅할때 꼭!!!!!! 주석풀기
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy() );	//1024*1024*1 ==> 1메가
		String bfile="";
		bfile = multi.getFilesystemName("bfile");
		if(bfile != null)
		{
			dto.setBfile(bfile);
			System.out.println("업로드됨.");
		}
		else
		{	
			System.out.println("파일 업로드 안됨");
			dto.setBfile("no.jpg");
		}
		///////////////////////////////////////////////////////////
		dto.setBname(multi.getParameter("bname"));
		dto.setBpass(multi.getParameter("bpass"));
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setBcontent(multi.getParameter("bcontent") );
		//dto.setBfile(bfile);
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		//2. 데이터 삽입
		int res = dao.write(dto);
		if( res > 0)
		{
			out.println("<script>alert('글쓰기성공');</scrpit>");
			out.println("<script>"+"location.href='"+request.getContextPath()+"/list.do'; </script>");
			request.setAttribute("insert_result", res);
			request.setAttribute("dto", dto);
		}
		else
		{
			out.println("<script>alert('관리자 문의바람 ');</scrpit>");
			out.println("<script> history.go(-1); </scrpit>");
		}


	}//end execute

}//end class
