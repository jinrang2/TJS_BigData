package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;

public class Ex04Login extends Frame implements ActionListener {
	private Panel panel;
	private TextField txtId, txtPw;
	private Button btnLogin;
		
	public Ex04Login(String title)  {
		super(title);
		
		setLayout(new FlowLayout());		
		panel = new Panel(new GridLayout(2,2));
		
		txtId = new TextField("ID", 20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("로그인");
		
		panel.add(new Label("아 이 디"));
		panel.add(txtId);
		panel.add(new Label("패스워드"));
		panel.add(txtPw);
		
		add(panel, BorderLayout.CENTER);
		add(btnLogin, BorderLayout.SOUTH);
		
		setLocation(400,400);
		setSize(new Dimension(400,200));
		setVisible(true);
		
		btnLogin.addActionListener(this);
		
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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Ex04Login("로그인 화면");
	}
}
