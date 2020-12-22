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
		
		lbl = new JLabel("즐거운 월요일");
		//lbl.setPreferredSize(new Dimension(150,200));
		btn = new JButton("종료");
		//btn.setPreferredSize(new Dimension(150,200));
		panel.add(lbl);
		panel.add(btn);
		
		setVisible(true);
		//pack();				//최소한의 사이즈
		setSize(new Dimension(500,300));
		
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Ex01Frame("첫 스윙예제");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showConfirmDialog(null, "choose one", "choose one", JOptionPane.YES_NO_OPTION);
			 Object[] options = { "OK", "CANCEL" };
			 JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]);
			 
			 Object[] possibleValues = { "First", "Second", "Third" };

			 Object selectedValue = JOptionPane.showInputDialog(null,
			             "Choose one", "Input",
			             JOptionPane.INFORMATION_MESSAGE, null,
			             possibleValues, possibleValues[0]);
		}		
	}
}
