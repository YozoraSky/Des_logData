

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import handler.CheckButtonHandler;
import handler.EditButtonHandler;
import handler.JTextFieldHintHandler;
import handler.MenuButtonHandler;
import handler.QueryButtonHandler;
import handler.SaveButtonHandler;

public class WindowBuilder {

	private JFrame frame;
	private JTextField CallUUIDField;
	private JTextField ConnIDField;
	private JTextField GvpSessionIDField;
	private JTextArea textArea;
	private JTextField textField;
	private JLabel showDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ivr log.txt query program");
		frame.setBounds(50, 10, 1200, 680);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(5, 210, 1176, 403);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(96, 14, 906, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		CallUUIDField = new JTextField();
		CallUUIDField.setBounds(96, 60, 906, 21);
		frame.getContentPane().add(CallUUIDField);
		CallUUIDField.setColumns(32);
		CallUUIDField.setEditable(false);

		ConnIDField = new JTextField();
		ConnIDField.setBounds(96, 93, 906, 21);
		frame.getContentPane().add(ConnIDField);
		ConnIDField.setColumns(16);
		ConnIDField.setEditable(false);

		GvpSessionIDField = new JTextField();
		GvpSessionIDField.setBounds(96, 128, 906, 21);
		frame.getContentPane().add(GvpSessionIDField);
		GvpSessionIDField.setColumns(36);
		GvpSessionIDField.setEditable(false);

		JLabel GvpSessionIDLabel = new JLabel("GvpSessionID");
		GvpSessionIDLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		GvpSessionIDLabel.setBounds(5, 134, 85, 15);
		frame.getContentPane().add(GvpSessionIDLabel);

		JLabel connIDLabel = new JLabel("connID");
		connIDLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		connIDLabel.setBounds(5, 99, 47, 15);
		frame.getContentPane().add(connIDLabel);

		JLabel callUUIDLabel = new JLabel("callUUID");
		callUUIDLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		callUUIDLabel.setBounds(5, 62, 64, 15);
		frame.getContentPane().add(callUUIDLabel);

		JButton QueryButton = new JButton("Query");
		QueryButton.setBounds(1066, 143, 85, 23);
		frame.getContentPane().add(QueryButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(1066, 177, 85, 23);
		frame.getContentPane().add(saveButton);

		JLabel lblLogtxt = new JLabel("log.txt");
		lblLogtxt.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblLogtxt.setBounds(12, 183, 58, 21);
		frame.getContentPane().add(lblLogtxt);

		JLabel date = new JLabel("選擇日期");
		date.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		date.setBounds(5, 15, 64, 15);
		frame.getContentPane().add(date);

		JButton checkButton = new JButton("確認");
		checkButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		checkButton.setBounds(1023, 13, 58, 23);
		frame.getContentPane().add(checkButton);

		JButton editButton = new JButton("編輯");
		editButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		editButton.setBounds(1104, 13, 58, 23);
		frame.getContentPane().add(editButton);

		showDate = new JLabel("");
		showDate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		showDate.setBounds(94, 33, 370, 21);
		frame.getContentPane().add(showDate);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("DirectoryFile");
		menuBar.add(fileMenu);
		fileMenu.setPopupMenuVisible(true);
		
		JMenu IvrGatewayMenu = new JMenu("Ivr-gateway");
		fileMenu.add(IvrGatewayMenu);
		IvrGatewayMenu.setPopupMenuVisible(true);
		
		JMenu IvrRepoGatewayMenu = new JMenu("Ivr-repo-gateway");
		fileMenu.add(IvrRepoGatewayMenu);
		IvrRepoGatewayMenu.setPopupMenuVisible(true);
		
		JMenuItem ESBItem = new JMenuItem("esb");
		IvrGatewayMenu.add(ESBItem);
		
		JMenuItem lineItem = new JMenuItem("line");
		IvrGatewayMenu.add(lineItem);
		
		JMenuItem tandemItem = new JMenuItem("tandem");
		IvrGatewayMenu.add(tandemItem);
		
		JMenuItem authBackupItem = new JMenuItem("authBackup");
		IvrGatewayMenu.add(authBackupItem);
		
		JMenuItem faxItem = new JMenuItem("fax");
		IvrGatewayMenu.add(faxItem);
		
		JMenuItem DBItem = new JMenuItem("db");
		IvrRepoGatewayMenu.add(DBItem);
		
		JMenuItem MQItem = new JMenuItem("mq");
		IvrRepoGatewayMenu.add(MQItem);
		
//		=========================================== 
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		fileMenu.setPopupMenuVisible(true);
		
		JMenuItem helpItem = new JMenuItem("About this app");
		helpMenu.add(helpItem);
		
		helpItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "Ha Ha ! no any help to you~~~");
				JOptionPane.showMessageDialog(frame, "You still need to press five times");
				JOptionPane.showMessageDialog(frame, "You still need to press four times");
				JOptionPane.showMessageDialog(frame, "You still need to press three times");
				JOptionPane.showMessageDialog(frame, "You still need to press two times");
				JOptionPane.showMessageDialog(frame, "You still need to press one times");
				JOptionPane.showMessageDialog(frame, "Do you think it is over?");
				JOptionPane.showMessageDialog(frame, "not yet~");
				JOptionPane.showMessageDialog(frame, "only one more");
				JOptionPane.showMessageDialog(frame, "bye~ bye~");
			}
		});
//		===========================================
		MenuButtonHandler menuHandler = new MenuButtonHandler(frame, showDate, textField, CallUUIDField,
				ConnIDField, GvpSessionIDField);
		CheckButtonHandler checkHandler = new CheckButtonHandler(menuHandler, textField, showDate);
		QueryButtonHandler queryHandler = new QueryButtonHandler(checkHandler, textArea, frame,
				CallUUIDField, ConnIDField, GvpSessionIDField);
		SaveButtonHandler saveHandler = new SaveButtonHandler(frame, textArea);
		EditButtonHandler editHandler = new EditButtonHandler(textField, showDate);
		JTextFieldHintHandler hintHandler = new JTextFieldHintHandler("YYYY/MM/DD", textField);
		QueryButton.addActionListener(queryHandler);
		saveButton.addActionListener(saveHandler);
		checkButton.addActionListener(checkHandler);
		editButton.addActionListener(editHandler);
		textField.addFocusListener(hintHandler);
		ESBItem.addActionListener(menuHandler);
		MQItem.addActionListener(menuHandler);
		lineItem.addActionListener(menuHandler);
		DBItem.addActionListener(menuHandler);
		tandemItem.addActionListener(menuHandler);
		authBackupItem.addActionListener(menuHandler);
		faxItem.addActionListener(menuHandler);
	}
}
