package com.alex0517.cardbasketDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.cardbasketDto.CardbasketDto;
import com.alex0517.dbmanger.DBManager;
import com.alex0517.keywordDto.KeywordDto;

public class CardbasketDao {
	public int addcard(KeywordDto dto, CustomerDto dto1 ) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql ="insert into cardbasket (no,id,cardname) values( (select cno from customermember where cid =?), ?, ?)";
		String sql ="insert into cardbasket (no,id,cardname,cardnum) values( (select cno from customermember where cid =?), ?, ?,"
				+ "(select no from card where name = ?)  )";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto1.getCid());
			pstmt.setString(2, dto1.getCid());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getName());
			result =pstmt.executeUpdate();
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
	
	}//end addcard

	////////////////////////////
	public ArrayList<CardbasketDto> basketinfo_1(CustomerDto dto) {
		ArrayList<CardbasketDto> list = new ArrayList<CardbasketDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql ="select * from cardbasket where no =(select cno from customermember where cid =?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new CardbasketDto(rset.getInt("no"), rset.getString("id"), rset.getString("cardname"), rset.getInt("cardnum") ));

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
		
	}//end basketinfo_1	
//////////////////////////
	public int delete(CardbasketDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "delete from cardbasket where cardname like ?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCardname());
			//pstmt.setString(2, dto.getBpass());
			result = pstmt.executeUpdate();
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}	
		
		return result;
		
	}//end delete
	public CardbasketDto detail(String cardname) {
		CardbasketDto dto = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from cardbasket where cardname=?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardname);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	//public BoardDto(int bno, String bname, String btitle, String bpass, String bcontent, String bdate, int bhit, String bip) {
            	
            	dto = new CardbasketDto(rset.getInt("no"), rset.getString("id"), rset.getString("cardname"), rset.getInt("cardnum"));
            			
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
