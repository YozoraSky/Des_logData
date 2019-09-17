package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckButtonHandler implements ActionListener{
	private MenuButtonHandler menuHandler;
	private JTextField textField;
	private JLabel showDate;
	private String haveDataLogName;
	
	public CheckButtonHandler(MenuButtonHandler menuHandler, JTextField textField, JLabel showDate) {
		this.menuHandler = menuHandler;
		this.textField = textField;
		this.showDate = showDate;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//date為判斷日期是否符合格式的正則表示式
		String date = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])"
				+ "(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])"
				+ "(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))"
				+ "([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])"
				+ "(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])"
				+ "([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)"
				+ "|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])"
				+ "(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|"
				+ "(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
		String text = textField.getText();
		if(text.matches(date)) {
			textField.setEditable(false);
		    showDate.setText("現在日期為："+text);
		    text = text.replaceAll("[-\\/\\._]", "");
		    setHaveDataLogName(menuHandler.getLogName() + text + ".");
		}
		else { 
			textField.setEditable(true);
		    showDate.setText("日期輸入錯誤");
		}
	}
	public MenuButtonHandler getMenuHandler() {
		return menuHandler;
	}

	public String getHaveDataLogName() {
		return haveDataLogName;
	}

	public void setHaveDataLogName(String haveDataLogName) {
		this.haveDataLogName = haveDataLogName;
	}
}
