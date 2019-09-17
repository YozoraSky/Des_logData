package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.CharUtil;
import main.Directory;
import main.PutInMap;
import main.Search;

public class QueryButtonHandler implements ActionListener{
	private CheckButtonHandler checkHandler;
	private String directoryPath;
	private String logName;
	private JTextArea textArea;
	private JFrame frame;
	private JTextField CallUUIDField;
	private JTextField ConnIDField;
	private JTextField GvpSessionIDField;
	
	public QueryButtonHandler(CheckButtonHandler checkHandler, JTextArea textArea, JFrame frame, 
			JTextField CallUUIDField, JTextField ConnIDField, JTextField GvpSessionIDField) {
		this.checkHandler = checkHandler;
		this.textArea = textArea;
		this.frame = frame;
		this.CallUUIDField = CallUUIDField;
		this.ConnIDField = ConnIDField;
		this.GvpSessionIDField = GvpSessionIDField;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		StringBuilder builder = new StringBuilder();
		directoryPath = checkHandler.getMenuHandler().getDirectory();
		logName = checkHandler.getHaveDataLogName();
		ArrayList<String> files = Directory.getFileList(logName, directoryPath, textArea);
		for(int i=0;i<files.size();i++) {
			StringWriter sw = new StringWriter();
			FileReader fr;
			BufferedReader reader;
			try {
				fr = new FileReader(directoryPath+files.get(i));
				reader = new BufferedReader(fr);
				CharUtil.dump(reader, sw);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String context = sw.toString();
			
//			判斷檔案是否以#$$%%%%$$#結尾，若否，則先去讀下個log檔案直到###結尾為止
//			if(context.substring(context.length()-100, context.length()).indexOf("#$$%%%%$$#")==-1) {
//				StringWriter swNextFile = new StringWriter();
//				char[] data = new char[4096];//開2048會不夠(長一點的電文就超出了)
//				FileReader frNextFile;
//				BufferedReader nextFileReader;
//				try {
//					frNextFile = new FileReader(directoryPath+files.get(i+1));
//					nextFileReader = new BufferedReader(frNextFile);
//					if((nextFileReader.read(data)) != -1) swNextFile.write(data);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				context = context + swNextFile.toString().substring(0, swNextFile.toString().indexOf("#$$%%%%$$#")+10);
//			}
			
//			把處理好的字串context放進search物件裡，並執行putInMap方法
			Search search = null;
			List<Map<String, String>> list = null;
			if(checkHandler.getMenuHandler().getItem().equals("esb")) {
				list = PutInMap.esb(context);
				search = new Search("esb");
			}
			if(checkHandler.getMenuHandler().getItem().equals("line")) {
				list = PutInMap.db_or_line_or_socket_or_authBackup(context);
				search = new Search("line");
			}
			if(checkHandler.getMenuHandler().getItem().equals("tandem")) {
				list = PutInMap.db_or_line_or_socket_or_authBackup(context);
				search = new Search("tandem");
			}
			if(checkHandler.getMenuHandler().getItem().equals("authBackup")) {
				list = PutInMap.db_or_line_or_socket_or_authBackup(context);
				search = new Search("authBackup");
			}
			if(checkHandler.getMenuHandler().getItem().equals("fax")) {
				list = PutInMap.fax(context);
				search = new Search("fax");
			}
			if(checkHandler.getMenuHandler().getItem().equals("db")) {
				list = PutInMap.db_or_line_or_socket_or_authBackup(context);
				search = new Search("db");
			}
			if(checkHandler.getMenuHandler().getItem().equals("mq")) {
				list = PutInMap.mq(context);
				search = new Search("mq");
			}
//			直接拿callUUIDField.getText()空字串去搜尋會搜尋不到?
			String callUUID="";
			String connID="";
			String gvpSessionID="";
			if(!CallUUIDField.getText().equals(""))
				callUUID = CallUUIDField.getText();
			if(!ConnIDField.getText().equals(""))
				connID = ConnIDField.getText();
			if(!GvpSessionIDField.getText().equals(""))
				gvpSessionID = GvpSessionIDField.getText();
			
			for(Map<String, String> map:list) {
				try {
					builder.append(search.getData(map, callUUID, connID, gvpSessionID));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(!builder.toString().equals(""))
			textArea.append(builder.toString());
		else {
			textArea.setText("");
			JOptionPane.showMessageDialog(frame, "data not found!");
		}
	} 
}
