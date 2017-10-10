package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import java.util.ArrayList;

public class Ellipse extends ShapeSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3617518036264802248L;
	
	public Ellipse(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
		
	}
	public void drawShape(Graphics g) {
		g.setColor(color);
		g.drawOval(Math.min(startPoint.x, endPoint.x),Math.min(startPoint.y, endPoint.y),Math.abs(endPoint.x-startPoint.x),Math.abs(endPoint.y-startPoint.y));
	}
	@Override
	public ShapeSet catchShape() {
		return new Ellipse(this.startPoint,this.endPoint,this.color);
	}
	@Override
	public Point[] getHotPoints() {
		Point[] hotPoints ={new Point(this.startPoint.x,(this.startPoint.y+this.endPoint.y)/2),
							new Point(this.endPoint.x,(this.startPoint.y+this.endPoint.y)/2),
							new Point((this.startPoint.x+this.endPoint.x)/2,this.startPoint.y),
							new Point((this.startPoint.x+this.endPoint.x)/2,this.endPoint.y)};
		return hotPoints;
	}
	@Override
	public boolean isHotPoint(Point mousePoint) {
		boolean bl = false;
		ArrayList<Shape> realShape  =	getRealShape();
		if(realShape.get(0).contains(mousePoint)&&!realShape.get(1).contains(mousePoint)){
			bl = true;
		}
		return bl;
	}
	@Override
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		realShape.clear();
		realShape.add(new Ellipse2D.Double(Math.min(startPoint.x, endPoint.x)-3,Math.min(startPoint.y, endPoint.y)-3,Math.abs(endPoint.x-startPoint.x)+6,Math.abs(endPoint.y-startPoint.y)+6));
		realShape.add(new Ellipse2D.Double(Math.min(startPoint.x, endPoint.x)+3,Math.min(startPoint.y, endPoint.y)+3,Math.abs(endPoint.x-startPoint.x)-6,Math.abs(endPoint.y-startPoint.y)-6));
		
		return realShape;
	}

}
