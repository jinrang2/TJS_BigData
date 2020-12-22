package com.lec.ex2_swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex03Frame extends JFrame implements ActionListener {
	private Container			container;
	private JPanel				panel;
	private JTextField			txtName, txtTel, txtAge;
	private ImageIcon			icon;
	private JButton				btnOut;
	private JTextArea			txtArea;
	private JScrollPane			scrollBar;
	
	public Ex03Frame(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		container = getContentPane() ;                  
		panel = new JPanel(new GridLayout(3,2));                      
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");		
		btnOut = new JButton("출력",icon);
		txtArea = new JTextArea(5,30);
		scrollBar = new JScrollPane(txtArea);
		txtArea.setEditable(false);
		
				
		panel.add(new JLabel("이 름", (int)CENTER_ALIGNMENT));
		panel.add(txtName);
		panel.add(new JLabel("전 화", (int)CENTER_ALIGNMENT));
		panel.add(txtTel);
		panel.add(new JLabel("나 이", (int)CENTER_ALIGNMENT));
		panel.add(txtAge);
		
		container.add(panel, BorderLayout.NORTH);
		container.add(btnOut, BorderLayout.CENTER);
		container.add(scrollBar, BorderLayout.SOUTH);
		
		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(100,100);
		setBounds(700,300, 400, 300);
		
		btnOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOut) {
			String name	= txtName.getText().trim();
			String tel	= txtTel.getText().trim();
		
			if (name.isEmpty() || tel.isEmpty()) {
				System.out.println("이름과 전화번호는 반드시 입력");
				return;
			}
			
			int age;
				
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "입력 오류", "잘못된 나이입니다", JOptionPane.ERROR_MESSAGE);
				age = -1;
			}
			
			String result = "[이름]" + name + "\t[전화]" + tel;
			
			if(age>=0 && age<130) {
				result += "\t[나이]" + age;
			} else {
				result += "\t[나이]유효하지 않은 나이를 입력";
			}
			
			System.out.println(result);
			txtArea.append(result+"\r\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}		
	}
		
	public static void main(String[] args) {
		new Ex03Frame("GUI 예제");
	}
}
