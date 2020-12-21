package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;

public class Ex02MyFrame extends Frame implements ActionListener {
	private Label lbl1;
	private Button btnExit;
	
	public Ex02MyFrame(String title) {
		this();
		setTitle(title);
	}

	public Ex02MyFrame() {
		setLayout(new FlowLayout());		// BorderLayout�� ����Ʈ
		//setLayout(new GridLayout(2,2));
		lbl1 = new Label("��ſ� ������");
		lbl1.setPreferredSize(new Dimension(150,200));
		
		btnExit = new Button("����");
		btnExit.setPreferredSize(new Dimension(200,200));
		
		add(lbl1);
		add(btnExit);
		
		setVisible(true);
		setSize(new Dimension(500,300));
		setLocation(300,300);
		
		btnExit.addActionListener(this);
		
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
		if(e.getSource() == btnExit) {
			 setVisible(false);
			 dispose();
			 System.exit(0);
		}		
	}
	
	public static void main(String[] args) {
		new Ex02MyFrame("�ι�° GUI ����");
	}

	
}
