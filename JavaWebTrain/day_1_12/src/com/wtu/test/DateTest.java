package com.wtu.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试日期
 *
 * @Author menglanyingfei
 * @Created on 2018.01.12 13:12
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //System.out.println(new Date().toLocaleString());
    }
}
