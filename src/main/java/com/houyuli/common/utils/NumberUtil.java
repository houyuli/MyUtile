package com.houyuli.common.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberUtil {
	private static String NUMBER_REGEX = "[0-9]+";// 数字
	private static String Real_REGEX = "^(-)?[0-9]+(\\.[0-9]+)?$";// 实数

	/**
	 * 功能：判断是否全部为实数 示例： NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> false NumberUtil.isNUmber("06") -> true
	 * NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isReal(String src) {
		if (!StringUtil.hasText(src))
			return false;
		return src.matches(Real_REGEX);
	}

	/**
	 * 功能：判断是否全部为数字 示例： NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> false NumberUtil.isNUmber("06") -> true
	 * NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isNumber(String src) {
		if (!StringUtil.hasText(src))
			return false;
		return src.matches(NUMBER_REGEX);
	}

	/**
	 * 将数字四舍五入精确小数点后scale位
	 * 
	 * @Title: round
	 * @Description: TODO
	 * @param v
	 * @param scale
	 * @return
	 * @return: double
	 */
	public static double round(double v, int scale) {
		BigDecimal bd = new BigDecimal(String.valueOf(v));
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 精准除法运算
	 * 
	 * @Title: div
	 * @Description: TODO
	 * @param v1    除数
	 * @param v2    被除数
	 * @param scale 小数点后几位
	 * @return
	 * @return: double
	 */
	public static double div(double v1, double v2, int scale) {
		BigDecimal bd1 = new BigDecimal(String.valueOf(v1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(v2));
		return round(bd1.divide(bd2).doubleValue(), scale);
	}

	/**
	 * 乘法运算
	 * 
	 * @Title: mul
	 * @Description: TODO
	 * @param v1
	 * @param v2
	 * @return
	 * @return: double
	 */
	public static double mul(double v1, double v2) {
		BigDecimal bd1 = new BigDecimal(String.valueOf(v1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(v2));
		return bd1.multiply(bd2).doubleValue();
	}

	/**
	 * 减法运算
	 * 
	 * @Title: sub
	 * @Description: TODO
	 * @param v1
	 * @param v2
	 * @return
	 * @return: double
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(String.valueOf(v1));
		BigDecimal b2 = new BigDecimal(String.valueOf(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 加法运算
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param v1
	 * @param v2
	 * @return
	 * @return: double
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(String.valueOf(v1));
		BigDecimal b2 = new BigDecimal(String.valueOf(v2));
		return b1.add(b2).doubleValue();
	}

	//
	// 获取指定范围最大的整数
	public static int nextInt(int max, int min) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	/**
	 * 在两个值中间截取随机数
	 * @Title: subIntegers 
	 * @Description: TODO
	 * @param min最小值
	 * @param max最大值
	 * @param subLength 获取个数
	 * @return
	 * @return: int[]
	 */
	public static int[] subIntegers(int min, int max, int subLength) {
		int[] x = new int[subLength];
		Set<Integer> set = new HashSet<Integer>();// 定义set集合用来过滤重复数据
		while (set.size() < subLength) {
			set.add(nextInt(min, max));
		}
		int j = 0;
		for (Integer value : set) {// 遍历set集合,放入数组
			x[j] = value;
			j++;
		}
		return x;
	}
}
