package demo;
/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class DVD extends Item {
	private String director;
	
	public DVD(String title, String director, int playingTime, String comment) {
		super(title, playingTime, false, comment);
		setTitle("b");
		this.director = director;
	}

	public void print() {
		System.out.print("DVD:");
		super.print();
		System.out.println(director);
	}

}










