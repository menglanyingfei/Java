package org.lxy.utils;

import java.io.File;
import java.util.UUID;

/**
 * @author menglanyingfei
 * @date 2017-5-21
 */
@SuppressWarnings("all")
public class FileUploadUtils {
	// 得到上传文件真实名称
	public static String getRealName(String filename) {

		int index = filename.lastIndexOf("\\") + 1;

		return filename.substring(index);
	}

	// 得到随机名称
	public static String getUUIDFileName(String filename) {

		int index = filename.lastIndexOf(".");
		if (index != -1) {
			return UUID.randomUUID() + filename.substring(index);
		} else {
			return UUID.randomUUID().toString();
		}
	}

	// 目录分离算法
	public static String getRandomDirectory(String filename) {
		int hashcode = filename.hashCode();

		// System.out.println(hashcode);
		// // int类型数据在内存中占32位. 转换成16进制数, 就得到8个16进制数
		// String hex = Integer.toHexString(hashcode);
		// //System.out.println(hex);
		//
		// return "/" + hex.charAt(0) + "/" + hex.charAt(1);

		System.out.println(Integer.toBinaryString(hashcode));

		int a = hashcode & 0xf;
		hashcode = hashcode >>> 4;
		int b = hashcode & 0xf;
		return "/" + a + "/" + b;
	}

	public static void main(String[] args) {
		String path = getRandomDirectory("a.txt");

		File file = new File("f:/repository/JavaWeb/upload");
		File directory = new File(file, path);

		if (!directory.exists()) {
			directory.mkdirs();
		}
	}
}
