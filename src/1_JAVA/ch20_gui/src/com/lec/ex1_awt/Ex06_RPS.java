package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ex06_RPS extends Frame implements ActionListener {

	private Panel panel;
	private Button btnS,btnR,btnP;
	private List list;
	private Button btnExit;
	
	public Ex06_RPS(String title)  {
		super(title);
		
		panel = new Panel();
		btnS = new Button("����");
		btnR = new Button("����");
		btnP = new Button("��");
		
		list = new List();
		
		btnExit = new Button("����");
		
		panel.add(btnS);
		panel.add(btnR);
		panel.add(btnP);
		
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(new Dimension(500,400));
		setLocation(400,500);
		
		btnS.addActionListener(this);
		btnR.addActionListener(this);
		btnP.addActionListener(this);
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
	
	private String getRPS(int user) {
		String rst;
		Random random = new Random ();
		int comr;
		String comRPS,userRPS;
		
		comr = Math.abs(random.nextInt()%3);
		
		comRPS = numToRPS(comr);
		userRPS = numToRPS(user);
		
		if ( (user == comr)	) {
			rst = String.format("���ٳ� %s �� %s", userRPS, comRPS);	
		} else if (( user - comr) == 1	){
			rst = String.format("�ʰ� �̰�� �� %s �� %s", userRPS, comRPS);
		}		
		else if (( user - comr) == -2){
			rst = String.format("�ʰ� �̰�� �� %s �� %s", userRPS, comRPS);
		}		
		else {
			rst = String.format("���� �̰�� �� %s �� %s", userRPS, comRPS);
		}
						
		return rst;
	}
	
	private String numToRPS(int num) {
		if (num == 0)	return "����";
		if (num == 1)	return "����";
		if (num == 2)	return "��";
		return "����";
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
		if(e.getSource() == btnS) {
			list.add(getRPS(0));
		}
		
		if(e.getSource() == btnR) {
			list.add(getRPS(1));
		}
		
		if(e.getSource() == btnP) {
			list.add(getRPS(2));
		}

	}

	public static void main(String[] args) {
		new Ex06_RPS("���� ���� ��");
	}
}
