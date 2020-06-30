package com.houyuli.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileUtil {

	/**
	 * ���ܣ���ȡ�����û���ǰĿ¼��
	 *
	 * @return ����ϵͳ�û�Ŀ¼
	 */
	public static File getUserDir() {

		return new File(System.getProperty("user.dir"));

	}

	/**
	 * ���ܣ���ȡ����ϵͳ�û�Ŀ¼��
	 *
	 * @return ����ϵͳ�û�Ŀ¼
	 */
	public static File getUserHomeDir() {
		return new File(System.getProperty("user.home"));
	}

	/**
	 * ���ܣ���ȡ����ϵͳ��ʱĿ¼��
	 *
	 * @return ����ϵͳ��ʱĿ¼
	 */
	public static File getTmpDir() {

		return new File(System.getProperty("java.io.tmpdir"));
	}

	/**
	 * ���ܣ���ȡһ���ļ��ĸ�Ŀ¼ ������d:\temp\2020\04\abc.jpg �� 1
	 *
	 * @param File file �ļ���
	 * @return ���ļ��ĸ�Ŀ¼
	 */
	public static File getRoot(File file) {
		String path = file.getPath();// ��ȡ�ļ���·����
		return new File(path.substring(0, path.indexOf(":") + 1));
	}

	/**
	 * ���ܣ���ȡ�ļ���չ�� ʾ����a.jpeg �� .jpg
	 *
	 * @param String fileName �ļ���
	 * @return �������չ��
	 */
	public static String getFileExtensions(String fileName) {
		if (!StringUtil.hasText(fileName))
			return "�ļ�������Ϊ��";
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * ���ܣ���ȡ��Ӧ��λ���ļ���С ʾ����a.jpg�ļ�ԭʼ��С��1275���ֽڣ����������λ��k���򷵻�2K�����m���򷵻�0M
	 *
	 * @param File         file �ļ�
	 * @param FileSizeUnit unit ��λ����K��M��G��T
	 * @return ��Ӧ��λ���ļ���С
	 */
	public static long getFileSize(File file, FileSizeEnum unit) {

		return file.length() / unit.getCode();

	}

	/**
	 * ���ܣ���ȡĳ�ļ����ڴ��̵��ܿռ� ʾ�����������d:\temp\a.jpg�ļ����ܼ����d�̵��ܿռ�
	 *
	 * @param File         file �ļ�
	 * @param FileSizeUnit unit ��λ����K��M��G��T
	 * @return ��Ӧ��λ���ļ���С
	 */
	public static long getTotalSpace(File file, FileSizeEnum unit) {
		// 1.��ȡ�ļ����ڵĴ���
		File f = getRoot(file);

		return f.getTotalSpace() / unit.getCode();
	}

	/**
	 * ���ܣ���ȡ���̵��ܿռ�
	 *
	 * @param FileSizeUnit unit ��λ����K��M��G��T
	 * @return ��Ӧ��λ���ļ���С
	 */
	public static long getRootTotalSpace(FileSizeEnum unit) {

		return 0;
		// TODO ʵ�ִ���
	}

	/**
	 * ���ܣ���ȡ���̵��ܿռ�
	 *
	 * @param FileSizeUnit unit ��λ����K��M��G��T
	 * @return ���̵Ŀ��ÿռ��С
	 */
	public static long getFreeSpace(File file, FileSizeEnum unit) {

		return file.getFreeSpace() / unit.getCode();

	}

	/**
	 * ���ܣ��ݹ�ɾ���ļ��������Ŀ¼����Ŀ¼�����е��ļ�����Ŀ¼��ɾ����
	 *
	 * @param File file �ļ����ļ���
	 */
	public static void deletes(File f) {

		File[] b = f.listFiles();// ��ȡ����file�����Ӧ����Ŀ¼�����ļ�
		for (int i = 0; b != null && i < b.length; i++) {
			if (b[i].isFile()) {// �ж��Ƿ�Ϊ�ļ�
				b[i].delete();// ����Ǿ�ɾ��
			} else {
				deletes(b[i]);// �������µݹ鵽������
			}
		}
		f.delete();// ���ɾ����Ŀ¼�������ļ����ɾ����Ŀ¼
	}

	/**
	 * ��һ���ļ���д����Ϣ
	 * 
	 * @Title: writeToFile
	 * @Description: TODO
	 * @param path
	 * @param content
	 * @param charset
	 * @throws Exception
	 * @return: void
	 */
	public static void writeToFile(String path, String content, String charset) throws Exception {
		File file = new File(path);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}
}
