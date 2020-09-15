package com.alex0517.BoardDao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.BoardDto.BoardDto;
import com.alex0517.dbmanger.DBManager;

public class BoardDao {
	//[list]
	//[list.jsp]
	//sql 1) 전체테이블 데이터 불러오기  : select * from mvcboard4 order by bdate desc;
	/*****
	1. public ArrayList<BoardDto> listAll()
	2. return : ArrayList<BoardDto>
	3. parameter : 없음
	****/
	public ArrayList<BoardDto> listAll(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from mvcboard4 order by bdate desc";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new BoardDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("btitle"), rset.getString("bpass"), rset.getString("bcontent"),
						rset.getString("bdate"), rset.getInt("bhit"), rset.getString("bip"), rset.getString("bfile")) );
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
	//sql 2) 전체테이블의 갯수 불러오기 : select count(*) from mvcboard4;
	/*****
	1. public int listcnt()
	2. return : int
	3. parameter : 없음
	****/
	public int listcnt() {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select count(*) from mvcboard4";
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
		
	}
	//[write]
	//sq1 3) 데이터 등록 : insert into mvcboard4 (bname,bpass,btitle,bcontent,bip) values(?, ?, ?, ?, ?);
	/*****
	1. public int write(BoardDto dto)
	2. return : int
	3. parameter : BoardDto
	****/
	public int write(BoardDto dto) {
		//ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "insert into mvcboard4 (bname,bpass,btitle,bcontent,bip,bfile) values(?, ?, ?, ?, ?, ?)";
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
			pstmt.setString(6, dto.getBfile());
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
	//[detail]
	//sq1 4) 상세보기, 수정폼 : select * from mvcboard4 where bno =?;
	/*****
	1. public BoardDto detail(int bno)
	2. return : BoardDto
	3. parameter : int
	****/
	public BoardDto detail(int bno) {
		BoardDto dto = null;
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from mvcboard4 where bno =?";
		//int res =0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
            if(rset.next()){
            	//public BoardDto(int bno, String bname, String btitle, String bpass, String bcontent, String bdate, int bhit, String bip) {
            	
            	dto = new BoardDto(rset.getInt("bno"), rset.getString("bname"), rset.getString("btitle"),
            			rset.getString("bpass"), rset.getString("bcontent"), rset.getString("bdate"), 
            			rset.getInt("bhit"), rset.getString("bip"), rset.getString("bfile"));
            			
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
	//sql 5) 상세보기 조회수 올리기 :  update mvcboard4 set bhit = bit+1 where bno = ?;
	/*****
	1. public int addhit(int bno)
	2. return : int
	3. parameter : int
	****/
	public int addhit(int bno) {
		
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "update mvcboard4 set bhit = bhit+1 where bno = ?";
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
		
	}
	//[update]
	//sql 6)  update mvcboard4 set btitle =?, btitle =? where bno =? and bpass=?;
	/*****
	1. public int update(BoardDto dto)
	2. return : int
	3. parameter : BoardDto
	****/
	public int update(BoardDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "update mvcboard4 set btitle =?, bcontent =?, bfile=? where bno =? and bpass=?";
		int result =-1;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());   
			pstmt.setString(3, dto.getBfile());
			pstmt.setInt(4, dto.getBno());
			pstmt.setString(5, dto.getBpass());
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
	//[delete]
	//sql 7) delete from mvcboard4 where bno=? and bpass=?;
	/*****
	1. public int delete(BoardDto dto)
	2. return : int
	3. parameter : BoardDto
	****/
	public int delete(BoardDto dto) {
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "delete from mvcboard4 where bno=? and bpass=?";
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
	public ArrayList<BoardDto> list10(int pstartno){		//10개 가져오기 	
		Connection conn =null; PreparedStatement pstmt =null;	ResultSet rset=null;
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql ="select * from mvcboard4 order by bno desc limit ?,10";
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
				String bfile = rset.getString("bfile");
				list.add(new BoardDto(bno, bname, btitle, bpass, bcontent, bdate, bhit, bip, bfile));
			}
		} catch (Exception e) {e.printStackTrace();
		}finally{
			if(rset != null){try{rset.close();} catch(Exception e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch(Exception e){e.printStackTrace();}}
			if(conn != null){try{conn.close();} catch(Exception e){e.printStackTrace();}}
		}
		return list;
	}//end list10
	
}//end class
