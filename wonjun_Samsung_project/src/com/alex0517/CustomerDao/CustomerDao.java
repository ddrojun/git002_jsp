package com.alex0517.CustomerDao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.adminDto.AdminDto;
import com.alex0517.cardbasketDto.CardbasketDto;
import com.alex0517.dbmanger.DBManager;


public class CustomerDao {
	public int iddouble(CustomerDto dto) {		//아이디 중복
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select count(*) from customermember where cid=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
		
	}
	//////////////////////////////////////////////////////관리자 로그인
	public int admin_login(AdminDto dto1) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		int result =-1;
		String sql = "select count(*) from admin where aid=? and apass=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto1.getAid());
			pstmt.setString(2, dto1.getApass());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result ;			
	}//end admin_login
	
	//////////////////////////////////////////////////////
	public int join(CustomerDto dto) { //회원가입 db삽입
		Connection conn =null;	PreparedStatement pstmt =null;	//ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "insert into customermember (cid,cname,cpass,cemail,cbirth,cphone,cip,cpostcode,cpost1,cpost2) values(?,?,?,?,?,?,?,?,?,?)";
		int result = -1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCpass());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCbirth());
			pstmt.setString(6, dto.getCphone());
			pstmt.setString(7, InetAddress.getLocalHost().getHostAddress());
			///////////////////////////////
			pstmt.setString(8, dto.getCpostcode());
			pstmt.setString(9, dto.getCpost1());
			pstmt.setString(10, dto.getCpost2());
			
			result = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
		
	}
	//////

	///////
	public int login(CustomerDto dto){
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		int result =-1;
		String sql = "select count(*) from customermember where cid=? and cpass=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpass());
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result ;	
		
	}//end loginMypage
	public ArrayList<CardbasketDto> basketinfo(CustomerDto dto) {
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
		
	}//end basketinfo	
	public CustomerDto userinfo(CustomerDto dto) {
		CustomerDto result = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from customermember where cid =?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			rset = pstmt.executeQuery();
            if(rset.next()){
            	result = new CustomerDto(rset.getInt("cno"), rset.getString("cid"), rset.getString("cname"), rset.getString("cpass"),
						rset.getString("cemail"), rset.getString("cdate"), rset.getString("cip"), rset.getString("cbirth"),
						rset.getString("cphone"), 
						rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")//추가된부분
            			) ;
           //(int cno, String cid, String cname, String cpass, String cemail, String cdate, String cip,
    		//	int cbirth, String cphone)
            }
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
		
	}
	///
	public int user_pass(CustomerDto dto, String oldpass) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		int result = -1;
		String sql = "update customermember set cpass=? where cid=? and cpass=?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpass());
			pstmt.setString(2, dto.getCid());
			pstmt.setString(3, oldpass);
			
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
		
	}
	//////
	public int user_edit(CustomerDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		int result = -1;
		String sql = "update customermember set cname=?, cemail=?, cbirth=?, cphone=?, cpostcode=?, cpost1=?, cpost2=? where cid=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCemail());
			pstmt.setString(3, dto.getCbirth());
			pstmt.setString(4, dto.getCphone());
			pstmt.setString(5, dto.getCpostcode());
			pstmt.setString(6, dto.getCpost1());
			pstmt.setString(7, dto.getCpost2());
			pstmt.setString(8, dto.getCid());
			
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
		
	}
	//////
	public int delete(CustomerDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		int result = -1;
		String sql = "delete from customermember where cid=? and cpass=?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpass());
			
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
	//////////////////
	public CustomerDto find_pass(CustomerDto dto){ 	//비밀번호 찾기
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		CustomerDto result = null;
		//int result =-1;
		//String sql = "select count(*) from customermember where cid=? and cpass=?";
		String sql = "select * from customermember where cid=? and cname=? and cemail=? and cphone=?";
		//아이디 이름 이메일 핸드폰번호
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCemail());
			pstmt.setString(4, dto.getCphone());
			//////////////////////////////////////
			rset = pstmt.executeQuery();
            if(rset.next()){
            	result = new CustomerDto(rset.getInt("cno"), rset.getString("cid"), rset.getString("cname"), rset.getString("cpass"),
						rset.getString("cemail"), rset.getString("cdate"), rset.getString("cip"), rset.getString("cbirth"),
						rset.getString("cphone"),
						rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")//추가된부분
            			) ;
            }
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result ;	
		
	}//end find_pass 
	public CustomerDto find_id(CustomerDto dto) { //아이디 찾기
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		CustomerDto result = null;
		//int result =-1;
		//String sql = "select count(*) from customermember where cid=? and cpass=?";
		//이름 비밀번호 이메일 핸드폰번호
		String sql = "select * from customermember where cname=? and cpass=? and cemail=? and cphone=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCpass());
			pstmt.setString(3, dto.getCemail());
			pstmt.setString(4, dto.getCphone());
			//////////////////////////////////////
			rset = pstmt.executeQuery();
            if(rset.next()){
            	result = new CustomerDto(rset.getInt("cno"), rset.getString("cid"), rset.getString("cname"), rset.getString("cpass"),
						rset.getString("cemail"), rset.getString("cdate"), rset.getString("cip"), rset.getString("cbirth"),
						rset.getString("cphone"),
						rset.getString("cpostcode"),rset.getString("cpost1"),rset.getString("cpost2")//추가된부분
            			) ;
            }
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result ;			

	}//end find_id
	
	
}//end class
