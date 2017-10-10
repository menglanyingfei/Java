package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Triangle extends ShapeSet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1799485189572579921L;

	private int[] xPoints = new int[3];

	private int[] yPoints = new int[3];

	public Triangle(Point startPoint, Point endPoint, Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
		
	}
	
	public void getThiangle() {
		
		double angle = Math.atan((this.endPoint.getY()-this.startPoint.getY())/(this.endPoint.getX()-this.startPoint.getX()));
		
		if(this.endPoint.getX()<this.startPoint.getX()){
			angle += Math.PI; 
		}
		
		double distance = this.endPoint.distance(this.startPoint.getX(),
				this.startPoint.getY());
		for (int i = 0; i < 3; i++) {
				xPoints[i] =(int) ( this.startPoint.x+ distance*Math.cos(angle+Math.PI/3*2*i));
				yPoints[i] =(int) ( this.startPoint.y+ distance*Math.sin(angle+Math.PI/3*2*i));
		}
	}
	public void drawShape(Graphics g) {
		getThiangle();
		g.setColor(color);
		g.drawPolygon(xPoints, yPoints, 3);
	}

	@Override
	public ShapeSet catchShape() {
		return new Triangle(this.startPoint,this.endPoint,this.color);
	}

	@Override
	public Point[] getHotPoints() {
		Point[] hotPoints = new Point[3];
		for(int i=0;i<3;i++){
			hotPoints[i] = new Point(xPoints[i],yPoints[i]);
		}
		return hotPoints;
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

	
	@Override
	public Point[] getHotZoom(){
		Point[] hotPoints = new Point[3];
		for(int i=0;i<3;i++){
			hotPoints[i] = new Point(xPoints[i],yPoints[i]);
		}
		return hotPoints;
	}
	
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		getThiangle();
		realShape.add(new Line2D.Double(new Point(xPoints[0],yPoints[0]),new Point(xPoints[1],yPoints[1])));
		realShape.add(new Line2D.Double(new Point(xPoints[1],yPoints[1]),new Point(xPoints[2],yPoints[2])));
		realShape.add(new Line2D.Double(new Point(xPoints[2],yPoints[2]),new Point(xPoints[0],yPoints[0])));
		return realShape;
	}
}
