package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Line extends ShapeSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6041401315413910412L;
	

	public Line(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	
	@Override
	public void drawShape(Graphics g) {
		g.setColor(color);
		g.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);

	}

	@Override
	public ShapeSet catchShape() {
		Line selectShape = new Line(getStartPoint(),getEndPoint(),getColor());
		return selectShape;
	}

	@Override
	public Point[] getHotPoints() {
		Point[] HotPoints = {this.startPoint,this.endPoint};
		return HotPoints;
	}

	@Override
	public boolean isHotPoint(Point mousePoint) {
		boolean isHotPoint = false;
		if(((Line2D.Double)getRealShape().get(0)).ptSegDist(mousePoint.getX(), mousePoint.getY())<5){
			isHotPoint = true;
		}
		return isHotPoint;
	}

	
	@Override
	public Point[] getHotZoom(){
		Point[] hotPoints = {this.startPoint,this.endPoint};
		return hotPoints;
	}
	
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		realShape.clear();
		realShape.add(new Line2D.Double(startPoint,endPoint));
		return realShape;
		
	}

}
