package shapes;

import java.awt.Graphics;

/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class Circle extends Shape {
	private int x;
	private int y;
	private int radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
	}

	@Override
	public void move(Graphics g) {
	}
	
}
