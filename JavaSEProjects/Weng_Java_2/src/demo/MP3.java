package demo;
/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class MP3 extends Item {
	private String songer;

	public MP3(String title, String songer, String comment , int playingTime) {
		super(title, playingTime, false, comment);
		this.songer = songer;
	}
	
	public void print() {
		System.out.print("MP3:");
		super.print();
		System.out.println(songer);
	}
}
