package com.alex0517.BoardDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.alex0517.BoardDto.InvestmentDto_1;
import com.alex0517.dbmanger.DBManager;

public class InvestmentDao_1 {
	public ArrayList<InvestmentDto_1> read() throws ServletException, IOException{   //리스트 보여주기 
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset=null;
		ArrayList<InvestmentDto_1> list = new ArrayList<InvestmentDto_1>();
		String sql ="select * from investmenu";
		DBManager db = new DBManager();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				int no = rset.getInt("no");
				String name = rset.getString("name");
				list.add(new InvestmentDto_1(no, name));
				
			}
			
		} catch (Exception e) {e.printStackTrace();
		}finally{
			if(rset != null){try{rset.close();} catch(Exception e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(Exception e){e.printStackTrace();}}
			if(conn != null){try{conn.close();} catch(Exception e){e.printStackTrace();}}
		}
		return list;
		
	}
}//end class
