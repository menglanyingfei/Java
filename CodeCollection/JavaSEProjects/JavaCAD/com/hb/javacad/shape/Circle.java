package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Circle extends ShapeSet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -88025376320371440L;
	
	double radius;

	public Circle(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	
	
	public void drawShape(Graphics g) {
		g.setColor(color);
		Graphics2D g2d=(Graphics2D)g;
		radius = startPoint.distance(endPoint);
		g2d.draw(new Ellipse2D.Double(startPoint.x - radius, startPoint.y - radius,
				2 * radius, 2 * radius));

	}


	@Override
	public ShapeSet catchShape() {
		return new Circle(this.startPoint,this.endPoint,this.color);
	}


	@Override
	public Point[] getHotPoints() {
		Point[] hotPoints = {new Point(this.startPoint.x,this.startPoint.y+(int)radius),
							new Point(this.startPoint.x,this.startPoint.y-(int)radius),
							new Point(this.startPoint.x+(int)radius,this.startPoint.y),
							new Point(this.startPoint.x-(int)radius,this.startPoint.y)};
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
	public Point[] getHotZoom(){
		Point[] hotPoints = {new Point(this.startPoint.x,this.startPoint.y+(int)radius),
				new Point(this.startPoint.x,this.startPoint.y-(int)radius),
				new Point(this.startPoint.x+(int)radius,this.startPoint.y),
				new Point(this.startPoint.x-(int)radius,this.startPoint.y)};
		return hotPoints;
	}
	@Override
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		radius = startPoint.distance(endPoint);
		realShape.add(new Ellipse2D.Double(startPoint.x - radius-2, startPoint.y - radius-2,
				2 * radius+4, 2 * radius+4));
		realShape.add(new Ellipse2D.Double(startPoint.x - radius+2, startPoint.y - radius+2,
				2 * radius-4, 2 * radius-4));
		return realShape;
	}


}
