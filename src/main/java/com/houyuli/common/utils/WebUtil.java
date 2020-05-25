package com.houyuli.common.utils;

public class WebUtil {

	public static String getUrl(HttpServletRequest request, String... ignoreParams) {
		String requestUrl = request.getScheme() // ��ǰ����ʹ�õ�Э��
				+ "://" + request.getServerName()// ��������ַ
				+ ":" + request.getServerPort() // �˿ں�
				+ request.getContextPath() // Ӧ�����ƣ����Ӧ������Ϊ
				+ request.getServletPath() // ��������url
				+ (!StringUtil.hasText(request.getQueryString()) ? "" : ("?" + request.getQueryString())); // �������
		return requestUrl;

	}
}