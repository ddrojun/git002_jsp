package com.alex0517.controller_reply;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.BoardDao.ReplyDao;
import com.alex0517.BoardDto.ReplyDto;
import com.company.pagedto.PagingDto;
import com.company.pagedto.PagingDto_reply;

public class BListAction_reply implements BAction_reply {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 리스트 뽑아오기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ReplyDao dao = new ReplyDao();
		//request.setAttribute("list", dao.listAll());	//테이블 리스트       //원래쓰던거
		//request.setAttribute("total", dao.listcnt());	//테이블 갯수 
		///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
		ArrayList<ReplyDto> list = null;
		PagingDto dto = new PagingDto();
		//1. 전체 게시판의 갯수(글의 갯수) : 12
		int pageTotal = dao.listcnt();  										System.out.println("전체 갯수 : " + pageTotal);
		//2. 한페이지당 보여줄 레코드수(글) :  10
		int onepageLimit = 10;													System.out.println("한페이지당 갯수 : "+onepageLimit);
		//3. 하단 index의 갯수 12/10 : 2
		int pageAll = (int)Math.ceil( pageTotal / (float)onepageLimit );		System.out.println("하단 index 갯수 : "+pageAll);
		//4. db에서 가져올 번호(1버튼 0, 2버튼 10)
		int pstartno =0;	 													System.out.println("db에서 가져올번호 : "+pstartno);
		if(request.getParameter("pstartno") !=null)
		{ pstartno = Integer.parseInt(request.getParameter("pstartno")); }
		list = dao.list10(pstartno);
		//5. 하단페이지네비(10)  <이전 1 2 3 4 5 6 7 8 9 10 다음 >
		int bottomList =10;														System.out.println("하단페이지 네비 : "+bottomList);
		//6. 하단페이지네비 - 현재페이지 네비번호 <이전 1(시작페이지번호) 2 3 4 5(현재페이지번호) 6 7 8 9 10(끝나는페이지번호) 다음 >
		int bottom_current =(int)Math.ceil( (pstartno +1) / (float)onepageLimit );		System.out.println("현재페이지 : "+bottom_current);
		int bottom_start = ((int)Math.floor((bottom_current-1) / (float)bottomList))*bottomList +1;	System.out.println("시작페이지 : "+bottom_start);
		///////////////////
		int bottom_end = bottom_start + bottomList -1;	
		if(pageAll < bottom_end)
		{
			bottom_end = pageAll;		System.out.println("끝페이지 : "+bottom_end);
		}							
		/////////////////////////////////
		//글 목록 
		request.setAttribute("item_size", list.size());
		request.setAttribute("item", list);
		//페이징
		request.setAttribute("items", 
				new PagingDto_reply(pageTotal, onepageLimit, pageAll, pstartno, bottomList, bottom_current, bottom_start, bottom_end, list) );
		//request.getRequestDispatcher("/day0723/jstl_result.jsp").forward(request, response);
		//request.getRequestDispatcher("/board/list.jsp").forward(request, response);	
	}//end execute

}//end class
