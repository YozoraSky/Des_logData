package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditButtonHandler implements ActionListener{
	private JTextField mtextField;
	private JLabel mshowDate;
	
	public EditButtonHandler(JTextField textField,JLabel showDate) {
		mtextField = textField;
		mshowDate = showDate;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		mtextField.setEditable(true);
		mtextField.setText("");
		mshowDate.setText("請輸入符合格式的日期 YYYY/MM/DD");
	}
}
