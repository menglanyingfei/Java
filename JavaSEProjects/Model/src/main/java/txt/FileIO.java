package txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author menglanyingfei
 * @date 2017-8-31
 */
public class FileIO {
	public static void main(String[] args) {
		try {
			String encoding = "GBK"; // 字符编码(可解决中文乱码问题 )
			File file = new File("data.txt");
//			String regEx="[^0-9]";
			String regEx= "[^0-9.]";
			Pattern p = Pattern.compile(regEx);
			
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTXT = null;
				while ((lineTXT = bufferedReader.readLine()) != null) {
					Matcher m = p.matcher(lineTXT);
					System.out.println(m.replaceAll(" ").trim());
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件！");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容操作出错");
			e.printStackTrace();
		}
	}

}
