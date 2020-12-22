package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class MyFrame extends JFrame implements ActionListener {
	private Container			container;
	private JPanel				panel1;
	private JPanel				panel2;
	
	private JLabel		lblName;
	private JLabel		lblTel;
	private JLabel		lblAge;
	private JTextField	txtName;
	private JTextField	txtTel;
	private JTextField	txtAge;
	
	private JButton		btnInput;
	private JButton		btnOutput;	
	
	private ArrayList<Person> persons;
	
	public MyFrame(String title) {
		super(title);
		
		persons = new ArrayList<Person>();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new FlowLayout());		
		panel1 = new JPanel(new GridLayout(3,2));
		panel2 = new JPanel(new FlowLayout());
		
		lblName = new JLabel("�� ��", (int)CENTER_ALIGNMENT);
		
		lblTel = new JLabel("�� ȭ", (int)CENTER_ALIGNMENT);
		lblAge = new JLabel("�� ��", (int)CENTER_ALIGNMENT);
		txtName = new JTextField(20);
		txtTel = new JTextField(20);
		txtAge = new JTextField(20);
		          
		btnInput = new JButton("�Է�",new ImageIcon("icon/Output.png"));
		btnOutput = new JButton("���",new ImageIcon("icon/Output.png"));
		
		panel1.add(lblName);
		panel1.add(txtName);
		panel1.add(lblTel);
		panel1.add(txtTel);
		panel1.add(lblAge);
		panel1.add(txtAge);
		
		panel2.add(btnInput);
		panel2.add(btnOutput);
		
		container.add(panel1, BorderLayout.CENTER);
		container.add(panel2, BorderLayout.SOUTH);
		
		setVisible(true);
		setBounds(400,300, 400, 200);
		
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			inputPerson();		
		}
		
		if (e.getSource() == btnOutput) {
			outputPerson();
		}
	}

	private void inputPerson() {
		String name, tel, age;
		int nAge;
		
		name = txtName.getText().trim();
		tel = txtTel.getText().trim();
		age = txtAge.getText().trim();
					
		if(!txtValidate(name, tel, age))	return;		//����
		
		nAge = Integer.parseInt(age);
		
		String result= "[�̸�]" + name + "\r\n[��ȭ]" + tel + "\r\n[����]" + age;
		persons.add(new Person(name,tel,nAge));
		
		System.out.println(result);
		txtName.setText("");
		txtTel.setText("");
		txtAge.setText("");	
		JOptionPane.showMessageDialog(null, result,"�Է� �Ϸ�" , JOptionPane.PLAIN_MESSAGE);
	}
	
	private void outputPerson() {
		Writer writer = null;
		
		try {
			writer = new FileWriter("person.txt",true);
			
			for(Person p : persons) {
				writer.write(p.toString() + "\r\n");
				
				System.out.println(p.toString());
			}
					
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (writer != null)	writer.close();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
	
	/*
	 * �Է� �ؽ�Ʈ�� ���� 
	 */
	private boolean txtValidate(String name, String tel, String age) {
		String errMsg,emptyTxt="";
		int nAge, errCode=0;
		
		name = txtName.getText().trim();
		tel = txtTel.getText().trim();
		age = txtAge.getText().trim();
				
		if ( name.isEmpty()) {
			errCode = 1;
			emptyTxt += "�̸� ";		
		}
		
		if ( tel.isEmpty()) {
			errCode = 2;
			emptyTxt += "��ȭ ";
		}
		
		if ( age.isEmpty()) {
			System.out.println(age);
			errCode = 3;
			emptyTxt += "���� ";
		}
		
		if(!emptyTxt.equals("")) {
			errMsg = "�ʼ� �Է� ������ ���� �Ǿ����ϴ�\r\n" + emptyTxt;
			JOptionPane.showMessageDialog(null, errMsg, "�Է� ����", JOptionPane.ERROR_MESSAGE);
		}
		
		switch(errCode) {
			case 1:	txtName.requestFocusInWindow(); return false;	
			case 2:	txtTel.requestFocusInWindow(); return false;
			case 3:	txtAge.requestFocusInWindow(); return false;
		}
		
		try {
			nAge = Integer.parseInt(age);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "���̸� ���ڷ� �Է��ϼ���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtAge.setText("");
			txtAge.requestFocusInWindow();
			return false;
		}
		
		if(nAge<0 || nAge > 130) {
			JOptionPane.showMessageDialog(null, "���̴� 1~129 ���� �Դϴ�", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtAge.setText("");
			txtAge.requestFocusInWindow();
			return false;
		}
		
		if(!tel.matches("^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$"))	{
			JOptionPane.showMessageDialog(null, "�߸��� ��ȭ��ȣ �Դϴ�", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtTel.requestFocusInWindow();
			return false;
		}
		
		return true;
	}
	
	

	public static void main(String[] args) {
		new MyFrame("GUI ����");
	}
}
