package com.alex0517.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Naver_Search_Shopping
 */
@WebServlet("/Naver_Search_Shopping")
public class Naver_Search_Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Naver_Search_Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//////////////////////////////////////////////////////
        String clientId = "XV3rYr26mP4rJowZSPgh"; 	//애플리케이션 클라이언트 아이디값"
        String clientSecret = "XbJGbmptz6"; 		//애플리케이션 클라이언트 시크릿값"
        //String  text = URLEncoder.encode("자바", "UTF-8");		//자바가 원하는 키워드 ##
        String  text = URLEncoder.encode(request.getParameter("search_shopping"), "UTF-8");
        System.out.println(text);
        //String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    		
        String apiURL ="https://openapi.naver.com/v1/search/shop.json?query="+text;

        URL url = new URL(apiURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Naver-Client-Id", clientId);
        conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        
        //out.println(conn.getResponseCode());	// 200 나오면 성공
        //////////////////////////////////////////////////////////////////////
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        String line ="";
        if(conn.getResponseCode() ==200)
        { br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8" ) ); }
        else
        { br = new BufferedReader(new InputStreamReader(conn.getErrorStream()) ); }
        
        while ((line =br.readLine() )!=null) {
			sb.append(line);
		}//end while
        br.close();
        conn.disconnect();
        out.println(sb.toString());
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
