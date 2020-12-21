package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ex01MyFrame extends Frame {
	private Button btn, btn1;
	

	public Ex01MyFrame() {
		this("");
	}
	
	public Ex01MyFrame(String title) {
		super(title);
		
		//setLayout(n)
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(300,200));
		setLocation(200, 100);
		
//		addWindowListener(new WindowAdapter()) {
//			public void windowClosing(WindowEvent e) {
//				setVisible(false);
//				dispose();
//				System.exit(0);
//			}
			
		
		
	}
	
	public static void main(String[] args) {
		new Ex01MyFrame("첫 GUI 예제");
	}
}
	
	
