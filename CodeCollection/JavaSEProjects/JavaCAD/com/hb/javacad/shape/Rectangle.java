package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Rectangle extends ShapeSet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3402043050505234756L;

	public Rectangle(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	
	public void drawShape(Graphics g) {
		g.setColor(color);
		g.drawRect(Math.min(startPoint.x, endPoint.x),Math.min(startPoint.y, endPoint.y),Math.abs(endPoint.x-startPoint.x),Math.abs(endPoint.y-startPoint.y));
	}

	@Override
	public ShapeSet catchShape() {
		Rectangle rectangle = new Rectangle(startPoint,endPoint,color);
		return rectangle;
	}

	@Override
	public Point[] getHotPoints() {
		Point[] HotPoints = {this.startPoint,new Point(this.startPoint.x,this.endPoint.y),this.endPoint,new Point(this.endPoint.x,this.startPoint.y)};
		return HotPoints;
	}

	@Override
	public boolean isHotPoint(Point mousePoint) {
		boolean bl = false;
		ArrayList<Shape> realShape  =	getRealShape();
		for(int i=0;i<realShape.size();i++){
			if(((Line2D.Double)realShape.get(i)).ptSegDist(mousePoint.getX(),mousePoint.getY())<5){
				bl = true;
				break;
			}
		}
		return bl;
	}

	
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		realShape.clear();
		realShape.add(new Line2D.Double(startPoint.getX(),startPoint.getY(),endPoint.getX(),startPoint.getY()));
		realShape.add(new Line2D.Double(startPoint.getX(),startPoint.getY(),startPoint.getX(),endPoint.getY()));
		realShape.add(new Line2D.Double(endPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY()));
		realShape.add(new Line2D.Double(startPoint.getX(),endPoint.getY(),endPoint.getX(),endPoint.getY()));
		return realShape;
	}

}
