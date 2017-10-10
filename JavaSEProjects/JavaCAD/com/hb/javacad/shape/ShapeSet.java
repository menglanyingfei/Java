package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class ShapeSet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8175500047555872558L;
	protected Point startPoint;
	protected Point endPoint;
	protected Color color ;
	
	public static final int UNSELECTED = 0;
	public static final int SELECTED = 1;
	protected int state;
	
	public ShapeSet(){
		this.setState(UNSELECTED);
	}
	/**
	 * 
	 *
	 */
	public abstract ArrayList<Shape> getRealShape();
	/**
	 * 
	 * @param g
	 */
	public abstract void drawShape(Graphics g);
	
	public abstract boolean isHotPoint(Point mousePoint);
	
	public abstract Point[] getHotPoints();
	
	public abstract ShapeSet catchShape();
	
	
	public Point[] getHotZoom(){
		Point[] hotZoom = {new Point(),new Point(),new Point(),new Point(),new Point(),new Point(),new Point(),new Point()};
		hotZoom[0].setLocation(this.startPoint.getX(),this.startPoint.getY());
		hotZoom[1].setLocation((this.endPoint.getX()+this.startPoint.getX())/2,this.startPoint.getY());
		hotZoom[2].setLocation(this.endPoint.getX(),this.startPoint.getY());
		hotZoom[3].setLocation(this.endPoint.getX(),(this.endPoint.getY()+this.startPoint.getY())/2);
		hotZoom[4].setLocation(this.endPoint.getX(),this.endPoint.getY());
		hotZoom[5].setLocation((this.endPoint.getX()+this.startPoint.getX())/2,this.endPoint.getY());
		hotZoom[6].setLocation(this.startPoint.getX(),this.endPoint.getY());
		hotZoom[7].setLocation(this.startPoint.getX(),(this.endPoint.getY()+this.startPoint.getY())/2);
		
		return hotZoom;
	}
	
	/**
	 * 
	 * @param Graphics
	 */
	public void draw(Graphics g,boolean bl){
		drawShape(g);
		if(getState()==ShapeSet.SELECTED){
			this.drawHotZoom(g,bl);
		}
	}
	
	/**
	 *
	 * 
	 * @param Graphics
	 */
	public void drawHotPoints(Graphics g) {
		g.setColor(Color.black);
		Point[] hotPoints = getHotPoints();
		for(int i = 0;i<hotPoints.length;i++){
			g.drawRect(hotPoints[i].x-2, hotPoints[i].y-2, 4, 4);
		}
	}
	
	/**
	 * 
	 * 
	 * @param Graphics
	 */
	public void drawHotZoom(Graphics g,boolean bl){
		if(bl){
			g.setColor(Color.black);
		}else{
			g.setColor(Color.gray);
		}
		Point[] hotZoom = getHotZoom();
		for(int i = 0;i<hotZoom.length;i++){
			g.drawRect(hotZoom[i].x-3, hotZoom[i].y-3, 6, 6);
		}
	}
	
	public int inHotZoom(Point mousePoint){
		int index = -1;
		for(int i=0;i<getHotZoom().length;i++){
			if(new java.awt.Rectangle(getHotZoom()[i].x-2, getHotZoom()[i].y-2, 4, 4).contains(mousePoint)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
