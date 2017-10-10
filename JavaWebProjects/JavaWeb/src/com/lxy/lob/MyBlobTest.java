package com.lxy.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.lxy.utils.JdbcUtils;

/**
 * @author menglanyingfei
 * @date 2017-4-29
 */
public class MyBlobTest {
	
	@Test
	public void save() throws SQLException, IOException {
		String sql = "insert into myblob values(null, ?)";
		
		// 1. 获取Connection
		Connection con = JdbcUtils.getConnection();
		// 2. 获取PreparedStatement
		PreparedStatement pst = con.prepareStatement(sql);
		// 3. 插入值
		File file = new File("F:\\我的文件夹\\学习\\学习笔记\\Java基础学习笔记\\7. IO\\装饰设计模式.PNG");
		FileInputStream fis = new FileInputStream(file);
		pst.setBinaryStream(1, fis, (int)(file.length()));
		int row = pst.executeUpdate();
		
		if (row != 0) {
			System.out.println("插入成功");
		}
		
		// 4. 释放资源
		fis.close();
		pst.close();
		con.close();
	}
}












