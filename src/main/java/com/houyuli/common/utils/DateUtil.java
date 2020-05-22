package com.houyuli.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
//
//	/**
//	 * @Title: random 
//	 * @Description: ��ȡһ��min��max�м���������
//	 * @param min
//	 * @param max
//	 * @return
//	 * @return: Date
//	 */
//	public static Date random(Date min,Date max) {
//		long t1 = min.getTime();
//		long t2 = max.getTime();
//		long t = (long) (Math.random() * (t2 - t1) + t1);
//		return new Date(t);
//	}
//	/**
//	 * @Title: getInitMonth 
//	 * @Description: ��ȡһ���µĵ�һ��
//	 * @param date
//	 * @return˼·:Calendar����һ��������ֵ���ĵķ���  �ĳ�1����
//	 * @return: Date
//	 */
//	public static Date getInitMonth(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.DAY_OF_MONTH, 1);
//		//System.out.println(c.getTime());
//		return c.getTime();
//	}
//	/**
//	 * @Title: getEndMonth 
//	 * @Description: ��ȡ����µ����һ��
//	 * @param date
//	 * ˼·��:��ȡ����µ�һ��Ȼ���ټ�һ���ٽ�Сʱ���Ӷ�setΪ0
//	 * @return: Date
//	 */
//	public static Date getEndMonth(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.add(Calendar.MONTH, 1);
//		Date initMonth = DateUtil.getInitMonth(c.getTime());
//		c.setTime(initMonth);
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		c.add(Calendar.SECOND, -1);
//		return c.getTime();
//	}
	/**
	 * ����date ��ȥָ��Сʱ��ʱ��
	 * 
	 * @Title: SubDate
	 * @Description: TODO
	 * @param date
	 * @param hours
	 * @return
	 * @return: Date
	 */
	public static Date SubDate(Date date, int hours) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);// �ô���������ٴγ�ʼ��������
		c.add(Calendar.HOUR_OF_DAY, -hours);// ��ȥָ����Сʱ
		return c.getTime();
	}

	/**
	 * �������ڼ�������
	 * 
	 * @Title: getAgeByBirthday
	 * @Description: TODO
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int getAgeByBirthday(Date birthday) {

		// 1��ȡϵͳ��ǰ�� �� ��
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowMonth = c.get(Calendar.MONTH);
		int nowDate = c.get(Calendar.DAY_OF_MONTH);
		// 2��ȡ�������ڵ����յ��� �� ��
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		int birthdayYear = c2.get(Calendar.YEAR);
		int birthdayMonth = c2.get(Calendar.MONTH);
		int birthdayDate = c2.get(Calendar.DAY_OF_MONTH);
		if (nowYear < birthdayYear)// �ж�
			throw new RuntimeException("��������ڴ���");
		// 4.���������� �õ����� 2000-04-01
		int age = nowYear - birthdayYear;
		// û�е����������������ȥ1
		if (nowMonth < birthdayMonth)
			age--;
		// û�е������� �����ȥ1
		if (nowMonth == birthdayMonth && nowDate < birthdayDate)
			age--;
		return age;

	}

	/**
	 * ���ݴ�������ڷ������ڵ��³����紫�� 2020-04-24 ������ 2020-04-01 00:00:00
	 * 
	 * @Title: getInitMonth
	 * @Description: TODO
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date) {
		// Calendar ��һ�������ࡣ�ṩ �������ڣ��Ӽ����ڵȷ������������Ա������������
		Calendar c = Calendar.getInstance();// ��ʼ��һ��������
		// �ô�������ڳ�ʼ��������
		c.setTime(date);
		// ����������³������ı�����µ�����Ϊ��һ��
		c.set(Calendar.DAY_OF_MONTH, 1);// ������Ϊ1
		c.set(Calendar.HOUR_OF_DAY, 0);// ����СʱΪ0
		c.set(Calendar.MINUTE, 0);// ���÷���Ϊ0
		c.set(Calendar.SECOND, 0);// ������Ϊ0
		return c.getTime();

	}

	/**
	 * ���ݴ�������ڷ������ڵ��³����紫�� 2020-04-24 ������ 2020-04-30 23:59:59
	 * 
	 * @Title: getEndMonth
	 * @Description: TODO
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		// Calendar ��һ�������ࡣ�ṩ �������ڣ��Ӽ����ڵȷ������������Ա������������
		Calendar c = Calendar.getInstance();// ��ʼ��һ��������
		// �ô�������ڳ�ʼ��������
		c.setTime(date);
		// ���¼�1 2020-05-24 �� �ٱ���³� 2020-05-01 �� ��ȥһ�룬�ٻ�ȡ����
		c.add(Calendar.MONTH, 1); // ���¼�1 2020-05-24
		Date nexMonthInit = getInitMonth(c.getTime());// �ٱ���³� 2020-05-01
		// ��ʼ��������
		c.setTime(nexMonthInit);
		c.add(Calendar.SECOND, -1);// �� ��ȥһ��
		return c.getTime();

	}

	/**
	 * �������һ��min ��max֮�������
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
}
