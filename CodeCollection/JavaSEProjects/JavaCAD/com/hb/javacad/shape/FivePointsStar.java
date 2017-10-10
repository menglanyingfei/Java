package com.hb.javacad.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public class FivePointsStar extends ShapeSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6236280296364907135L;
	private int[] xPoints = new int[10];
	private int[] yPoints = new int[10];
	
	public FivePointsStar(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	
	private void getFivePointsStar(){
		double distance =this.endPoint.distance(this.startPoint.getX(), this.startPoint.getY());
		int r=(int)(distance*Math.sin(Math.PI/10)/Math.sin(3*Math.PI/10));
		
		double angle = Math.atan((this.endPoint.getY()-this.startPoint.getY())/(this.endPoint.getX()-this.startPoint.getX()));
		
		if(this.endPoint.getX()<this.startPoint.getX()){
			angle += Math.PI; 
		}
		for(int i=0;i<10;i++){
		       if(i%2==0){
		        xPoints[i]=this.startPoint.x+(int)(distance*Math.cos(angle+i*Math.PI/5));
		        yPoints[i]=this.startPoint.y+(int)(distance*Math.sin(angle+i*Math.PI/5));
		       }
		       else{
		        xPoints[i]=this.startPoint.x+(int)(r*Math.cos(angle+i*Math.PI/5));
		        yPoints[i]=this.startPoint.y+(int)(r*Math.sin(angle+i*Math.PI/5));
		       }
		    }
		
	}
	
	public void drawShape(Graphics g) {
		g.setColor(color);
		getFivePointsStar();
		g.drawPolygon(xPoints, yPoints, 10);
	}

	@Override
	public ShapeSet catchShape() {
		return new FivePointsStar(this.startPoint,this.endPoint,this.color);
	}

	@Override
	public Point[] getHotPoints() {
		Point[] hotPoints = new Point[5];
		for(int i=0;i<5;i++){
			hotPoints[i] = new Point(xPoints[2*i],yPoints[2*i]);
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
			hotPoints[i] = new Point(xPoints[2*i],yPoints[2*i]);
		}
		return hotPoints;
	}
	
	public ArrayList<Shape> getRealShape() {
		ArrayList<Shape> realShape  = new ArrayList<Shape>();
		this.getFivePointsStar();
		realShape.add(new Line2D.Double(new Point(xPoints[0],yPoints[0]),new Point(xPoints[1],yPoints[1])));
		realShape.add(new Line2D.Double(new Point(xPoints[1],yPoints[1]),new Point(xPoints[2],yPoints[2])));
		realShape.add(new Line2D.Double(new Point(xPoints[2],yPoints[2]),new Point(xPoints[3],yPoints[3])));
		realShape.add(new Line2D.Double(new Point(xPoints[3],yPoints[3]),new Point(xPoints[4],yPoints[4])));
		realShape.add(new Line2D.Double(new Point(xPoints[4],yPoints[4]),new Point(xPoints[5],yPoints[5])));
		realShape.add(new Line2D.Double(new Point(xPoints[5],yPoints[5]),new Point(xPoints[6],yPoints[6])));
		realShape.add(new Line2D.Double(new Point(xPoints[7],yPoints[7]),new Point(xPoints[8],yPoints[8])));
		realShape.add(new Line2D.Double(new Point(xPoints[9],yPoints[9]),new Point(xPoints[0],yPoints[0])));
		realShape.add(new Line2D.Double(new Point(xPoints[6],yPoints[6]),new Point(xPoints[7],yPoints[7])));
		realShape.add(new Line2D.Double(new Point(xPoints[8],yPoints[8]),new Point(xPoints[9],yPoints[9])));
		return realShape;
	}

}
