package com.alex0517.Customercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
