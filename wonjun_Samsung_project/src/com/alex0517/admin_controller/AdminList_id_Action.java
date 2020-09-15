package com.alex0517.admin_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex0517.Customerdto.CustomerDto;
import com.alex0517.directDao.DirectSearchDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AdminList_id_Action implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		///////////////////////////////////////////
		CustomerDto dto = new CustomerDto();
		DirectSearchDao dao = new DirectSearchDao();
		//String str = "%"+request.getParameter("search")+"%";
		String str = "%"+request.getParameter("search_id")+"%";
		dto.setCid(str);
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		ArrayList<CustomerDto> list = dao.admin_search_id(dto);
		for(int i=0; i<list.size(); i++) {
			JsonObject obj = new JsonObject();
				obj.addProperty("no", list.get(i).getCno());
			
				obj.addProperty("name", list.get(i).getCname());
				obj.addProperty("id", list.get(i).getCid());
				obj.addProperty("email", list.get(i).getCemail());
				obj.addProperty("birth", list.get(i).getCbirth());
				obj.addProperty("phone", list.get(i).getCphone());
				obj.addProperty("date", list.get(i).getCdate());
				
				obj.addProperty("postcode", list.get(i).getCpostcode());
				obj.addProperty("post1", list.get(i).getCpost1());
				obj.addProperty("post2", list.get(i).getCpost2());
				
				array.add(obj);
				// name                       | idnum         | gender | age      | type1    | type2
		}
		out.println(gson.toJson(array) );
	}//end execute

}//end class
