package com.company.controller_id_double;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.dbmanger.DBManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Gson_id_double_1
 */
@WebServlet("/Gson_id_double_1")
public class Gson_id_double_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gson_id_double_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		DBManager db = new DBManager();
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset =null;
		String sql="select count(*) cnt from customermember where cid =?";
		//String sql = "select * from userinfo";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("cid"));
			rset = pstmt.executeQuery();	//표
			int result =-1;
			String data ="사용가능";
			if(rset.next()) {
				result = rset.getInt("cnt");
			}//end if
			if(result ==1) {
				data ="사용불가";
			}//end if
			//배열만들기
			Gson gson = new Gson();
			JsonObject menu = new JsonObject();
			menu.addProperty("data", data);
			String json = gson.toJson(menu);
			//System.out.println(json);
			out.println(json);
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {try {conn.close();	}catch(SQLException e) {e.printStackTrace(); } }
			if(pstmt !=null) {try {pstmt.close();	}catch(SQLException e) {e.printStackTrace(); } }
			if(rset !=null) {try {rset.close();	}catch(SQLException e) {e.printStackTrace(); } }
		}			
		
		
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
