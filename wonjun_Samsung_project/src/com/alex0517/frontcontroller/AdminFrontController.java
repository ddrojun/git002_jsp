package com.alex0517.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.admin_controller.AdminAction;
import com.alex0517.admin_controller.AdminListAction;
import com.alex0517.admin_controller.AdminList_id_Action;
import com.alex0517.admin_controller.DetailAction;

/**
 * Servlet implementation class AdminFrontController
 */
//@WebServlet("/AdminFrontController")
@WebServlet("*.admin")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}//end post
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String path =request.getRequestURI().substring(request.getContextPath().length());
		//String view ="";
		AdminAction command =null;
		if(path.equals("/list.admin"))
		{ 
			request.getRequestDispatcher("/admin/admin_search.jsp").forward(request, response);
		}
		else if(path.equals("/search.admin"))
		{
			command = new AdminListAction();
			command.execute(request, response);
		}
		else if(path.equals("/search_id.admin"))
		{
			command = new AdminList_id_Action();
			command.execute(request, response);
		}		
		else if(path.equals("/detail.admin"))
		{
			command = new DetailAction();
			command.execute(request, response);
			request.getRequestDispatcher("/admin/admin_detail.jsp").forward(request, response);
		}
		
		
	}//end actionTest
	
	
}//end class
