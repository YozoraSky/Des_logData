package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import resources.LoadProperties;

public class MenuButtonHandler implements ActionListener{
	private JTextField textField, CallUUIDField, ConnIDField;
	private JFrame frame;
	private JLabel showDate;
	private String directory;
	private String logName;
//	buttom name
	private String item;
	private Properties props;
	
	public MenuButtonHandler(JFrame frame, JLabel showDate, JTextField textField, JTextField CallUUIDField,
			JTextField ConnIDField) {
		this.CallUUIDField = CallUUIDField;
		this.ConnIDField = ConnIDField;
		this.textField = textField;
		this.frame = frame;
		this.showDate = showDate;
		props = new LoadProperties().load();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		item = event.getActionCommand();
		CallUUIDField.setEditable(true);
		ConnIDField.setEditable(true);
		textField.setEditable(true);
		if(item.equals("esb")) {
			frame.setTitle("Ivr log.txt query program( ivr-gateway / esb )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("esbFileName"));
			setLogName(props.getProperty("esbLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("line")) {
			frame.setTitle("Ivr log.txt query program( ivr-gateway / line )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("lineFileName"));
			setLogName(props.getProperty("lineLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("tandem")) {
			frame.setTitle("Ivr log.txt query program( ivr-gateway / tandem )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("socketFileName"));
			setLogName(props.getProperty("socketLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("authBackup")) {
			frame.setTitle("Ivr log.txt query program( ivr-gateway / authBackup )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("authBackupFileName"));
			setLogName(props.getProperty("authBackupLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("fax")) {
			frame.setTitle("Ivr log.txt query program( ivr-gateway / fax )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("faxFileName"));
			setLogName(props.getProperty("faxLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("db")) {
			frame.setTitle("Ivr log.txt query program( ivr-repo-gateway / db )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("dbFileName"));
			setLogName(props.getProperty("dbLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
		
		if(item.equals("mq")) {
			frame.setTitle("Ivr log.txt query program( ivr-repo-gateway / mq )");
			setDirectory(props.getProperty("directoryPath") + props.getProperty("mqFileName"));
			setLogName(props.getProperty("mqLogName"));
			textField.setText("");
			textField.setEditable(true);
			showDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
		}
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

}
