package com.houyuli.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	// 关闭流
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

	/**
	 * @Title: readTextFile
	 * @Description: 传入一个文本文件对西昂,返回该文件内容
	 * @param src
	 * @return
	 * @return: String
	 */
	public static String readTextFile(InputStream src) {
		byte[] b = new byte[1024];
		int len;
		String str = "";
		try {
			while ((len = src.read(b)) != -1) {
				str += new String(b, 0, len, "UTF-8");
				//return new String(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * @Title: readTextFile
	 * @Description: 传入文本文件对象，返回该文件内容 并且调用readTextFile方法
	 * @param txtFile
	 * @return
	 * @return: String
	 */
	public static String readTextFile(File txtFile) {
		try {
			return readTextFile(new FileInputStream(txtFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
