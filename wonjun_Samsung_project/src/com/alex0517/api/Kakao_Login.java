package com.alex0517.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Kakao_Login
 */
@WebServlet("/Kakao_Login")
public class Kakao_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kakao_Login() {
        super();
        // TODO Auto-generated constructor stub
        //http://localhost:8080/api_xml/Kakao_Login
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String client_id ="d5f8c2bc275a01f6c26e5fcab237320c";
		String redirect_uri ="http://localhost:8080/wonjun_Samsung_project/Kakao_Login";
	
		String code =request.getParameter("code");
		System.out.println(code);
		String url ="https://kauth.kakao.com/oauth/token?";
	
		url +="grant_type=authorization_code&";
		url +="client_id="+client_id +"&";
		url +="redirect_uri" +redirect_uri +"&";
		url += "code=" +code;
		///////////////////////////////////////////////////////////////
		URL kakaourl =  new URL(url);
		HttpURLConnection conn = (HttpURLConnection)kakaourl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		//conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
		///////////////////////////////////////////////////////////////////
		BufferedReader br =null;
		String line =null;
		StringBuffer sb = new StringBuffer();
		
		if(conn.getResponseCode() ==200) 
		{ br = new BufferedReader(new InputStreamReader(conn.getInputStream())); }
		else 
		{ br = new BufferedReader(new InputStreamReader(conn.getErrorStream())); }
		
		while((line =br.readLine()) != null) {
			sb.append(line); 
		 }//end while
		//System.out.println(sb.toString());
		///////////////////////////////////////////////////
		//1. json 파일에서 access_token 추출하기 (1)
		JsonParser parser = new JsonParser();
		JsonObject jobj = (JsonObject)parser.parse(sb.toString());
		String access_token = jobj.get("access_token").getAsString();
		/////////////////
		/*
		 GET/POST /v2/user/me HTTP/1.1
		Host: kapi.kakao.com
		Authorization: Bearer {access_token}
		Content-type: application/x-www-form-urlencoded;charset=utf-8
		 */
		//2. 사용자 정보요청 http통신
		url ="https://kapi.kakao.com/v2/user/me";
		kakaourl = new URL(url);
		conn = (HttpURLConnection)kakaourl.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " +access_token);
		conn.setRequestProperty("Content-type", "application/json; charset=utf-8");
		br =null;
		line =null;
		sb = new StringBuffer();
		
		if(conn.getResponseCode() ==200) 
		{ br = new BufferedReader(new InputStreamReader(conn.getInputStream())); }
		else 
		{ br = new BufferedReader(new InputStreamReader(conn.getErrorStream())); }
		
		while((line =br.readLine()) != null) {
			sb.append(line); 
		 }//end while
		//System.out.println(sb.toString());
		br.close();
		conn.disconnect();
		//3. 사용자 view페이지에서 확인
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject)jsonParser.parse(sb.toString() );
		JsonObject profile = (JsonObject)jsonObject.get("properties");
		//JsonObject profile2 = (JsonObject)jsonObject.get("properties");
		
		JsonObject profile2 = (JsonObject)jsonObject.get("kakao_account");
		System.out.println("확인1 : " +profile);
		System.out.println("확인2 : " +profile2);
		///
		String nickname =profile.get("nickname").getAsString();
		String thumbnail_image =profile.get("thumbnail_image").getAsString();
		////////////////////////////////////////////////////////////////////////
		//String email = profile2.get("email").getAsString();
		//String birthday = profile2.get("birthday").getAsString();
		//String phone_number = profile2.get("phone_number").getAsString();
		//
		//String email = request.getParameter("email");
		request.setAttribute("nickname", nickname);
		request.setAttribute("thumbnail_image", thumbnail_image);
		///////////////////////////////////////////////////////////
		//request.setAttribute("email", email);
		//request.setAttribute("birthday", birthday);
		//request.setAttribute("phone_number", phone_number);
		//request.getRequestDispatcher("kakao/kakao_login.jsp").forward(request, response);  ///join_agree.customer
		request.getRequestDispatcher("/join_agree.customer").forward(request, response);
		
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
