package com.hb.javacad.panel;

import java.awt.Color;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShapeButton extends JToggleButton implements ChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3745730381292760462L;

	public ShapeButton(){
		this.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if(this.isSelected()){
			this.setForeground(Color.red);
		}else{
			this.setForeground(Color.black);
		}
		
	}
}
