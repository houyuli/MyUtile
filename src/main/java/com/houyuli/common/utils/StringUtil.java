package com.houyuli.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * �ַ�������������
 * @ClassName: StringUtil 
 * @Description: TODO
 * @author: King
 * @date: 2020��5��22�� ����9:29:46
 */
public class StringUtil {

	//����1���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)Ҳ��ûֵ (5��)
	public static boolean hasLength(String src){
		return null != src && src.length() > 0;
	}
	//����2���ж�Դ�ַ���	
	public static boolean hasText(String src){
		return null != src && src.trim().length() > 0;
	}
	//����һ�����ĺ����ַ�
	public static String randomChineseString(){
		String str = null;
		int highPos,lowPos;
		Random random = new Random();
		highPos = (176 + random.nextInt(40));
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));
		byte[] bArr = new byte[2];
		 
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr,"GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	//����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length){
		StringBuffer buf = new StringBuffer();
		for(int i = 1;i <= length;i++) {
			buf.append(randomChineseString());
		}
		return buf.toString();
	}
	//����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
	public static String generateChineseName(){
		String[] arr = {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʩ","��","��","��","��","��","��","κ","��","��","��","л","��","��","��","ˮ","�","��","��","��","��","��","��","��","��","��","³","Τ","��","��","��","��","��","��","��","��","Ԭ","��","ۺ","��","ʷ","��","��","��","�","Ѧ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ʱ","��","Ƥ","��","��","��","��","��","Ԫ","��","��","��","ƽ","��","��","��","��","��","Ҧ","��","տ","��","��","ë","��","��","��","��","��","�","��","��","��","��","̸","��","é","��","��","��","��","��","��","ף","��","��","��","��","��","��","ϯ","��","��","ǿ","��","·","¦","Σ","��","ͯ","��","��","÷","ʢ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","֧","��","��","��","¬","Ī","��","��","��","��","��","��","Ӧ","��","��","��","��","��","��","��","��","��","��","��","��","ʯ","��","��","ť","��","��","��","��","��","��","½","��","��","��","��","�","��","��","�L","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ɽ","��","��","��","�","��","ȫ","ۭ","��","��","��","��","��","��","��","��","��","��","��","б","��","��","��","��","��","��","��","ղ","��","��","Ҷ","��","˾","��","۬","��","��","��","ӡ","��","��","��","��","ۢ","��","��","��","��","��","��","׿","��","��","��","��","��","��","��","��","��","��","˫","��","ݷ","��","��","̷","��","��","��","��","��","��","��","Ƚ","��","۪","Ӻ","�S","�","ɣ","��","�","ţ","��","ͨ","��","��","��","��","ۣ","��","��","ũ","��","��","ׯ","��","��","��","��","��","Ľ","��","��","ϰ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","»","��","��","ŷ","�","��","��","ε","Խ","��","¡","ʦ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ɳ","ؿ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","Ȩ","��","��","��","��","��","��","��","��","��","��","۳","Ϳ","��","��","˧","��","��","��","��","��","��","��","Ĳ","��","٦","��","��","ī","��","��","��","��","��","��","١","��ٹ","˾��","�Ϲ�","ŷ��","�ĺ�","���","����","����","����","�ʸ�","ξ��","����","�̨","��ұ","����","���","����","����","̫��","����","����","����","��ԯ","���","����","����","����","Ľ��","����","����","˾ͽ","˾��","آ��","˾��","��","��","�ӳ�","���","��ľ","����","����","���","����","����","����","�ذ�","�й�","�׸�","����","�θ�","����","����","����","����","��","��","����","΢��","����","����","����","����","�Ϲ�"};
		String str = arr[RandomUtil.random(0, arr.length-1)];
		String str1 = randomChineseString(RandomUtil.random(0, 2));
		return str + str1;
	}
	//�ж��Ƿ�Ϊ����
	public static boolean isNumber(String str) {
		String reg = "^(-)?[0-9]+(\\.[0-9]+)?$";
		return str.matches(reg);
	}
	//�ж��Ƿ����й��ֻ���
	public static boolean isPhone(String str) {
		String reg = "^[1][3|5|7|8]\\d{9}$";
		return str.matches(reg);
	}
	//�ж��Ƿ�Ϊ����
	public static boolean isEmail(String str) {
		String reg = "\\w+\\@\\w+\\.\\w+";
		return str.matches(reg);
	}
	//�ж�ȫ����ĸ
	public static boolean isEnglish(String str) {
		String reg = "[a-zA-Z]+";
		return str.matches(reg);
	}
	/**
	 * �ַ�����������length��ʹ��...��ʾ
	 * @Title: ellipsis 
	 * @Description: TODO
	 * @param str
	 * @param length
	 * @return
	 * @return: String
	 */
	public String ellipsis(String str,Integer length) {
		if(! StringUtil.hasText(str)) {
			return "��һ����������Ϊ��";
		}
		return str.substring(0,length)+"...";
	}
	/**
	* ����һ�����ַ���  ����绰���� ����֤�� 136****4589
	 * @Title: hiddenStr 
	 * @Description: TODO
	 * @param str Դ�ַ���
	 * @param start ����λ�ÿ�ʼ�±�
	 * @param end �Ʋ�λ�ý����±�
	 * @return
	 * @return: String
	 */
	public static String hiddenStr(String str,Integer start,Integer end) {
		if(! StringUtil.hasText(str)) {
			return "��һ����������Ϊ��";
		}
		if(start > end) {
			return "��ʼ�±겻�ܴ��ڽ����±�";
		}
		if(end > str.length()) {
			return "�����±겻�ܴ����ַ�������";
		}
		String str1 = str.substring(start,end);
		String str2 = "";
		for(int i = 0;i < str1.length();i++) {
			str2 += "*";
		}
		return str.replaceFirst(str1, str2);
	}
	/**
	 * ��ת�ַ���
	 * @Title: reverse 
	 * @Description: TODO
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String reverse(String str) {
		if(! StringUtil.hasText(str)) {
			return "����Ϊ��";
		}
		return new StringBuffer(str).reverse().toString();
	}
}
