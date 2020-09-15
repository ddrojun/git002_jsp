package com.alex0517.condition_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.conditionDao.CardBenefitDao;
import com.alex0517.keywordDto.KeywordDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Condition_recommend_type1 implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		///////////////////////////////////////////
		KeywordDto dto = new KeywordDto();
		CardBenefitDao dao = new CardBenefitDao();
		String age = request.getParameter("age_condition");
		String gender = request.getParameter("gender_condition");
		dto.setAge(age);
		dto.setGender(gender);
		////////////////////////////////////////////////////////////////
		String company = request.getParameter("idnum_condition");			//ajax값 넘어오는지 확인
		String card_id = company+"%";		//시작문자열
		dto.setIdnum(card_id);
		////////////////////////////////////////////////////////////////
		String type_1 = request.getParameter("type1_condition");
		dto.setType1(type_1);
		
		//System.out.println("gender : " +gender);
		//System.out.println("age : " +age);
		//System.out.println("company: " + company);					//ajax값 넘어오는지 확인
		//System.out.println("card_id : " +card_id);
		//System.out.println("type1 : " +type_1);
		request.setAttribute("dto_type1", dao.type1_res1(dto));
		//System.out.println("4.type1선택시 no확인 : "+request.getAttribute("dto_type1"));
		//////
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		ArrayList<KeywordDto> list = dao.type1_res1(dto);
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
		
	}//end execute

}//end class
