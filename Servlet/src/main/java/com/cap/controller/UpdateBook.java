package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.beans.Book;
import com.cap.dao.DaoImpl;



public class UpdateBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		DaoImpl dao = new DaoImpl();
		
		
		int bId = Integer.parseInt(request.getParameter("updatebookId"));
		String newBname = request.getParameter("updatebookName");
		String newBauthor = request.getParameter("updateAuthor");
		String newBpublisher = request.getParameter("updatePublisher");
		
		Book book = dao.findBook(bId);
		
	     out.println("<html>");
		 out.println("<body>");
			
		 	out.println("Before Update");out.print("<br>");
		 	out.print("<br>");
		 	out.println("Book Name : " +book.getBookName());
		 	out.print("<br>");
		 	out.println("Book Author : "+book.getAuthor());
		 	out.print("<br>");
		 	out.println("Book Publisher Name : "+book.getPublisher());
		 	out.print("<br>");
		 
		Book updatebook = dao.updateBookDetails(bId,newBname,newBauthor,newBpublisher);
		 	
			out.println("After Update");out.print("<br>");
			out.print("<br>");
			out.println("Book Name : " +updatebook.getBookName());
			out.print("<br>");
			out.println("Book Author : "+updatebook.getAuthor());
			out.print("<br>");
			out.println("Book Publisher Name : "+updatebook.getPublisher());
			out.print("<br>");
			
		out.println("</html>");
		out.println("</body>");
}

}
