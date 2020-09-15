package com.alex0517.BoardDao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.BoardDto.ReplyDto;
import com.alex0517.dbmanger.DBManager;

public class ReplyDao {
	public ArrayList<ReplyDto> readAll(){	//전체 글 목록
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select * from mvcboard5 order by bdate desc";
		String sql = "select * from mvcboard6 order by bstep desc, bindent asc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ReplyDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("btitle"), rset.getString("bpass"), rset.getString("bcontent"),
						rset.getString("bdate"), rset.getInt("bhit"), rset.getString("bip"),
						rset.getInt("bgroup"), rset.getInt("bstep"), rset.getInt("bindent")   ));		
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}	
		return list;
	}//end listAll
	public int listcnt() {  //테이블 갯수
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select count(*) from mvcboard6 order by bstep desc, bindent asc";
		int count = 0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
            if(rset.next()){
           	 	count =rset.getInt(1);
            }
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return count;
		
	}//end listcnt
	public int create(ReplyDto dto) { //글쓰기
		//ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "insert into mvcboard6 (bname,bpass,btitle,bcontent,bip,bgroup,bstep) values(?, ?, ?, ?,?,?,?)";
		int find =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, request.getParameter("bname"));
			pstmt.setString(1, dto.getBname());  //dto.getBname
			pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(6, dto.getBgroup());
			pstmt.setInt(7, dto.getBstep());
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
	public ReplyDto read(int bno) {	//상세 페이지
		//ReplyDto result = new ReplyDto();
		ReplyDto result =null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from mvcboard6 where bno =?";
		int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	result = new ReplyDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("btitle"),
            			rset.getString("bpass"), rset.getString("bcontent"), rset.getString("bdate"), 
            			rset.getInt("bhit"), rset.getString("bip"),rset.getInt("bgroup"), 
            			rset.getInt("bstep"), rset.getInt("bindent"));
            			
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
		
	}//end detail
	public int update_hit(int bno) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "update mvcboard6 set bhit = bhit+1 where bno = ?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
		
	}//end addhit
	public int update(ReplyDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "update mvcboard6 set btitle =?, bcontent =? where bno =? and bpass=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());   
			pstmt.setInt(3, dto.getBno());
			pstmt.setString(4, dto.getBpass());
			/////////////////////////////////////
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
	public int delete(ReplyDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "delete from mvcboard6 where bno=? and bpass=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBno());
			pstmt.setString(2, dto.getBpass());
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
////////////////////////////////////////////
	public ArrayList<ReplyDto> list10(int pstartno){		//10개 가져오기 	
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset=null;
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		String sql ="select * from mvcboard6 order by bstep desc, bindent asc limit ?,10";
		DBManager db = new DBManager();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pstartno);
			rset = pstmt.executeQuery();	//표
			while (rset.next()) {			//줄
				int bno = rset.getInt("bno");
				String bname = rset.getString("bname");
				String btitle = rset.getString("btitle");
				String bpass = rset.getString("bpass");
				String bcontent = rset.getString("bcontent");
				String bdate = rset.getString("bdate");
				int bhit = rset.getInt("bhit");
				String bip = rset.getString("bip");
				//
				int bgroup = rset.getInt("bgroup");
				int bstep = rset.getInt("bstep");
				int bindent = rset.getInt("bindent");
				/////
				list.add(new ReplyDto(bno, bname, btitle, bpass, bcontent, bdate, bhit, bip,bgroup,bstep,bindent));
			}
		} catch (Exception e) {e.printStackTrace();
		}finally{
			if(rset != null){try{rset.close();} catch(Exception e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(Exception e){e.printStackTrace();}}
			if(conn != null){try{conn.close();} catch(Exception e){e.printStackTrace();}}
		}
		return list;
		
	}//end list10
	public int max_read() {	//최대 번호 찾기
		int max =-1;
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset=null;
		String sql ="select max(bstep) from mvcboard6";
		DBManager db = new DBManager();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();	//표
			if(rset.next()) {
				max =rset.getInt(1);
			}
		} catch (Exception e) {e.printStackTrace();
		}finally{
			if(rset != null){try{rset.close();} catch(Exception e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(Exception e){e.printStackTrace();}}
			if(conn != null){try{conn.close();} catch(Exception e){e.printStackTrace();}}
		}
		
		return max;
		
	}//end max_read
	//답변글 달기
	//1. update
	//2. insert
	public int update_reply(int prev, int curr) {
		int result =-1;
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset=null;
		String sql = "update mvcboard6 set bstep=bstep-1 where bstep >? and bstep<?";
		DBManager db = new DBManager();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prev);	//이전 1
			pstmt.setInt(2, curr);	//현재 999
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {e.printStackTrace();
		}finally{
			if(rset != null){try{rset.close();} catch(Exception e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(Exception e){e.printStackTrace();}}
			if(conn != null){try{conn.close();} catch(Exception e){e.printStackTrace();}}
		}
		
		return result;
		
	}//end update_reply
	public int create_re(ReplyDto dto) { //글쓰기
		//ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "insert into mvcboard6 (bname,bpass,btitle,bcontent,bip,bgroup,bstep,bindent) values(?, ?, ?, ?,?,?,?,?)";
		int find =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());  //dto.getBname
			pstmt.setString(2, dto.getBpass());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			pstmt.setInt(6, dto.getBgroup());
			pstmt.setInt(7, dto.getBstep());
			pstmt.setInt(8, dto.getBindent());
			find = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return find;
		
	}//end write_re
}//end class
