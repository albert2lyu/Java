package com.lanbots.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilterServlet
 */
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>This is FirstFilter!</title></head>");
		out.println("<body>");
		out.println("<p>访问原为：" + request.getAttribute("URI") + "</p>");
		out.println("<p>发起请求的IP为：" + request.getAttribute("RAddress") + "</p>");
		out.println("<p>发起请求计算机名为：" + request.getAttribute("RHost") + "</p>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
