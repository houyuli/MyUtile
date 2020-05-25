package com.houyuli.common.utils;

public class WebUtil {

	public static String getUrl(HttpServletRequest request, String... ignoreParams) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath() // 应用名称，如果应用名称为
				+ request.getServletPath() // 请求的相对url
				+ (!StringUtil.hasText(request.getQueryString()) ? "" : ("?" + request.getQueryString())); // 请求参数
		return requestUrl;

	}
}