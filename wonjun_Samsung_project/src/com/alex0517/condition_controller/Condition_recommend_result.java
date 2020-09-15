package com.alex0517.condition_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.conditionDao.CardBenefitDao;
import com.alex0517.conditionDao.CardBenefitDao_1;
import com.alex0517.conditionDto.CardBenefitDto;
import com.alex0517.keywordDto.KeywordDto;

public class Condition_recommend_result implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");			
		PrintWriter out = response.getWriter();
		///////////////////////////////////////////
		CardBenefitDao dao1 = new CardBenefitDao();
		CardBenefitDao_1 dao = new CardBenefitDao_1();
		CardBenefitDto dto = new CardBenefitDto();
		ArrayList<KeywordDto> list = null;
		list = dao1.output_card(dao.benefit_res(dto));
		System.out.println(list);
		request.setAttribute("list", list);		
		
		
		
		
		
		
	}//end execute

}//end class
