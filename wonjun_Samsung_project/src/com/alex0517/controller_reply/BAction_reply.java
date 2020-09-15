package com.alex0517.controller_reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BAction_reply {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}//end execute
