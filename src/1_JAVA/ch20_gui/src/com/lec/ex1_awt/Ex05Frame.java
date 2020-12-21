package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;

public class Ex05Frame extends Frame implements ActionListener {
	
	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;
	
	public Ex05Frame(String title) {
		super(title);
		
		//setLayout(new GridLayout(2,1));
		
		//panel = new Panel(new GridLayout(1,4));
		panel = new Panel();
		txtField = new TextField("입력",20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		
		panel.add(new Label("Write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		
		setLocation(400,400);
		setSize(new Dimension(400,200));
		setVisible(true);
		
		btnExit.addActionListener(this);
		btnOk.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk && !txtField.getText().isEmpty()) {
			list.add(txtField.getText());
			txtField.setText("");
		}
		
		if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} 

	}

	public static void main(String[] args) {
		new Ex05Frame("테스트");
	}
}
