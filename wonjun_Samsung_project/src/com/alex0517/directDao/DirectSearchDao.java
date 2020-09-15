package com.alex0517.directDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.dbmanger.DBManager;
import com.alex0517.keywordDto.KeywordDto;

public class DirectSearchDao {
	public ArrayList<KeywordDto> direct_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();		
		String sql ="select * from card where idnum like ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIdnum());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),
            			rset.getString("age"),rset.getString("type1") , rset.getString("type2"), 
            			rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),
            			rset.getString("pic")
            			
            			));

            }//end while		
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end direct_res
	public ArrayList<KeywordDto> direct_res(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql ="select * from card where idnum like ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIdnum());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),
            			rset.getString("age"),rset.getString("type1") , rset.getString("type2"), 
            			rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),
            			rset.getString("pic")
            			
            			));

            }//end while		
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end age_res		
	public ArrayList<CustomerDto> admin_search(CustomerDto dto) {
		ArrayList<CustomerDto> list = new ArrayList<CustomerDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();		
		String sql ="select * from customermember where cname like ?";
		//String sql ="select * from customermember where cname  ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
			// cno | cid     | cname   | cpass | cemail          | cdate               | cip             | cbirth     | cphone
            while(rset.next()){
            	list.add(new  CustomerDto(rset.getInt("cno"),rset.getString("cid"),rset.getString("cname"),
            			rset.getString("cpass"),rset.getString("cemail"),rset.getString("cdate"),
            			rset.getString("cip"),rset.getString("cbirth"),rset.getString("cphone"),
            			rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")//추가된부분
            			));

            }//end while		
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end admin_search
	public ArrayList<CustomerDto> admin_search_id(CustomerDto dto) {
		ArrayList<CustomerDto> list = new ArrayList<CustomerDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();		
		String sql ="select * from customermember where cid like ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
			// cno | cid     | cname   | cpass | cemail          | cdate               | cip             | cbirth     | cphone
            while(rset.next()){
            	list.add(new  CustomerDto(rset.getInt("cno"),rset.getString("cid"),rset.getString("cname"),
            			rset.getString("cpass"),rset.getString("cemail"),rset.getString("cdate"),
            			rset.getString("cip"),rset.getString("cbirth"),rset.getString("cphone"),
            			rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")//추가된부분
            			));

            }//end while		
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end admin_search_id	
	
	
	
}//end class
