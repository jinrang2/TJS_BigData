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
		btnOut = new JButton("���",icon);
		txtArea = new JTextArea(5,30);
		scrollBar = new JScrollPane(txtArea);
		txtArea.setEditable(false);
		
				
		panel.add(new JLabel("�� ��", (int)CENTER_ALIGNMENT));
		panel.add(txtName);
		panel.add(new JLabel("�� ȭ", (int)CENTER_ALIGNMENT));
		panel.add(txtTel);
		panel.add(new JLabel("�� ��", (int)CENTER_ALIGNMENT));
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
				System.out.println("�̸��� ��ȭ��ȣ�� �ݵ�� �Է�");
				return;
			}
			
			int age;
				
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "�Է� ����", "�߸��� �����Դϴ�", JOptionPane.ERROR_MESSAGE);
				age = -1;
			}
			
			String result = "[�̸�]" + name + "\t[��ȭ]" + tel;
			
			if(age>=0 && age<130) {
				result += "\t[����]" + age;
			} else {
				result += "\t[����]��ȿ���� ���� ���̸� �Է�";
			}
			
			System.out.println(result);
			txtArea.append(result+"\r\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}		
	}
		
	public static void main(String[] args) {
		new Ex03Frame("GUI ����");
	}
}
