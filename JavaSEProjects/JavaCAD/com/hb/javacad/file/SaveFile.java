package com.hb.javacad.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.hb.javacad.main.MainFrame;
import com.hb.javacad.panel.PaintPanel;
import com.hb.javacad.shape.ShapeSet;

public class SaveFile extends JFileChooser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5334498346398326009L;
	
	private MainFrame mainFrame;
	private PaintPanel paintPanel;
	
	public SaveFile(MainFrame mainFrame,PaintPanel paintPanel){
		this.mainFrame = mainFrame;
		this.paintPanel = paintPanel;
	}
	public void save(){
		File file = null;			
		int recieve = this.showSaveDialog(mainFrame);
		if(recieve == APPROVE_OPTION){
			file = this.getSelectedFile();
			String fileName=file.getPath();
			if (file!=null&&file.exists())
			{
			int n = JOptionPane.showConfirmDialog(this, "保存成功!","保存",JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.NO_OPTION){
				return;
			}
			}
			try{
			    FileOutputStream fileOut = null;
			    if(fileName.indexOf(".eye")!=-1){
			    	fileOut = new FileOutputStream(fileName);
			    }else{
			    	fileOut = new FileOutputStream(fileName+".eye");
			    }
			    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);  
			    int e=paintPanel.current.size();
			    
			    objectOut.writeInt(e);
			    for(int j=0;j<e;j++)
			    {
				    ShapeSet t=paintPanel.current.get(j);
				    //System.out.println(t);
				    objectOut.writeObject(t);
			    }
//			    paintPanel.current.clear();
//			    paintPanel.history.clear();
			    objectOut.close();         
			}catch (IOException e){   
				e.printStackTrace();    
			}  
			
		}
	}

}
