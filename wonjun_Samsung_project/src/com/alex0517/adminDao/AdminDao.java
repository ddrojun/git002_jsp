package com.alex0517.adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.dbmanger.DBManager;

public class AdminDao {
	public CustomerDto detail(int cno) {
		CustomerDto dto = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from customermember where cno =?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	//public BoardDto(int bno, String bname, String btitle, String bpass, String bcontent, String bdate, int bhit, String bip) {
            	
            	dto = new CustomerDto(rset.getInt("cno"), rset.getString("cid"), rset.getString("cname"),
            			rset.getString("cpass"), rset.getString("cemail"), rset.getString("cdate"), 
            			rset.getString("cip"), rset.getString("cbirth"), rset.getString("cphone"),
            			rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")
            			);
            			
            }
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return dto;
		
	}
	
	
}//end class
