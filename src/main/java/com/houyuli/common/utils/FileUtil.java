package com.houyuli.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileUtil {

	/**
	 * 功能：获取操作用户当前目录。
	 *
	 * @return 操作系统用户目录
	 */
	public static File getUserDir() {

		return new File(System.getProperty("user.dir"));

	}

	/**
	 * 功能：获取操作系统用户目录。
	 *
	 * @return 操作系统用户目录
	 */
	public static File getUserHomeDir() {
		return new File(System.getProperty("user.home"));
	}

	/**
	 * 功能：获取操作系统临时目录。
	 *
	 * @return 操作系统临时目录
	 */
	public static File getTmpDir() {

		return new File(System.getProperty("java.io.tmpdir"));
	}

	/**
	 * 功能：获取一个文件的根目录 举例：d:\temp\2020\04\abc.jpg → 1
	 *
	 * @param File file 文件名
	 * @return 该文件的根目录
	 */
	public static File getRoot(File file) {
		String path = file.getPath();// 获取文件的路径名
		return new File(path.substring(0, path.indexOf(":") + 1));
	}

	/**
	 * 功能：获取文件扩展名 示例：a.jpeg → .jpg
	 *
	 * @param String fileName 文件名
	 * @return 带点的扩展名
	 */
	public static String getFileExtensions(String fileName) {
		if (!StringUtil.hasText(fileName))
			return "文件名不能为空";
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 功能：获取对应单位的文件大小 示例：a.jpg文件原始大小是1275个字节，如果参数单位是k，则返回2K，如果m，则返回0M
	 *
	 * @param File         file 文件
	 * @param FileSizeUnit unit 单位，如K、M、G、T
	 * @return 对应单位的文件大小
	 */
	public static long getFileSize(File file, FileSizeEnum unit) {

		return file.length() / unit.getCode();

	}

	/**
	 * 功能：获取某文件所在磁盘的总空间 示例：如果传了d:\temp\a.jpg文件，能计算出d盘的总空间
	 *
	 * @param File         file 文件
	 * @param FileSizeUnit unit 单位，如K、M、G、T
	 * @return 对应单位的文件大小
	 */
	public static long getTotalSpace(File file, FileSizeEnum unit) {
		// 1.获取文件所在的磁盘
		File f = getRoot(file);

		return f.getTotalSpace() / unit.getCode();
	}

	/**
	 * 功能：获取磁盘的总空间
	 *
	 * @param FileSizeUnit unit 单位，如K、M、G、T
	 * @return 对应单位的文件大小
	 */
	public static long getRootTotalSpace(FileSizeEnum unit) {

		return 0;
		// TODO 实现代码
	}

	/**
	 * 功能：获取磁盘的总空间
	 *
	 * @param FileSizeUnit unit 单位，如K、M、G、T
	 * @return 磁盘的可用空间大小
	 */
	public static long getFreeSpace(File file, FileSizeEnum unit) {

		return file.getFreeSpace() / unit.getCode();

	}

	/**
	 * 功能：递归删除文件，如果是目录，则目录下所有的文件和子目录都删除。
	 *
	 * @param File file 文件或文件夹
	 */
	public static void deletes(File f) {

		File[] b = f.listFiles();// 获取包含file对象对应的子目录或者文件
		for (int i = 0; b != null && i < b.length; i++) {
			if (b[i].isFile()) {// 判断是否为文件
				b[i].delete();// 如果是就删除
			} else {
				deletes(b[i]);// 否则重新递归到方法中
			}
		}
		f.delete();// 最后删除该目录中所有文件后就删除该目录
	}

	/**
	 * 向一个文件中写入信息
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
