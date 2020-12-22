package com.lec.ex2_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;

public class Ex02Frame extends JFrame implements ActionListener {
	private JPanel				panel;
	private Container			container;
	private JLabel 				lbl1,lblBlank;
	private ImageIcon 			icon;
	private JButton 			btn;
	private JTextField 			txtField;
	private JComboBox<String>	cbBox;
	private Vector<String>		item;
	private JCheckBox 			chkBox;
	private JButton 			btnExit;
	//private JTextArea
	
	public Ex02Frame(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		lbl1 = new JLabel("Label");
		icon = new ImageIcon("icon/write.gif");
		
		btn = new JButton("Button",icon);
		txtField = new JTextField(20);
		
		item = new Vector<String>();
		item.add("A");	item.add("B");	item.add("C");
		cbBox = new JComboBox<String>(item);
		chkBox = new JCheckBox("CheckBox");
		lblBlank = new JLabel();
		btnExit = new JButton("Exit");
		
		lbl1.setPreferredSize(new Dimension(50,50));
		btn.setPreferredSize(new Dimension(200,50));
		txtField.setPreferredSize(new Dimension(300,50));
		cbBox.setPreferredSize(new Dimension(100,50));
		chkBox.setPreferredSize(new Dimension(100,50));
		lblBlank.setPreferredSize(new Dimension(200,50));
		btnExit.setPreferredSize(new Dimension(100,50));
		
		container.add(lbl1);
		container.add(btn);
		container.add(txtField);
		container.add(cbBox);
		container.add(chkBox);
		container.add(lblBlank);
		container.add(btnExit);
		
		btn.addActionListener(this);
		btnExit.addActionListener(this);
		cbBox.addActionListener(this);
		chkBox.addActionListener(this);
				
		setVisible(true);
		pack();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			String temp = txtField.getText().trim();
			
			if(!temp.equals("")) {
				lblBlank.setText(temp);
				cbBox.addItem(temp);
				cbBox.setSelectedItem(temp);
				System.out.println(item);
				txtField.setText("");
				String name = JOptionPane.showInputDialog("이름은?");
				
				if(name.trim()!=null) {
					chkBox.setText(name);
				}
			}
		}

		if(e.getSource() == btnExit) {
			Integer yn = JOptionPane.showConfirmDialog(null, "Swing 종료", "종료 하시겠습니까?", JOptionPane.YES_NO_OPTION);
			if (yn == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
		
		if(e.getSource() == cbBox) {
			lblBlank.setText(cbBox.getSelectedItem().toString());
		}
		
		if(e.getSource() == chkBox) {
			if(chkBox.isSelected()) {
				lblBlank.setText(chkBox.getText());
			} else {
				System.out.println("체크박스를 언체크함");
				//JOptionPane.showMessageDialog(null, "이름은?");
				JOptionPane.showMessageDialog(null, "이름은", "이름 묻기", JOptionPane.PLAIN_MESSAGE);
			}
		}


	}
	
	public static void main(String[] args) {
		new Ex02Frame("두번째 스윙 GUI");
	}

}
