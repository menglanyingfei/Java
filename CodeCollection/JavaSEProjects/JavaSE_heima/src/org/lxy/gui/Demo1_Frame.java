package org.lxy.gui;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author menglanyingfei
 * @date 2017-4-17
 */
public class Demo1_Frame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame  f = new Frame("my window");
        f.setLayout(new FlowLayout());//设置布局管理器
        f.setSize(500,400);//设置窗体大小
        f.setLocation(300,200);//设置窗体出现在屏幕的位置
        f.setIconImage(Toolkit.getDefaultToolkit().createImage("dog.png"));
        
        //demo1(f);
        f.addWindowListener(new MyWindowAdapter());
        f.setVisible(true);
	}

	public static void demo1(Frame f) {
		// 窗体监听, 实现方法一: 匿名内部类
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	System.exit(0);//退出虚拟机,关闭窗口
            }
        });
	}
}

class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}


























