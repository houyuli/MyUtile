package com.houyuli.common.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;

/**
 * �������������
 * 
 * @ClassName: RandomUtil
 * @Description: TODO
 * @author: King
 * @date: 2020��5��22�� ����9:29:55
 */
public class RandomUtil {

	// ����1������min-max֮����������������min��maxֵ�������緵��1-3֮������������ô����1��2��3������ȷ�ģ�����4�Ͳ��ԡ� (5��)
	public static int random(int min, int max) {
		if (max <= min) {
			throw new RuntimeException("��������ȷ��ֵ");
		}
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	// ����2������Сֵmin�����ֵmax֮���ȡsubs�����ظ����������������1-10֮��ȡ3�����ظ������������ô[2,6,9]�ǶԵģ�[3,5,5]�򲻶ԣ���Ϊ5�ظ��ˡ�Ӧ�ó�������100ƪ���������ȡ10ƪ���£��¿����ܻ�ʹ�õ���
	public static int[] subRandom(int min, int max, int subs) {
		int[] result = new int[subs];
		HashSet<Integer> set = new HashSet<>();
		while (set.size() != subs) {
			set.add(random(min, max));
		}
//		for (Integer m : set) {
//			System.out.println(m);
//		}
		int i = 0;
		for (Integer n : set) {
			result[i] = n;
			i++;
		}
		return result;
	}

	// ����3������1��1-9,a-Z֮�������ַ��� (8��)
	public static char randomCharacter() {
		String str = "123456789zxcvbnmasdfghjklqwertyuiop";
		return str.charAt(random(0, str.length() - 1));
	}

	// ����4�����ز���length���ַ���(5��)�������ڲ�Ҫ����randomCharacter()���� (4��)
	public static String randomString(int length) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			buf.append(randomCharacter());
		}
		return buf.toString();
	}
	
}
