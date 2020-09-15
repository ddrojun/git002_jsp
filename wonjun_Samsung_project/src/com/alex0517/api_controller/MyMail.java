package com.alex0517.api_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyMail
 */
@WebServlet("/MyMail")
public class MyMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMail() {
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
		//String subject = "SUBJECT";//request.getParameter("subject");
		//String content="CONTENT"; //request.getParameter("content");
		String subject =request.getParameter("subject");
		String content =request.getParameter("content");
		/////////////////////////////////////// 네이버
		  String host     = "smtp.naver.com";
		  final String user   = "ddrojun@naver.com";    
		  final String password  = "wmf61920!";
		  /* 1)보내는 쪽의 메일설정부분
		  final String user   = "NAVER_ID";  
		  final String password  = "PASSWORD"; */

		/////////////////////////////////////// 네이버
		  // 2) 받는 사람의 메일주소   - 고객님주소~!
		//  String to     = "cozizii-_-@naver.com";
		  String to =request.getParameter("email");
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "587");

		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(user, password);
		   }
		  });

		  //System.out.println("1");
		  // Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   // 3) 메일제목 Subject
		   message.setSubject(subject);
		   
		   // 4) 메일내용 Text
		   // 1. 일반 텍스트로 메일을 보낼 때
		   //message.setText("메일 본문 내용 HTML 코딩");
		  // message.setText(content);
		   message.setContent(content, "text/html;charset=euc-kr");
		   //2. html로 작성한 메일을 보낼 때
		   /*
		   message.setContent(""
		   		+ "<h3>myfriends</h3>"
		   		+ "<p>hello!</p>"
		   		+ "<p><img src='https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png' alt=''/></p>"
		   		
		   		, "text/html;charset=euc-kr");
		    */
 
		   
		   
		   // send the message
		   Transport.send(message);
		  // System.out.println("message sent successfully...");
		  // System.out.println("3");	
		   out.println("<script>alert('메일발송 완료');"
					+"location.href='"+request.getContextPath()+"/start.customer'; </script>" );		   
		   //response.sendRedirect("/");



		  } catch (MessagingException e) {
		   e.printStackTrace();
		   System.out.println("실패");
			out.println("<script>alert('메일발송 실패');"
					+"location.href='"+request.getContextPath()+"/api/mail.jsp'; </script>" );
		  }
		
	}//end get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
