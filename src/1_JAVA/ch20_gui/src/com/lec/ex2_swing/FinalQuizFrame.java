package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinalQuizFrame extends JFrame implements ActionListener {
	private Container 		container;
	private JPanel			panel1, panel2;
	
	private	JLabel			lblTel;
	private	JLabel			lblName;
	private	JLabel			lblPoint;
	
	private JTextField		txtTel;
	private JTextField		txtName;
	private JTextField		txtPoint;
	
	private JButton			btnJoin;
	private JButton			btnSearch;
	private JButton			btnOutput;
	private JButton			btnExit;
	
	private JScrollPane		scrollBar;
	private JTextArea		txtArea;	
	
	private HashMap<String, Customer> customerMap;
	private ArrayList<Customer>		  customerList;

	public FinalQuizFrame(String title) {
		super(title);
		
		customerMap = new HashMap<String, Customer>();
		customerList = new ArrayList<Customer>();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new FlowLayout());		
		panel1 = new JPanel(new GridLayout(3,2));
		panel2 = new JPanel(new FlowLayout());
		
		lblTel 		= new JLabel("폰번호", (int)CENTER_ALIGNMENT);     
		lblName		= new JLabel("이  름", (int)CENTER_ALIGNMENT);
		lblPoint	= new JLabel("포인트", (int)CENTER_ALIGNMENT);
				            
		txtTel		= new JTextField(15);     
		txtName		= new JTextField(15);
		txtPoint	= new JTextField(15);
		txtPoint.setText("1000");
		            
		btnJoin		= new JButton("가  입");    
		btnSearch	= new JButton("폰조회");
		btnOutput	= new JButton("출  력");
		btnExit		= new JButton("종  료");
		
		txtArea = new JTextArea(15,30);
		scrollBar = new JScrollPane(txtArea);
		txtArea.setEditable(false);
		txtArea.append("   폰번호\t   이름\t포인트\r\n");
		
		
		panel1.add(lblTel);
		panel1.add(txtTel);
		panel1.add(lblName);
		panel1.add(txtName);
		panel1.add(lblPoint);
		panel1.add(txtPoint);
		
		panel2.add(btnJoin);
		panel2.add(btnSearch);
		panel2.add(btnOutput);
		panel2.add(btnExit);
		
		container.add(panel1);
		container.add(panel2);
		container.add(scrollBar, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(true);
		setBounds(600,500, 400, 450);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		new FinalQuizFrame("회원관리");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) {
			joinCustomer();
		}
		
		if(e.getSource() == btnSearch) {
			SearchCustomer();
		}
		
		if(e.getSource() == btnOutput) {
			outputCustomer();
		}
		
		if(e.getSource() == btnExit) {
			Integer yn = JOptionPane.showConfirmDialog(null, "회원관리 종료", "종료 하시겠습니까?", JOptionPane.YES_NO_OPTION);
			if (yn == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}		
	}
	
	private void joinCustomer() {
		String name, tel, point;
		int nPoint;
		
		name = txtName.getText().trim();
		tel = txtTel.getText().trim();
		point = txtPoint.getText().trim();
					
		if(!txtValidate(name, tel, point))	return;		//검증
		
		nPoint = Integer.parseInt(point);
		tel = tel.replace("-", "");
		
		//String resultMsg= "[이름]" + name + "\r\n[전화]" + tel + "\r\n[나이]" + point;
		String result= tel + "\t   " + name + "\t" + point;
		
		txtArea.append(result+"\r\n");
		customerMap.put(telLast(tel), new Customer(name,tel,nPoint));
		customerList.add(new Customer(name,tel,nPoint));
				
		System.out.println(result);
		txtTel.setText("");		
		txtName.setText("");
		txtPoint.setText("1000");	
		JOptionPane.showMessageDialog(null, "회원 가입","입력이 성공했습니다" , JOptionPane.PLAIN_MESSAGE);
	}
	
	private boolean txtValidate(String name, String tel, String point) {
		String errMsg,emptyTxt="";
		int nPoint, errCode=0;
		
		tel = txtTel.getText().trim();
		name = txtName.getText().trim();		
		point = txtPoint.getText().trim();
				
		if ( tel.isEmpty()) {
			errCode = 1;
			emptyTxt += "폰번호 ";
		}
		
		if ( name.isEmpty()) {
			errCode = 2;
			emptyTxt += "이름 ";		
		}
		
		
		if ( point.isEmpty()) {
			System.out.println(point);
			errCode = 3;
			emptyTxt += "포인트 ";
		}
		
		if(!emptyTxt.equals("")) {
			errMsg = "필수 입력 사항이 누락 되었습니다\r\n" + emptyTxt;
			JOptionPane.showMessageDialog(null, errMsg, "입력 오류", JOptionPane.ERROR_MESSAGE);
		}
		
		switch(errCode) {
			case 1:	txtTel.requestFocusInWindow(); return false;
			case 2:	txtName.requestFocusInWindow(); return false;		
			case 3:	txtPoint.requestFocusInWindow(); return false;
		}
		
		try {
			nPoint = Integer.parseInt(point);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "포인트를 숫자로 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
			txtPoint.setText("");
			txtPoint.requestFocusInWindow();
			return false;
		}		
		
		if(!tel.matches("^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$"))	{
			JOptionPane.showMessageDialog(null, "잘못된 전화번호 입니다", "입력 오류", JOptionPane.ERROR_MESSAGE);
			txtTel.requestFocusInWindow();
			return false;
		}
		
		return true;
	}
	
	private String telLast(String tel) {
		return tel.substring(tel.length()-4);
	}
	
	private void SearchCustomer() {
		String findTelLast = JOptionPane.showInputDialog(null,"고객 검색","검색할 전화번호 끝자리를 입력하세요");
		boolean find=false;
		
		if ( customerMap.containsKey(findTelLast)) {
			Integer yn = JOptionPane.showConfirmDialog(null, customerMap.get(findTelLast).getName() + "님 맞으세요?","검색 성공" , JOptionPane.YES_NO_OPTION);
			if (yn == 1) {
				JOptionPane.showMessageDialog(null, "이상하다?", "관리자 문의", JOptionPane.ERROR_MESSAGE);
			}
			
			txtTel.setText(customerMap.get(findTelLast).getTel());
			txtName.setText(customerMap.get(findTelLast).getName());
			txtPoint.setText(Integer.toString(customerMap.get(findTelLast).getPoint()));
		} else {
			JOptionPane.showMessageDialog(null, "검색 결과가 없습니다", "입력 오류", JOptionPane.ERROR_MESSAGE);
		}
		
		//customerMap.putIfAbsent(key, value);
	}
	
	private void outputCustomer() {
		Writer writer = null;
		
		try {
			writer = new FileWriter("customers.txt",true);
			
			Iterator<String> iter = customerMap.keySet().iterator();
			iter = customerMap.keySet().iterator();
			
			while(iter.hasNext()) {
				writer.write(customerMap.get(iter.next()).toString() + "\r\n");
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
		
		System.out.println("파일 저장이 완료됐습니다.");
	}
}
