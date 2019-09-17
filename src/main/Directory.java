package main;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Directory {
	
	public static ArrayList<String> getFileList(String file, String directoryName, JTextArea textArea) {
		File f = new File(directoryName); //讀取directoryName這個目錄
	     ArrayList<String> fileList = new ArrayList<String>(); //宣告一ArrayList，用來儲存檔名
	     if(f.isDirectory()) { //如果f讀到的是資料夾，就會執行
	        System.out.println("directoryFolder : "+f.getName());
	        textArea.setText("directoryFolder : "+f.getName()+"\n");
	        int num = 0;
	        for(String s:f.list()) {
	        	if((file + num).equals(s)) {
	        		fileList.add(s); //將檔名一一存到fileList動態陣列裡面
	        		num++;
	        	}
	        }
	     }
	     System.out.println("size : "+fileList.size());
	     textArea.append("size : "+fileList.size()+"\n");
	     for(String fileName:fileList) {
	    	 System.out.println(fileName);
	    	 textArea.append(fileName+"\n");
	     }
	     textArea.append("================================================================================================================================================\n");
	     return fileList;
	}
}
