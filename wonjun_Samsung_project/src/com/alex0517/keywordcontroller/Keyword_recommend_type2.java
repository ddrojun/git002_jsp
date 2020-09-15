package com.alex0517.keywordcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.dbmanger.DBManager;

public class Keyword_recommend_type2 implements KeywordAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		DBManager db = new DBManager();
		Connection conn =null; PreparedStatement pstmt =null; ResultSet rset =null;
		String sql= "select * from card where type2= ?";
		try {
			// <td><a href="<%=request.getContextPath() %>/detail.replydo?bno=${item.no}" >${item.name}</a></td>
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("type2") );
			rset = pstmt.executeQuery();	//표
			while (rset.next()) {	//줄
				out.println("<tr><td>" +rset.getInt("no")
				//+"</td><td>"+rset.getString("name")
				+"</td><td><a href='"+request.getContextPath()+"/search_detail.keyword?no="+rset.getInt("no")+"'>"+rset.getString("name")
				+"</a></td><td>"+rset.getString("idnum")  
				+"</td><td>"+rset.getString("gender")
				+"</td><td>"+rset.getString("age")
				+"</td><td>"+rset.getString("type1")
				+"</td><td>"+rset.getString("type2")
				+"</td><td>"+rset.getInt("benefit")
				+"</td><td>"+rset.getString("date")
				+"</td></tr>"     
				);
			}//end while
			/*
	  <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <p><%=dto.getName()%></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>	
			 */
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {try {conn.close();	}catch(SQLException e) {e.printStackTrace(); } }
			if(pstmt !=null) {try {pstmt.close();	}catch(SQLException e) {e.printStackTrace(); } }
			if(rset !=null) {try {rset.close();	}catch(SQLException e) {e.printStackTrace(); } }
		}

	}//end execute

}//end class
