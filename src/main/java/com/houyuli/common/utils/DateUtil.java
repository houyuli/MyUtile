package com.houyuli.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 返回date 指定时间减去天数
	 * 
	 * @Title: SubDate
	 * @Description: TODO
	 * @param date
	 * @param hours
	 * @return
	 * @return: Date
	 */
	public static Date SubDate(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);// 用传入的日期再次初始化日历类
		c.add(Calendar.DAY_OF_MONTH, days);//减去指定的小时
		return c.getTime();
	}

	/**
	 * 根据日期计算年龄
	 * 
	 * @Title: getAgeByBirthday
	 * @Description: TODO
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int getAgeByBirthday(Date birthday) {

		// 1获取系统当前年 月 日
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowMonth = c.get(Calendar.MONTH);
		int nowDate = c.get(Calendar.DAY_OF_MONTH);
		// 2获取传入日期的生日的年 月 日
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		int birthdayYear = c2.get(Calendar.YEAR);
		int birthdayMonth = c2.get(Calendar.MONTH);
		int birthdayDate = c2.get(Calendar.DAY_OF_MONTH);
		if (nowYear < birthdayYear)// 判断
			throw new RuntimeException("传入的日期错误");
		// 4.两个年份向减 得到年龄 2000-04-01
		int age = nowYear - birthdayYear;
		// 没有到出生的月则年龄减去1
		if (nowMonth < birthdayMonth)
			age--;
		// 没有到出生日 年龄减去1
		if (nowMonth == birthdayMonth && nowDate < birthdayDate)
			age--;
		return age;

	}

	/**
	 * 根据传入的日期返回日期的月初。如传入 2020-04-24 ，返回 2020-04-01 00:00:00
	 * 
	 * @Title: getInitMonth
	 * @Description: TODO
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date) {
		// Calendar 是一个日历类。提供 设置日期，加减日期等方法，方便程序员对日期做计算
		Calendar c = Calendar.getInstance();// 初始化一个日历类
		// 用传入的日期初始化日历类
		c.setTime(date);
		// 设置这个月月初即：改变这个月的日期为第一天
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置天为1
		c.set(Calendar.HOUR_OF_DAY, 0);// 设置小时为0
		c.set(Calendar.MINUTE, 0);// 设置分钟为0
		c.set(Calendar.SECOND, 0);// 设置秒为0
		return c.getTime();

	}

	/**
	 * 根据传入的日期返回日期的月初。如传入 2020-04-24 ，返回 2020-04-30 23:59:59
	 * 
	 * @Title: getEndMonth
	 * @Description: TODO
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		// Calendar 是一个日历类。提供 设置日期，加减日期等方法，方便程序员对日期做计算
		Calendar c = Calendar.getInstance();// 初始化一个日历类
		// 用传入的日期初始化日历类
		c.setTime(date);
		// 让月加1 2020-05-24 ， 再变成月初 2020-05-01 再 减去一秒，再获取日期
		c.add(Calendar.MONTH, 1); // 让月加1 2020-05-24
		Date nexMonthInit = getInitMonth(c.getTime());// 再变成月初 2020-05-01
		// 初始化日历类
		c.setTime(nexMonthInit);
		c.add(Calendar.SECOND, -1);// 再 减去一秒
		return c.getTime();

	}

	/**
	 * 随机产生一个min 和max之间的日期
	 * 
	 * @Title: random
	 * @Description: TODO
	 * @param min
	 * @param max
	 * @return
	 * @return: Date
	 */
	public static Date random(Date min, Date max) {
		long t1 = min.getTime();
		long t2 = max.getTime();

		long t = (long) (Math.random() * (t2 - t1) + t1);
		return new Date(t);

	}
	/**
	 * 人性化时间  例如 几年前 几月前  几分钟前  刚刚
	 * @Title: getDisplayTime 
	 * @Description: TODO
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String getDisplayTime(Date date) {
		long t1 = date.getTime();
		long t2 = new Date().getTime();
		long t3 = t2 - t1;
		if(t3 < 0) {
			return "未来";
		}
		long minute = t3/60/1000;//获取分钟
		 if(minute/60/24/30/12>=1) {
			   return minute/60/24/30/12+"年前";
		   }else if(minute/60/24/30>=1) {
			   return minute/60/24/30+"月前";
		   }else if(minute/60/24>=1) {
			   return minute/60/24+"天前";
		   }else if(minute/60>=1) {
			   return minute/60+"小时前";
		   }else if(minute>5) {
			   return minute+"分钟前";
		   }else {
			   return "刚刚"; 
		   }
	}
	/**
	 * 获取季节  1-3春  4-6夏 7-9秋 10-12冬
	 * @Title: getCurrentSeason 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public static String getCurrentSeason() {
		   Calendar c = Calendar.getInstance();
		   int month = c.get(Calendar.MONTH) +1; 
		   if(month<7) {
			   if(month<4) {
				   return "春季";
			   }
			   return "夏季";
		   }else {
			   if(month<10) {
				   return "秋季";
			   }
			   return "冬季"; 
		   }
		   
	}
}
