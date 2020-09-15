package com.alex0517.condition_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.conditionDao.CardBenefitDao;
import com.alex0517.conditionDto.CardBenefitDto;
import com.alex0517.keywordDto.KeywordDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Condition_recommend_phone implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		///////////////////////////////////////////
		CardBenefitDto dto = new CardBenefitDto();
		//CardBenefitDao_1 dao = new CardBenefitDao_1();
		CardBenefitDao dao = new CardBenefitDao();
		KeywordDto dto1 = new KeywordDto();
		//////////
		String age = request.getParameter("age_condition");
		String gender = request.getParameter("gender_condition");
		dto1.setAge(age);
		dto1.setGender(gender);
		////////////////////////////////////////////////////////////////
		String company = request.getParameter("idnum_condition");			//ajax값 넘어오는지 확인
		String card_id = company+"%";		//시작문자열
		dto1.setIdnum(card_id);
		////////////////////////////////////////////////////////////////
		String type_1 = request.getParameter("type1_condition");
		dto1.setType1(type_1);
		String type_2 = request.getParameter("type2_condition");
		dto1.setType2(type_2);		
		////////////
		String oil_1 = request.getParameter("oil_condition");
		String oil = "%"+oil_1+"%";
		dto.setOil(oil);
		/////////////////////////////////////
		String movie_1 = request.getParameter("movie_condition");
		String movie = "%"+movie_1+"%";
		dto.setMoive(movie);
		////////////////////////////////////////////
		String coffee_1 = request.getParameter("coffee_condition");
		String coffee = "%"+coffee_1+"%";
		dto.setCoffee(coffee);
		///////////////////////////////////////////////
		String transportation_1 = request.getParameter("transportation_condition");
		String transportation = transportation_1+"%";
		dto.setTransportation(transportation);
		///////////////////////////////////////////////
		String air_1 = request.getParameter("air_condition");
		String air = "%"+air_1+"%";
		dto.setAir(air);
		///////////////////////////////////////////////
		String shopping_1 = request.getParameter("shopping_condition");
		String shopping = "%"+shopping_1+"%";
		dto.setShopping(shopping);
		///////////////////////////////////////////////
		String fastfood_1 = request.getParameter("fastfood_condition");
		String fastfood = "%"+fastfood_1+"%";		
		dto.setFastfood(fastfood);
		///////////////////////////////////////////////
		String phone_1 = request.getParameter("phone_condition");
		String phone = "%"+phone_1+"%";		
		dto.setPhone(phone);
		///////////////////////////////////////////////

		//request.setAttribute("dto_benefit", dao.benefit_res1(dto,dto1));	
		////////////////////////////////////////////
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		ArrayList<KeywordDto> list = dao.benefit_phone(dto, dto1);
		for(int i=0; i<list.size(); i++) {
			JsonObject obj = new JsonObject();
				obj.addProperty("no", list.get(i).getNo());
				
				obj.addProperty("name", list.get(i).getName());
				obj.addProperty("idnum", list.get(i).getIdnum());
				obj.addProperty("gender", list.get(i).getGender());
				obj.addProperty("age", list.get(i).getAge());
				obj.addProperty("type1", list.get(i).getType1());
				obj.addProperty("type2", list.get(i).getType2());
				obj.addProperty("pic", list.get(i).getPic());
				array.add(obj);
				// name                       | idnum         | gender | age      | type1    | type2
		}
		out.println(gson.toJson(array) );
		
		
	}//end exucute

}//end class
