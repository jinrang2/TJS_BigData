package com.lec.person_dao;
import java.awt.*;
import javax.swing.*;

public class GridBagLayoutSample extends JFrame{
	
	private Container container;
	private	JPanel panel1, panel2;
	
	public static void main(String[] args){
		new GridBagLayoutSample("GridBagLayout Sample");
	}

	public GridBagLayoutSample(String str){
		super(str);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new FlowLayout());		

		JButton btn1 = new JButton("One");
		JButton btn2 = new JButton("Two");
		JButton btn3 = new JButton("Three");
		JButton btn4 = new JButton("Four");
		JButton btn5 = new JButton("Five");
		JButton btn6 = new JButton("Six");
		JButton btn7 = new JButton("Seven");

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		//setLayout(gbl);
		
		panel1 = new JPanel(gbl);
		panel2 = new JPanel(gbl);
		

		addGrid(gbl, gbc, btn1, 0, 0, 1, 1, 0, 0);
		addGrid(gbl, gbc, btn2, 1, 0, 1, 1, 1, 0);
		addGrid(gbl, gbc, btn3, 2, 0, 1, 1, 0, 0);
		addGrid(gbl, gbc, btn4, 0, 1, 2, 1, 1, 1);
		addGrid(gbl, gbc, btn5, 2, 1, 1, 2, 0, 1);
		addGrid(gbl, gbc, btn6, 0, 2, 1, 1, 0, 0);
		addGrid(gbl, gbc, btn7, 1, 2, 1, 1, 1, 0);
		
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn7);
		
		container.add(panel1);
		container.add(panel2);
				

		//pack();
		setBounds(500,300, 600, 700);
		setResizable(true);
		setVisible(true);
	}

	private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, 
			int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		add(c);
	}
}