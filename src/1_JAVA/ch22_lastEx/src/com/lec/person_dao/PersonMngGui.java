package com.lec.person_dao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class PersonMngGui extends JFrame implements ActionListener {
	private	String				title;
	private Container			contentPane;
	private	JPanel				jpup, jpbtn;
	private JTextField 			txtName, txtKor, txtEng, txtMat;
	//private Vector<String> 		jnames;
	private JComboBox<String>	comJob;

	private JButton 			btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea 			txtaPool;
	private JScrollPane 		scrollPane;

	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;	

	public PersonMngGui(String title) throws HeadlessException {
		super(title);
		this.title = title;
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(5,2));
		jpbtn = new JPanel(new FlowLayout());
		
		comJob = new JComboBox<String>(dao.selectJname());
		txtName = new JTextField(20);		
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		
		ImageIcon icon1 = new ImageIcon("icon/write.gif");
		btnInput = new JButton("입력",icon1);
		
		ImageIcon icon2 = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("직업조회",icon2);
		
		btnOutput = new JButton("전체출력");
		btnExit = new JButton("종료");
		
		txtaPool = new JTextArea(10,60);
		scrollPane = new JScrollPane(txtaPool);
						
		jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int)CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int)CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int)CENTER_ALIGNMENT));
		jpup.add(txtEng);		
		jpup.add(new JLabel("수학", (int)CENTER_ALIGNMENT));
		jpup.add(txtMat);		
		
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		
		contentPane.add(jpup);
		contentPane.add(jpbtn);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		setBounds(500,500, 700, 450);
		setResizable(true);
		setVisible(true);
				
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnInput) {
			String name = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			
			if (name.isEmpty() || korStr.isEmpty() || engStr.isEmpty() || matStr.isEmpty() ) {
				//JOptionPane.showMessageDialog(null, "포인트를 숫자로 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
				txtaPool.setText("이름, 직업, 국, 영, 수 모두 입력하셔야 입력 가능" );
				return;				
			}
			
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if (result == PersonDao.SUCCESS) {
				txtaPool.setText(name + "님 입력 성공");
				txtName.setText("");
				comJob.setSelectedIndex(0);					
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
			
			
			
		} else if(e.getSource() == btnSearch) {
			String jname = comJob.getSelectedItem().toString().trim();
			
			person = dao.selectJname(jname);
			txtaPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			
			if (person.isEmpty()) {
				txtaPool.setText(txtaPool.getText()+"해당 직업군의 인원이 없습니다.");
			} else {
				for (PersonDto p: person) {
					txtaPool.append(p.toString()+"\n");
				}
			}
			
		} else if(e.getSource() == btnOutput) {
			
			person = dao.selectAll();
			txtaPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			
			if (person.isEmpty()) {
				txtaPool.setText(txtaPool.getText()+"해당 직업군의 인원이 없습니다.");
			} else {
				for (PersonDto p: person) {
					txtaPool.append(p.toString()+"\n");
				}
			}

		} else if(e.getSource() == btnExit) {
			Integer yn = JOptionPane.showConfirmDialog(null, title + "종료", "종료 하시겠습니까?", JOptionPane.YES_NO_OPTION);
			if (yn == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}		
	}

	public static void main(String[] args) {
		new PersonMngGui("연예인성적관리");
	}
}
