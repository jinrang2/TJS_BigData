package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;

public class Ex03Login extends Frame implements ActionListener {
	private Label 		lbl1, lbl2;
	private TextField	txtId, txtPw;
	private Button		btnLogin;
	
	
	
	public Ex03Login() {
		super("로그인 화면");
		setLayout(new FlowLayout());
		lbl1 = new Label("아 이 디");
		lbl2 = new Label("비밀번호");
		
		txtId = new TextField("",20);
		txtPw = new TextField("",20);
		txtPw.setEchoChar('*');
		
		btnLogin = new Button("로그인");
		
		add(lbl1);		add(txtId);
		add(lbl2);		add(txtPw);
		add(btnLogin);
		
		setSize(new Dimension(300,150));
		setResizable(false);
		setLocation(800,600);
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
		
	}

	public static void main(String[] args) {
		new Ex03Login();
	}

}
