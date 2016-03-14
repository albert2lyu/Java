package com.lanbots.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilstFilter
 */
@WebFilter("/FilstFilter")
public class FirstFilter extends HttpServlet implements Filter {

	private FilterConfig filterConfig;

	/**
	 * ��ʼ��
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

	/**
	 * ����
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		if (filterConfig == null) {
			throw new ServletException("FilterConfig not set before first request");
		}
		// ��־���
		filterConfig.getServletContext().log("in FirstFilter");
		System.out.println("in FirstFilter");

		long startTime = System.currentTimeMillis(); // ��ȡϵͳʱ��
		String remoteAddess = request.getRemoteAddr(); // ��ȡ�������ַ
		String remoteHost = request.getRemoteHost(); // ��ȡ�������
		// �Ѹ���(ServletRequest)requestת������(HttpServletRequest)
		HttpServletRequest myReq = (HttpServletRequest) request;
		String reqURI = myReq.getRequestURI();

		System.out.println(reqURI);

		try {
			request.setAttribute("URI", reqURI);
			request.setAttribute("RAddress", remoteAddess);
			request.setAttribute("RHost", remoteHost);
			chain.doFilter(request, response);
		} catch (ServletException se) {
			filterConfig.getServletContext().log(se.getMessage());
		} catch (IOException ie) {
			filterConfig.getServletContext().log(ie.getMessage());
		}

	}

	/**
	 * ����
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
