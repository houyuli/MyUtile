package com.houyuli.common.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;

/**
 * 随机数处理工具类
 * 
 * @ClassName: RandomUtil
 * @Description: TODO
 * @author: King
 * @date: 2020年5月22日 下午9:29:55
 */
public class RandomUtil {

	// 方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min, int max) {
		if (max <= min) {
			throw new RuntimeException("请输入正确的值");
		}
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	// 方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。
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

	// 方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter() {
		String str = "123456789zxcvbnmasdfghjklqwertyuiop";
		return str.charAt(random(0, str.length() - 1));
	}

	// 方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			buf.append(randomCharacter());
		}
		return buf.toString();
	}
	
}
