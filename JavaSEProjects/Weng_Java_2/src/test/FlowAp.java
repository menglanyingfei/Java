package test;

import java.awt.Button;
import java.awt.Frame;

/**
 * @author menglanyingfei
 * @date 2017-8-16
 */
public class FlowAp extends Frame{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2687632952160417283L;
	
	public static void main(String argv[]){
        FlowAp fa=new FlowAp();
        fa.setSize(400,300);
        fa.setVisible(true);
    }
    FlowAp(){
        add(new Button("One"));
        add(new Button("Two"));
        add(new Button("Three"));
        add(new Button("Four"));
    }//End of constructor
}//End of Application
