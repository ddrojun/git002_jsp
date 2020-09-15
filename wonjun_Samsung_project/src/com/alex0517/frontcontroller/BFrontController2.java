package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.controller1.BAction;
import com.company.controller1.BDeleteAction;
import com.company.controller1.BDeleteViewAction;
import com.company.controller1.BDetailAction;
import com.company.controller1.BEditAction;
import com.company.controller1.BEditViewAction;
import com.company.controller1.BListAction;
import com.company.controller1.BWriteAction;

/**
 * Servlet implementation class BFrontController2
 */
@WebServlet("*.do")
public class BFrontController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BFrontController2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end get

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end post
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String path =request.getRequestURI().substring(request.getContextPath().length());
		//String view ="";
		BAction command =null;
		if(path.equals("/list.do"))
		{ 
			//System.out.println("/cont> list.do start1");
			//리스트 뽑아오기
			command = new BListAction();
			command.execute(request, response);
			request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		}	
		else if(path.equals("/write_view.do"))
		{ request.getRequestDispatcher("/board/write.jsp").forward(request, response); }
		else if(path.equals("/write.do"))
		{ 
			//데이터를 받아와서 데이터 삽입
			command = new BWriteAction();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			out.println("<script>" + "location.href='list.do';</script>");
		}
		else if(path.equals("/detail.do"))
		{ 
			//해당번호의 데이터 가져오기
			command = new BDetailAction();
			command.execute(request, response);
			request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
		}
		else if(path.equals("/edit_view.do"))
		{ 
			//해당번호의 데이터 가져오기
			command = new BEditViewAction();
			command.execute(request, response);
			request.getRequestDispatcher("/board/edit.jsp").forward(request, response); 
		}
		else if(path.equals("/edit.do"))
		{
			//해당번호의 데이터 수정하기
			command = new BEditAction();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/detail.jsp").forward(request, response);		
		}
		else if(path.equals("/delete_view.do"))
		{ 
			//해당번호 던져주기
			command = new BDeleteViewAction();
			command.execute(request, response);
			request.getRequestDispatcher("/board/delete.jsp").forward(request, response); 
		}
		else if(path.equals("/delete.do"))
		{ 
			//해당번호의 데이터 삭제하기
			command = new BDeleteAction();
			command.execute(request, response);
			//request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//0. /list.do로 접속시				[index.jsp에서 접속]								board폴더에 list.jsp 로 이동
		//1. /write_view.do 로 접속시		[list.jsp(get) 글쓰기 버튼 클릭시]					board폴더에 write.jsp 로 이동
		//2. /write.do로 접속시			[write.jsp(post) 글쓰기 버튼 클릭시 ]					board폴더에 list.jsp 로 이동	
		//3. /detail.do로 접속시			[list.jsp(get) 상세보기링크 클릭시]					board폴더에 detail.jsp 로 이동
		//4. /edit_view.do로 접속시		[detail.jsp(get) 수정폼으로 넘어가는 버튼 클릭시]		board폴더에 edit.jsp 로 이동
		//5. /edit.do로 접속시				[edit.jsp(post) 수정하기 버튼 클릭시]					board폴더에 detail.jsp 로 이동
		//6. /delete_view.do 접속시		[detail.jsp(get) 삭제하기 버튼 클릭시]				board폴더에 delete.jsp 로 이동
		//7. /delete.do 접속시			[delete.jsp(post) 삭제하기 버튼 클릭시]				board폴더에 list.jsp 로 이동
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////
		
	}//end actionTest
	
}//end class







