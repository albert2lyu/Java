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
	 * 初始化
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

	/**
	 * 过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		if (filterConfig == null) {
			throw new ServletException("FilterConfig not set before first request");
		}
		// 日志输出
		filterConfig.getServletContext().log("in FirstFilter");
		System.out.println("in FirstFilter");

		long startTime = System.currentTimeMillis(); // 获取系统时间
		String remoteAddess = request.getRemoteAddr(); // 获取计算机地址
		String remoteHost = request.getRemoteHost(); // 获取计算机名
		// 把父类(ServletRequest)request转成子类(HttpServletRequest)
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
	 * 销毁
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
