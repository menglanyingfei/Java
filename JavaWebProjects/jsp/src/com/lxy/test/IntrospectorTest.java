package com.lxy.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.lxy.vo.User;

/**
 * @author menglanyingfei
 * @date 2017-2-6
 */
public class IntrospectorTest {

	@Test
	public void run() throws Exception {
		User user = new User();
		// 获取类的信息
		BeanInfo info = Introspector.getBeanInfo(user.getClass());
		// 获取属性的描述
		PropertyDescriptor [] pds = info.getPropertyDescriptors();
		// 循环遍历，获取属性的名称
		for (PropertyDescriptor pd : pds) {
			//System.out.println(pd.getName());
			if (!"class".equals(pd.getName())) {
				// 获取写的方法
				Method m = pd.getWriteMethod();
				m.invoke(user, "admin");
			}
		}
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
	} 

}
