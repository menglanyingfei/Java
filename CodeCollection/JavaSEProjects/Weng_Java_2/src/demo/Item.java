package demo;
/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class Item {
	private String title;
	private int playingTime;
	private boolean gotIt = false;
	private String comment;
	
	public Item() {
	}

	public Item(String title, int playingTime, boolean gotIt, String comment) {
		super();
		this.title = title;
		this.playingTime = playingTime;
		this.gotIt = gotIt;
		this.comment = comment;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void print() {
		System.out.println(title);
	}

	public int getPlayingTime() {
		return playingTime;
	}

	public boolean isGotIt() {
		return gotIt;
	}

	public String getComment() {
		return comment;
	}

}
