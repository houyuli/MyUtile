package com.houyuli.common.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberUtil {
	private static String NUMBER_REGEX = "[0-9]+";// ����
	private static String Real_REGEX = "^(-)?[0-9]+(\\.[0-9]+)?$";// ʵ��

	/**
	 * ���ܣ��ж��Ƿ�ȫ��Ϊʵ�� ʾ���� NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> false NumberUtil.isNUmber("06") -> true
	 * NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isReal(String src) {
		if (!StringUtil.hasText(src))
			return false;
		return src.matches(Real_REGEX);
	}

	/**
	 * ���ܣ��ж��Ƿ�ȫ��Ϊ���� ʾ���� NumberUtil.isNUmber("abc") -> false
	 * NumberUtil.isNUmber("5.6") -> false NumberUtil.isNUmber("06") -> true
	 * NumberUtil.isNUmber("1234") -> true
	 */
	public static boolean isNumber(String src) {
		if (!StringUtil.hasText(src))
			return false;
		return src.matches(NUMBER_REGEX);
	}

	/**
	 * �������������뾫ȷС�����scaleλ
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
	 * ��׼��������
	 * 
	 * @Title: div
	 * @Description: TODO
	 * @param v1    ����
	 * @param v2    ������
	 * @param scale С�����λ
	 * @return
	 * @return: double
	 */
	public static double div(double v1, double v2, int scale) {
		BigDecimal bd1 = new BigDecimal(String.valueOf(v1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(v2));
		return round(bd1.divide(bd2).doubleValue(), scale);
	}

	/**
	 * �˷�����
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
	 * ��������
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
	 * �ӷ�����
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
	// ��ȡָ����Χ��������
	public static int nextInt(int max, int min) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	/**
	 * ������ֵ�м��ȡ�����
	 * @Title: subIntegers 
	 * @Description: TODO
	 * @param min��Сֵ
	 * @param max���ֵ
	 * @param subLength ��ȡ����
	 * @return
	 * @return: int[]
	 */
	public static int[] subIntegers(int min, int max, int subLength) {
		int[] x = new int[subLength];
		Set<Integer> set = new HashSet<Integer>();// ����set�������������ظ�����
		while (set.size() < subLength) {
			set.add(nextInt(min, max));
		}
		int j = 0;
		for (Integer value : set) {// ����set����,��������
			x[j] = value;
			j++;
		}
		return x;
	}
}
