package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.dao.DaoImpl;



public class DeleteBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		DaoImpl dao = new DaoImpl();
		dao.deleteBook(Integer.parseInt(request.getParameter("deletebookId")));
		out.println("Book ID "+request.getParameter("deletebookId")+" deleted. ");
	}

	
}
