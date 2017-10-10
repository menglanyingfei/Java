package demo;

import java.util.ArrayList;

/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class NoteBook {
	private ArrayList<String> notes = new ArrayList<String>();
	//private int size = 0;
	
	public void add(String s) {
		notes.add(s);
		//size++;
	}
	
	public void add(String s, int location) {
		notes.add(location, s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);
	}
	
    public void removeNote(int index) {
    	notes.remove(index);
    }
    
    public String[] list() {
    	String[] a = new String[notes.size()];
//    	for (int i = 0; i < notes.size(); i++) {
//    		a[i] = notes.get(i);
//    	}
    	
    	notes.toArray(a);
		return a;    	
    }
    
    public static void main(String[] args) {
    	String[] a = new String[2];
    	a[0] = "first";
    	a[1] = "second";
    	
    	NoteBook nb = new NoteBook();
    	nb.add("first");
    	nb.add("second");
    	nb.add("third", 1);
    	System.out.println(nb.getSize());
    	System.out.println(nb.getNote(0));
    	// 会引起异常
    	//System.out.println(nb.getNote(10));
    	System.out.println(nb.getNote(1));
    	nb.removeNote(1);
    	String[] arr = nb.list();
    	for (String str : arr) {
			System.out.println(str);
		}
    }
}
