package com.alex0517.condition_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
	
}//end interface
