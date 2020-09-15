package com.alex0517.conditionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alex0517.conditionDto.CardBenefitDto;
import com.alex0517.dbmanger.DBManager;

public class CardBenefitDao_1 {
	public ArrayList<Integer> benefit_res(CardBenefitDto dto) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn =null;	PreparedStatement pstmt =null;	ResultSet rset =null;
		DBManager db = new DBManager();
		String sql = "select no from cardbenefit where oil like ? and movie like ? and coffee like ? and transportation like ? and air like ? "
				+ "and shopping like ? and fastfood like ? and phone like ? and mart like ?";	//no 알아내야함  --> 여기서 나온게 16번이고
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getOil() );
			pstmt.setString(2, dto.getMoive());
			pstmt.setString(3, dto.getCoffee());
			pstmt.setString(4, dto.getTransportation());
			pstmt.setString(5, dto.getAir());
			pstmt.setString(6, dto.getShopping());
			pstmt.setString(7, dto.getFastfood());
			pstmt.setString(8, dto.getPhone());
			pstmt.setString(9, dto.getMart());
			//////////////////////////////////////////////////
			rset = pstmt.executeQuery();
            while(rset.next()){
            	list.add(rset.getInt("no"));

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
