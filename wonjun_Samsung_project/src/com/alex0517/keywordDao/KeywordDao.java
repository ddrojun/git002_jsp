package com.alex0517.keywordDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.conditionDto.CardBenefitDto;
import com.alex0517.dbmanger.DBManager;
import com.alex0517.keywordDto.KeywordDto;

public class KeywordDao {
	public ArrayList<KeywordDto> listAll(){
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new KeywordDto(rset.getInt("no"), rset.getString("name"),rset.getString("idnum"),
						rset.getString("gender"),rset.getString("age"), rset.getString("type1"),
						rset.getString("type2"),rset.getInt("benefit"), rset.getString("date"),
						rset.getString("ip"), rset.getString("writer"),rset.getString("pic")		)  );
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
	public ArrayList<KeywordDto> listcnt(){
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card order by no asc limit 10;";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new KeywordDto(rset.getInt("no"), rset.getString("name"),rset.getString("idnum"),
						rset.getString("gender"),rset.getString("age"), rset.getString("type1"),
						rset.getString("type2"),rset.getInt("benefit"), rset.getString("date"),
						rset.getString("ip"), rset.getString("writer"),rset.getString("pic")		)  );
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
	//////////////////////////////////////////////
	public KeywordDto detail_name(int no) {
		KeywordDto dto = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card where no =?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	dto = new KeywordDto(rset.getInt("no"), rset.getString("name"),rset.getString("idnum"),
						rset.getString("gender"),rset.getString("age"), rset.getString("type1"),
						rset.getString("type2"),rset.getInt("benefit"), rset.getString("date"),
						rset.getString("ip"), rset.getString("writer"),rset.getString("pic")	 );
            			
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
	public CardBenefitDto detail_benefit(int no) {
		//KeywordDto dto = null;
		CardBenefitDto dto1 =null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select * from card where no =?";
		String sql =" select * from cardbenefit where cbno =(select benefit from card where no = ?)";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	dto1 = new CardBenefitDto(rset.getInt("cbno"), rset.getInt("no"), rset.getString("oil"),rset.getString("movie"),
						rset.getString("coffee"),rset.getString("transportation"), rset.getString("air"),
						rset.getString("shopping"),rset.getString("fastfood"), rset.getString("phone"),
						rset.getString("mart"),rset.getString("date"),
						rset.getString("ip"), rset.getString("writer")	);
            			
            }
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return dto1;
		
	}//end detail_benefit
	///

	
}//end class
