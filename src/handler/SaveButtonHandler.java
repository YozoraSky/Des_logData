package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import main.CharUtil;
import resources.LoadProperties;

public class SaveButtonHandler implements ActionListener{
	private JFrame frame;
	private JTextArea textArea;
	private Properties props;
	
	public SaveButtonHandler(JFrame frame, JTextArea textArea) {
		this.frame = frame;
		this.textArea = textArea;
		props = new LoadProperties().load();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String fileName = JOptionPane.showInputDialog(frame, "Please Input the logFileName!");
		String location = props.getProperty("saveFile") + fileName + ".txt";
		StringReader sr = new StringReader(textArea.getText());
		try {
			FileWriter fw = new FileWriter(location);
			CharUtil.dump(sr, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	
