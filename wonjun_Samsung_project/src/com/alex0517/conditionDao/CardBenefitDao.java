package com.alex0517.conditionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.conditionDto.CardBenefitDto;
import com.alex0517.dbmanger.DBManager;
import com.alex0517.keywordDto.KeywordDto;

public class CardBenefitDao {		//조건 검색에서 성별 선택시? 
	public ArrayList<KeywordDto> gender_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select no from card where gender =?";	//no 알아내야함 
		//String sql = "select no from card where no = any(select no from card where gender = ?)"; 
		String sql = "select * from card where gender =?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
            			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")
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
		
	}//end gender_res	
	public ArrayList<Integer> gender_res(KeywordDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select no from card where gender =?";	//no 알아내야함 
		//String sql = "select no from card where no = any(select no from card where gender = ?)"; 
		String sql = "select benefit from card where gender =?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("benefit"));
            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}//end gender_res
	public ArrayList<Integer> age_res(KeywordDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select no from card where age =?";	//no 알아내야함 
		String sql = "select benefit from card where age=? and gender =?";
		//String sql = "select no from card where no = any(select no from card where gender = ?)"; 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAge());
			pstmt.setString(2, dto.getGender());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("benefit"));

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
	public ArrayList<KeywordDto> age_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select no from card where age =?";	//no 알아내야함 
		//String sql = "select benefit from card where age=? and gender =?";
		String sql = "select * from card where age =? and gender=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAge());
			pstmt.setString(2, dto.getGender());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), 
            			rset.getString("gender"),rset.getString("age"),
            			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")   ) 
            			);

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
	public ArrayList<Integer> company_res(KeywordDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql= "select * from card where idnum like ?";
		String sql = "select benefit from card where gender =? and age =? and idnum like ?";	//no 알아내야함 
		//select no from card where gender='전체' and age ='20대' and idnum like 'NH농협%';
		try {
			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			//String card_id = request.getParameter("company_condition")+"%";		//시작문자열
			//String card_id = dto.getIdnum() +"%";
			//pstmt.setString(1, card_id);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("benefit"));

            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end company_res
	public ArrayList<KeywordDto> company_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select benefit from card where gender =? and age =? and idnum like ?";	//no 알아내야함 
		String sql = "select * from card where gender =? and age =? and idnum like ?";
		try {
			
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum());
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
            			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
            			);

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
		
	}//end company_res	
	public ArrayList<Integer> type1_res(KeywordDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select benefit from card where gender =? and age =? and idnum like ? and type1= ?";	//no 알아내야함  	
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum());
			pstmt.setString(4, dto.getType1());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("benefit"));

            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}//end type1_res	
	public ArrayList<KeywordDto> type1_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ?";	//no 알아내야함  
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum());
			pstmt.setString(4, dto.getType1());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
              	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
            			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
            			);

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
	}//end type1_res		
	public ArrayList<Integer> type2_res(KeywordDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select benefit from card where gender =? and age =? and idnum like ? and type1= ? and type2 =?";	//no 알아내야함 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum()); 
			pstmt.setString(4, dto.getType1());
			pstmt.setString(5, dto.getType2());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("benefit"));
            		 
            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}//end type1_res	
	public ArrayList<KeywordDto> type2_res1(KeywordDto dto) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =?";	//no 알아내야함 
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGender() );
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getIdnum()); 
			pstmt.setString(4, dto.getType1());
			pstmt.setString(5, dto.getType2());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
              	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
            			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
            			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
            			);
            		 
            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}//end type1_res		
	public ArrayList<KeywordDto> output_card(ArrayList<Integer> no) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		//String sql = "select * from card where no in(?)"; 
		String sql = "select name from card, cardbenefit where card.benefit = cardbenefit.cbno";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no.toString());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new KeywordDto(rset.getString("name"),rset.getString("idnum"),
						rset.getString("gender"),rset.getString("age"),
						rset.getString("type1"),rset.getString("type2")    )   );
			}//end if			
			///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
	}//end type1_res	
	/////////////////////////////////////////////////
	public ArrayList<KeywordDto> benefit_oil(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end oil_res		
	public ArrayList<KeywordDto> benefit_movie(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?

	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

        }//end if			
        ///////////////////////
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
		if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
		if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	return list;
	
}//end benefit_movie		
	public ArrayList<KeywordDto> benefit_coffee(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_cofffee
	public ArrayList<KeywordDto> benefit_transportation(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_transportation	
	
	public ArrayList<KeywordDto> benefit_air(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?"
			+ "and air like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		pstmt.setString(10, dto.getAir());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_air	
	public ArrayList<KeywordDto> benefit_shopping(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?"
			+ "and air like ? and shopping like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		pstmt.setString(10, dto.getAir());
		pstmt.setString(11, dto.getShopping());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_shopping	
	public ArrayList<KeywordDto> benefit_fastfood(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?"
			+ "and air like ? and shopping like ? and fastfood like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		pstmt.setString(10, dto.getAir());
		pstmt.setString(11, dto.getShopping());
		pstmt.setString(12, dto.getFastfood());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_fastfood	
	public ArrayList<KeywordDto> benefit_phone(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?"
			+ "and air like ? and shopping like ? and fastfood like ? and phone like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		pstmt.setString(10, dto.getAir());
		pstmt.setString(11, dto.getShopping());
		pstmt.setString(12, dto.getFastfood());
		pstmt.setString(13, dto.getPhone());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_phone
	
	public ArrayList<KeywordDto> benefit_mart(CardBenefitDto dto,KeywordDto dto1 ) {
	ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
	Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
	DBManager db = new DBManager();
	String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
			+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ?"
			+ "and air like ? and shopping like ? and fastfood like ? and phone like ? and mart like ?)";			
	//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
	
	
	try {
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto1.getGender() );
		pstmt.setString(2, dto1.getAge());
		pstmt.setString(3, dto1.getIdnum()); 
		pstmt.setString(4, dto1.getType1());
		pstmt.setString(5, dto1.getType2());
		///////////////////////////////////
		pstmt.setString(6, dto.getOil() );
		pstmt.setString(7, dto.getMoive());
		pstmt.setString(8, dto.getCoffee());
		pstmt.setString(9, dto.getTransportation());
		pstmt.setString(10, dto.getAir());
		pstmt.setString(11, dto.getShopping());
		pstmt.setString(12, dto.getFastfood());
		pstmt.setString(13, dto.getPhone());
		pstmt.setString(14, dto.getMart());
		//////////////////////////////////////////////////
		rset = pstmt.executeQuery();
        while(rset.next()){
        	list.add(new  KeywordDto(rset.getInt("no"), rset.getString("name"), rset.getString("idnum"), rset.getString("gender"),rset.getString("age"),
        			rset.getString("type1") , rset.getString("type2"), rset.getInt("benefit") , rset.getString("date"), 
        			rset.getString("ip"), rset.getString("writer"),rset.getString("pic")) 
        			);

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
	
}//end benefit_mart
	
	
	
///////////////////////////////////////////////////////////////////////////////	
	public ArrayList<KeywordDto> benefit_res1(CardBenefitDto dto,KeywordDto dto1 ) {
		ArrayList<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
//		String sql = "select * from card where benefit =(select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ? and air like ? "
//				+ "and shopping like ? and fastfood like ? and phone like ? and mart like ?)";	//no 알아내야함  --> 여기서 나온게 16번이고
		
		String sql = "select * from card where gender =? and age =? and idnum like ? and type1= ? and type2 =? "
				+ "and benefit in (select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ? and air like ? "
				+ "and shopping like ? and fastfood like ? and phone like ? and mart like ?)";			
		//card where gender =? and age =? and idnum like ? and type1= ? and type2 =?
		
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto1.getGender() );
			pstmt.setString(2, dto1.getAge());
			pstmt.setString(3, dto1.getIdnum()); 
			pstmt.setString(4, dto1.getType1());
			pstmt.setString(5, dto1.getType2());
			pstmt.setString(6, dto.getOil() );
			pstmt.setString(7, dto.getMoive());
			pstmt.setString(8, dto.getCoffee());
			pstmt.setString(9, dto.getTransportation());
			pstmt.setString(10, dto.getAir());
			pstmt.setString(11, dto.getShopping());
			pstmt.setString(12, dto.getFastfood());
			pstmt.setString(13, dto.getPhone());
			pstmt.setString(14, dto.getMart());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
				list.add(new KeywordDto(rset.getString("name"),rset.getString("idnum"),
						rset.getString("gender"),rset.getString("age"),
						rset.getString("type1"),rset.getString("type2")));

            }//end if			
            ///////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rset !=null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt !=null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn !=null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return list;
		
	}//end oil_res	
	
	
}//end class
