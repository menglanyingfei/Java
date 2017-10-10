package kechengbiao;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class KCB {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTable table = new JTable(new KCBData());
		JScrollPane pane = new JScrollPane(table);
		frame.add(pane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
