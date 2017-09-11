package com.common;

import javax.servlet.ServletContext;

public class ServletContextHolder {
	private static ServletContext servletContext;

	public static void setServletContext(ServletContext servletContext) {
		ServletContextHolder.servletContext = servletContext;
	}

	public static ServletContext getServletContext() {
		checkServletContext();
		return servletContext;
	}

	public static String getAppPath() {
		return getServletContext().getRealPath("/");
	}

	/**
	 * 清除servletContext静态变量.
	 */
	public static void cleanServletContext() {
		servletContext = null;
	}

	public static boolean isContextReady() {
		return servletContext != null;
	}

	private static void checkServletContext() {
		if (servletContext == null) {
			throw new IllegalStateException("servletContext未设置");
		}
	}
}
