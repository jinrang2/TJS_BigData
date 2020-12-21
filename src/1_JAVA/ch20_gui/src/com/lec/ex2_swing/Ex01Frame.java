package com.lec.ex2_swing;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01Frame extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel lbl;
	private JButton btn;

	public Ex01Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		
		lbl = new JLabel("��ſ� ������");
		//lbl.setPreferredSize(new Dimension(150,200));
		btn = new JButton("����");
		//btn.setPreferredSize(new Dimension(150,200));
		panel.add(lbl);
		panel.add(btn);
		
		setVisible(true);
		//pack();				//�ּ����� ������
		setSize(new Dimension(500,300));
		
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Ex01Frame("ù ��������");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			setVisible(false);
			dispose();
			System.exit(ABORT);
		}		
	}
}
