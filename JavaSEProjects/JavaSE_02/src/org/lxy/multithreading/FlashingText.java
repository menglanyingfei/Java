package org.lxy.multithreading;

import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 * @author menglanyingfei
 * @date 2017-5-24
 */
public class FlashingText extends JApplet implements Runnable {

	private static final long serialVersionUID = -2236369460948414230L;

	private JLabel jlblText = new JLabel("Welcome", JLabel.CENTER);

	public FlashingText() {
		add(jlblText);
		new Thread(this).start();
	}

	/** Set the text on/off every 1000 milliseconds */
	@Override
	public void run() {
		try {
			while (true) {
				if (jlblText.getText() == null) {
					jlblText.setText("Welcome");
				} else {
					jlblText.setText(null);
				}
				Thread.sleep(1000);
			} 
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
