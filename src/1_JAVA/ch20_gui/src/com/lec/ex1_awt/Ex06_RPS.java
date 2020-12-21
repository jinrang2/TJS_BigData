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
		btnS = new Button("가위");
		btnR = new Button("바위");
		btnP = new Button("보");
		
		list = new List();
		
		btnExit = new Button("종료");
		
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
			rst = String.format("비겼다너 %s 나 %s", userRPS, comRPS);	
		} else if (( user - comr) == 1	){
			rst = String.format("너가 이겼다 너 %s 나 %s", userRPS, comRPS);
		}		
		else if (( user - comr) == -2){
			rst = String.format("너가 이겼다 너 %s 나 %s", userRPS, comRPS);
		}		
		else {
			rst = String.format("내가 이겼다 너 %s 나 %s", userRPS, comRPS);
		}
						
		return rst;
	}
	
	private String numToRPS(int num) {
		if (num == 0)	return "가위";
		if (num == 1)	return "바위";
		if (num == 2)	return "보";
		return "에러";
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
		new Ex06_RPS("가위 바위 보");
	}
}
