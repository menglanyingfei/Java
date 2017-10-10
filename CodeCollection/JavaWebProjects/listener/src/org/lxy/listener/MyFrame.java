package org.lxy.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class MyFrame extends JFrame {
	/**
	 * 事件是ActionEvent
	 */
	private static final long serialVersionUID = -3596610197729793609L;

	// 事件源
	private JButton but = new JButton("按钮");
	public MyFrame() {
		this.getContentPane().add(but);
		
		// 注册监听
		but.addActionListener(new ButListener());
		
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}

// 监听器
class ButListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("hello world");
	}
	
}

















