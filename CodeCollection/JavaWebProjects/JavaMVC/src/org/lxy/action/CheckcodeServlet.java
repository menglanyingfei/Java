package org.lxy.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码（带session校验的）
 * @author 15072
 *
 */
public class CheckcodeServlet extends HttpServlet {

	private static final long serialVersionUID = 6844903675556996954L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 在内存中生成图片（纸），没有设置背景颜色，画填充的矩形，并且和纸的大小相同，矩形有颜色
		 * 获取笔的对象（设置颜色，设置字体，画字符串，画矩形）
		 * 先准备好数据，随机生成4个字符，把字符画到纸上
		 * 画干扰线
		 * 把内存中的图片输出到客户端上
		 */
		int width = 120;
		int height = 30;
		// 在内存中生成图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 先获取画笔对象
		Graphics2D g = (Graphics2D) image.getGraphics();
		// 设置灰色
		g.setColor(Color.GRAY);
		// 画填充的矩形
		g.fillRect(0, 0, width, height);
		// 设置颜色
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width - 1, height - 1);
		// 准备数据，随机获取4个字符
		String words = "ABCDEabcde1234567890";
		
		// 设置颜色
		g.setColor(Color.YELLOW);
		// 设置字体
		g.setFont(new Font("隶书", Font.BOLD, 20));
		
		StringBuffer sb = new StringBuffer();
		
		Random random = new Random();
		
		int x = 20;
		int y = 20;
		for (int i = 0; i < 4; i++) {
			// void rotate(double theta, double x, double y)
			// theta 弧度
			// radian = angle * Math.PI / 180;
			// 获取正负30之间的角度
			int angle = random.nextInt(60) - 30;
			double radian = angle * Math.PI / 180;
			g.rotate(radian, x, y);
						
			// 获取下标
			int index = random.nextInt(words.length());
			// 返回指定下标位置的字符，随机获取下标
			char ch = words.charAt(index);
			
			// 把ch装起来，存入到session中
			sb.append(ch);
			
			// 写字符串
			g.drawString("" + ch, x, y);
			
			g.rotate(-radian, x, y);
			x += 20;
		}
		
		// 存入session中
		request.getSession().setAttribute("code", sb.toString());
		
		// 设置颜色
		g.setColor(Color.GREEN);
		int x1, x2, y1, y2;
		// 画干扰线
		for (int i = 0; i < 4; i++) {
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);
			x2 = random.nextInt(width);
			y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		
		// 输出到客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	/*public static void main(String[] args) {
		System.out.println("\u7684");
	}*/

}
