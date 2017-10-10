package demo;

import java.util.ArrayList;

/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class Database {
	private ArrayList<Item> listItem = new ArrayList<Item>();
	
	public void add(Item item) {
		listItem.add(item);
	}
	
	public void list() {
		for (Item item : listItem) {
			item.print();
		}
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));	
		db.add(new DVD("xxx", "aaa", 60, "..."));
		
		db.add(new MP3("hello", "tom", "...", 60));
		
		db.list();
	}

}












