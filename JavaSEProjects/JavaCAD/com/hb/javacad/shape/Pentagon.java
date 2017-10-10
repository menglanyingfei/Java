package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Pentagon extends ShapeSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8094692398333791137L;
	private int[] xPoints = new int[5];
	private int[] yPoints = new int[5];
	
	public Pentagon(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	private void getPentagon() {
		double angle = Math.atan((this.endPoint.getY()-this.startPoint.getY())/(this.endPoint.getX()-this.startPoint.getX()));
		
		if(this.endPoint.getX()<this.startPoint.getX()){
			angle += Math.PI; 
		}
		
		double distance=this.endPoint.distance(this.startPoint.getX(), this.startPoint.getY());
		 for(int i=0;i<5;i++){
			 xPoints[i]=this.startPoint.x+(int)(distance*Math.cos(angle+2*i*Math.PI/5));
			 yPoints[i]=this.startPoint.y+(int)(distance*Math.sin(angle+2*i*Math.PI/5));
		 }
	}
	
	public void drawShape(Graphics g) {
		g.setColor(color);
		getRealShape();
		g.drawPolygon(xPoints, yPoints, 5);
	}
	@Override
	public ShapeSet catchShape() {
		return new Pentagon(this.startPoint,this.endPoint,this.color);
	}
	@Override
	public Point[] getHotPoints() {
		Point[] hotPoints = new Point[5];
		for(int i=0;i<5;i++){
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
		Point[] hotPoints = new Point[5];
		for(int i=0;i<5;i++){
			hotPoints[i] = new Point(xPoints[i],yPoints[i]);
		}
		return hotPoints;
	}
	
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		getPentagon();
		realShape.add(new Line2D.Double(new Point(xPoints[0],yPoints[0]),new Point(xPoints[1],yPoints[1])));
		realShape.add(new Line2D.Double(new Point(xPoints[1],yPoints[1]),new Point(xPoints[2],yPoints[2])));
		realShape.add(new Line2D.Double(new Point(xPoints[2],yPoints[2]),new Point(xPoints[3],yPoints[3])));
		realShape.add(new Line2D.Double(new Point(xPoints[3],yPoints[3]),new Point(xPoints[4],yPoints[4])));
		realShape.add(new Line2D.Double(new Point(xPoints[4],yPoints[4]),new Point(xPoints[0],yPoints[0])));
		return realShape;
	}

}
