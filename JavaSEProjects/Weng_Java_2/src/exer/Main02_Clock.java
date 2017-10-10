package exer;

/**
 * @author menglanyingfei
 * @date 2017-7-13
 */
public class Main02_Clock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
		clock.tick();
		System.out.println(clock);

		// 关流
		in.close();
	}
}

class Display {
	private int value = 0;
	private int limit = 0;

	public Display(int limit) {
		this.limit = limit;
	}

	public void increase() {
		value++;
		if (value == limit) {
			value = 0;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class Clock {
	private Display hour = new Display(24);
	private Display minute = new Display(60);
	private Display second = new Display(60);

	public Clock(int hour, int minute, int second) { // 用hour,
														// minute和second初始化时间。
		this.hour.setValue(hour);
		this.minute.setValue(minute);
		this.second.setValue(second);
	}

	public void tick() { // “嘀嗒”一下，时间走1秒。
		second.increase();
		if (second.getValue() == 0) {
			minute.increase();
			if (minute.getValue() == 0) {
				hour.increase();
			}
		}
	}

	public String toString() {
		// 返回一个String的值，以“hh:mm:ss“的形式表示当前时间。
		// 这里每个数值都占据两位，不足两位时补0。如“00:01:22"。注意其中的冒号是西文的，不是中文的。
		return String.format("%02d:%02d:%02d", hour.getValue(),
				minute.getValue(), second.getValue()); // String.format()可以用和printf一样的方式来格式化一个字符串。
	}
}