package com.alex0517.BoardDao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.BoardDto.BoardDto_1;
import com.alex0517.dbmanger.DBManager;
import com.alex0517.keywordDto.KeywordDto;

public class BoardDao_1 { //카드정보
	public ArrayList<KeywordDto> listAll(){
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card order by date desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new KeywordDto(rset.getInt("no"), rset.getString("name"),
						rset.getString("idnum"),rset.getString("gender"),rset.getString("age"),
						rset.getString("type1"), rset.getString("type2"), rset.getInt("benefit"),
						rset.getString("date"),rset.getString("ip"),rset.getString("writer"),
						rset.getString("pic")
						));
			}//end while
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return list;
		
	}//end listAll		
	public BoardDto_1 detail(int cno) {
		BoardDto_1 dto = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from cardinfo where cno =?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	//public BoardDto(int bno, String bname, String btitle, String bpass, String bcontent, String bdate, int bhit, String bip) {
            	
            	dto = new BoardDto_1(rset.getInt("cno"), rset.getString("cname"), rset.getString("cdate"),
            			rset.getString("crate"), rset.getString("cinfo") );
            			
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
		
	}//end detail
	///
	public int write(KeywordDto dto) {
		//ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "insert into card (name,idnum,gender,age,type1,type2,benefit,ip,writer) values(?,?,?,?, ?, ?, ?, ?, ?)";
		//String sql ="update cardbasket set no= ?, id= ?, cardname =? where no= (select cno from customermember where cname= ?)";
		int find =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());  
			pstmt.setString(2, dto.getIdnum());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getAge());
			pstmt.setString(5, dto.getType1());
			pstmt.setString(6, dto.getType2());
			pstmt.setInt(7, dto.getBenefit());
			pstmt.setString(8, InetAddress.getLocalHost().getHostAddress());
			pstmt.setString(9, dto.getWriter());
			find = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return find;
		
	}	
	
}//end class
