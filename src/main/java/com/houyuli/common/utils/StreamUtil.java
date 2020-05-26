package com.houyuli.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	//关闭流
	public static void closings(AutoCloseable... closeables) {
		if (closeables == null || closeables.length == 0)
			throw new RuntimeException("参数异常");

		for (AutoCloseable autoCloseable : closeables) {
			try {
				autoCloseable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	//
	public static String asString(InputStream ins, boolean isClose) {
		byte[] b = new byte[1024];
		int len = -1;
		try {
			while ((len = ins.read(b)) != -1) {
				return new String(b, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isClose) {
				closings(ins);
			}
		}

		return null;
	}

	@SuppressWarnings("resource")
	public static List<String> readingLineFormTextFile(File textFile) throws IOException {
		return readingLineFormTextFile(new FileInputStream(textFile));

	}
	
	//按照行读取 返回一个list集合
	public static List<String> readingLineFormTextFile(InputStream inputStream) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		ArrayList<String> list = new ArrayList<String>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			list.add(line);
		}
		return list;

	}
}
