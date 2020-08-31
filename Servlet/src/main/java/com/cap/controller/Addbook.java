package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.beans.Book;
import com.cap.beans.Library;
import com.cap.dao.DaoImpl;

public class Addbook extends HttpServlet{
	 private static final long serialVersionUID = 1L;
		DaoImpl dao = new DaoImpl();
	    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			Book book = new Book();
			String libname = request.getParameter("library");
			Library library = dao.getLibrary(libname);
			book.setLibrary(library);
			
			book.setBookId(Integer.parseInt(request.getParameter("bookId")));
			
			book.setAuthor(request.getParameter("author"));
			book.setBookName(request.getParameter("bookName"));
			book.setPublisher(request.getParameter("publisher"));
			
			dao.addBook(book);
			out.println("Book added");
			
		}
}
