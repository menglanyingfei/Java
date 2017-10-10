package com.hb.javacad.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JFrame;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ColorPanel extends javax.swing.JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton moreButton;
	private JButton forwardButton;
	private JButton blue;
	private JButton green;
	private JButton yellowButton;
	private JButton redButton;
	private JButton black;
	private JButton ziButton;
	private JButton grey;
	private JButton hardGreenButton;
	private JLabel selectedLabel;
	private JLabel colorLabel;
	private Color forwardColor = null;
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ColorPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ColorPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setLayout(null);
			{
				colorLabel = new JLabel();
				this.add(colorLabel);
				colorLabel.setText("\u8bf7\u9009\u8272:");
				colorLabel.setBounds(0, 0, 56, 21);
			}
			{
				hardGreenButton = new JButton();
				this.add(hardGreenButton);
				hardGreenButton.setBounds(0, 112, 28, 28);
				hardGreenButton.setBackground(new java.awt.Color(0,128,64));
				hardGreenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						redButtonActionPerformed(evt);
					}
				});
			}
			{
				grey = new JButton();
				this.add(grey);
				grey.setBounds(28, 84, 28, 28);
				grey.setBackground(new java.awt.Color(192,192,192));
				grey.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						greyActionPerformed(evt);
					}
				});
			}
			{
				ziButton = new JButton();
				this.add(ziButton);
				ziButton.setBounds(0, 84, 28, 28);
				ziButton.setBackground(new java.awt.Color(128,0,128));
				ziButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ziButtonActionPerformed(evt);
					}
				});
			}
			{
				black = new JButton();
				this.add(black);
				black.setBounds(28, 112, 28, 28);
				black.setBackground(new java.awt.Color(0,0,0));
				black.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						qinActionPerformed(evt);
					}
				});
			}
			{
				redButton = new JButton();
				this.add(redButton);
				redButton.setBounds(0, 28, 28, 28);
				redButton.setBackground(new java.awt.Color(255,0,0));
				redButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						hardButtonActionPerformed(evt);
					}
				});
			}
			{
				yellowButton = new JButton();
				this.add(yellowButton);
				yellowButton.setBounds(28, 28, 28, 28);
				yellowButton.setBackground(new java.awt.Color(255,255,0));
				yellowButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						yellowButtonActionPerformed(evt);
					}
				});
			}
			{
				green = new JButton();
				this.add(green);
				green.setBounds(28, 56, 28, 28);
				green.setBackground(new java.awt.Color(128,255,128));
				green.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						greenActionPerformed(evt);
					}
				});
			}
			{
				blue = new JButton();
				this.add(blue);
				blue.setBounds(0, 56, 28, 28);
				blue.setBackground(new java.awt.Color(0,0,255));
				blue.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						blueActionPerformed(evt);
					}
				});
			}
			{
				forwardButton = new JButton();
				this.add(forwardButton);
				forwardButton.setBounds(-7, 162, 63, 28);
				forwardButton.setBackground(new java.awt.Color(0,0,0));
				forwardButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						forwardButtonActionPerformed(evt);
					}
				});
			}
			{
				moreButton = new JButton();
				this.add(moreButton);
				moreButton.setBounds(-7, 188, 63, 28);
				moreButton.setText("\u66f4\u591a");
				moreButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						moreButtonActionPerformed(evt);
					}
				});
			}
			{
				selectedLabel = new JLabel();
				this.add(selectedLabel);
				selectedLabel.setText("\u9009\u4e2d:");
				selectedLabel.setBounds(0, 140, 56, 21);
			}
			this.setPreferredSize(new java.awt.Dimension(105, 231));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void hardButtonActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.redButton.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void yellowButtonActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.yellowButton.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void blueActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.blue.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void greenActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.green.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void ziButtonActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.ziButton.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void greyActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.grey.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void redButtonActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.hardGreenButton.getBackground());
		forwardButtonActionPerformed( evt);
	}
	
	private void qinActionPerformed(ActionEvent evt) {
		this.forwardButton.setBackground(this.black.getBackground());
		forwardButtonActionPerformed( evt);
	}

	public Color getForwardColor() {
		forwardColor = this.forwardButton.getBackground();
		return forwardColor;
	}
	
	private void moreButtonActionPerformed(ActionEvent evt) {
        Color color=JColorChooser.showDialog(this,"Color",Color.lightGray ); 
         if (color==null)                      
              color=Color.black;                
         forwardButton.setBackground(color);     
         forwardButtonActionPerformed(evt);
	}
	
	private void forwardButtonActionPerformed(ActionEvent evt) {
		if(this.getBackground().equals(new Color(238,238,238))){
			this.setBackground(new Color(238,238,237));
		}else{
			this.setBackground(new Color(238,238,238));
		}
	}

}
