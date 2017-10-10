package com.netease.course.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author menglanyingfei
 * @date 2017-8-25
 */

// 声明一个Bean的id
@Component("fileWriterService")
public class FileWriterServiceImpl implements FileWriterService {

	// 通过配置文件获取参数，注入到FileWirterServiceImpl中
	@Value("${filePath}")
	private File file;

	private FileWriter fw;

	// 创建时调用，打开一个文件，获取输出流
	@PostConstruct
	public void init() {
		try {
			// 判断文件是否存在，若不存在则创建文件
			if (!file.exists()) {
				file.createNewFile();
			}
			// 打开文件
			fw = new FileWriter(file, true);
			System.out.println("打开文件");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String content) {
		try {
			// 向文件中写入内容，并换行
			fw.write(content + "\n");
			System.out.println("文件写入:" + content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 销毁前调用，关闭文件输出流，释放文件
	@PreDestroy
	public void destory() {
		try {
			// 关闭文件的输出流
			if (fw != null) {
				fw.flush();
				fw.close();
			}
			System.out.println("关闭文件");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
