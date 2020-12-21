package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;

public class Ex03Login extends Frame implements ActionListener {
	private Label 		lbl1, lbl2;
	private TextField	txtId, txtPw;
	private Button		btnLogin;
	
	
	
	public Ex03Login() {
		super("�α��� ȭ��");
		setLayout(new FlowLayout());
		lbl1 = new Label("�� �� ��");
		lbl2 = new Label("��й�ȣ");
		
		txtId = new TextField("",20);
		txtPw = new TextField("",20);
		txtPw.setEchoChar('*');
		
		btnLogin = new Button("�α���");
		
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
