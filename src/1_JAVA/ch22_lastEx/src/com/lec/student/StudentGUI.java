package com.lec.student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lec.att.DBConsolePrint;

public class StudentGUI extends JFrame implements ActionListener {
	
	
	private Container contenPane;
	private JPanel jpup, jpbtn1, jpbtn2;
	
	private	JTextField txtSno;
	private JTextField txtSname;
	private JComboBox<String> comMname;
	private JTextField txtScore;
	
	private JButton btnSnoSearch;
	private JButton btnSNameSearch;
	private JButton btnMNameSearch;
	
	private JButton btnInput;
	private JButton btnUpdate;
	private JButton btnStudentOut;
	private JButton btnExpelOut;
	private JButton btnExpel;
	private JButton btnExit;
	
	private JButton	btnFun2;
	private JButton	btnFun3;
	private JButton	btnFun4;
	
	private JTextArea 			txtPool;
	private JScrollPane 		scrollPane;

	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> students;	
	
	private	int 	curExpel;
	
	
	public StudentGUI(String title) throws HeadlessException {
		super(title);		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contenPane = getContentPane();
		//contenPane.setLayout(new FlowLayout());
		contenPane.setLayout(new BorderLayout());

		jpup = new JPanel(new GridLayout(5,2));
		jpbtn1 = new JPanel(new FlowLayout());
		jpbtn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		comMname = new JComboBox<String>(dao.selectMname());
		txtScore = new JTextField(10);
		
		btnSnoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		
		btnInput		= new JButton("�л��Է�");
		btnUpdate 		= new JButton("�л�����");
		btnStudentOut	= new JButton("�л����");
		btnExpelOut 	= new JButton("���������");
		btnExpel 		= new JButton("����ó��");
		btnExit 		= new JButton("����");
		
		btnFun2			= new JButton("�а�TOPN");
		btnFun3			= new JButton("����TOPN");
		btnFun4			= new JButton("����TOPN");
				
		txtPool = new JTextArea(15,60);
		
		txtPool.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("�й�", (int)CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		
		jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		jpbtn1.add(btnInput);
		jpbtn1.add(btnUpdate);
		jpbtn1.add(btnStudentOut);
		jpbtn1.add(btnExpelOut);
		jpbtn1.add(btnExpel);
		jpbtn1.add(btnExit);
		
		jpbtn2.add(btnFun2);
		jpbtn2.add(btnFun3);
		jpbtn2.add(btnFun4);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn1);
		contenPane.add(jpbtn2);
		contenPane.add(scrollPane, BorderLayout.SOUTH);
		
		setBounds(500,300, 600, 700);
		setResizable(true);
		setVisible(true);
				
		btnSnoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);		
		btnExit.addActionListener(this);
		
		btnFun2.addActionListener(this);
		btnFun3.addActionListener(this);
		btnFun4.addActionListener(this);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSnoSearch) {
			snoSearch();
		} else if(e.getSource() == btnSNameSearch) {
			sNameSearch();
		} else if(e.getSource() == btnMNameSearch) {
			mNameSearch();
		} else if(e.getSource() == btnInput) {
			insertStudent();
		} else if(e.getSource() == btnUpdate) {
			updateStudent();
		} else if(e.getSource() == btnStudentOut) {
			selectAllStudent();
		} else if(e.getSource() == btnExpelOut) {
			selectExpel();
		} else if(e.getSource() == btnExpel) {
			UpdateExpel();
		} else if(e.getSource() == btnExit) {
			Integer yn = JOptionPane.showConfirmDialog(null, "�л���� ����", "���� �Ͻðڽ��ϱ�?", JOptionPane.YES_NO_OPTION);
			if (yn == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		} else if(e.getSource() == btnFun2) {
			selectTopnMname();
		} else if(e.getSource() == btnFun3) {
			selectTopnExpel0();
		} else if(e.getSource() == btnFun4) {
			selectTopnExpel1();
		}		
	}
	

	public void snoSearch() {
		String sno = txtSno.getText().trim();
		
		if (sno.isEmpty() ) {
			txtPool.setText("�й��� �Է��ϰ� �˻��ؾ���!!!" );
			return;				
		}		
		
		students = dao.selectStudentBySno(sno);		
		
		if (students.isEmpty()) {
			txtPool.setText("���� �й��Դϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			for (StudentDto s: students) {
				txtSno.setText(s.getSno());
				txtSname.setText(s.getSname());
				comMname.setSelectedItem(s.getMname());
				txtScore.setText(Integer.toString(s.getScore()));
				curExpel = s.getSexpel();
				
				txtPool.setText(sno + " �˻� �Ϸ�");
			}
		}
	}

	public void sNameSearch() {
		String sname = txtSname.getText().trim();
		
		if (sname.isEmpty() ) {
			//JOptionPane.showMessageDialog(null, "����Ʈ�� ���ڷ� �Է��ϼ���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("�̸��� �Է��ϰ� �˻��ؾ���!!!" );
			return;				
		}		
		
		students = dao.selectStudentBySname(sname);		
		
		if (students.isEmpty()) {
			txtPool.setText("�ش� �̸��� �л��� �����ϴ�.");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else if (students.size() == 1){
			for (StudentDto s: students) {
				txtSno.setText(s.getSno());
				txtSname.setText(s.getSname());
				comMname.setSelectedItem(s.getMname());
				txtScore.setText(Integer.toString(s.getScore()));
				curExpel = s.getSexpel();
				
				txtPool.setText(sname + " �˻� �Ϸ�");
			}
		} else if (students.size() > 1){
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");
									
			for (StudentDto s: students) {
				dbcp.add(1, s.getSno());
				dbcp.add(2, s.getSname());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());				
			}
			
			txtPool.setText(dbcp.getPrintStr());
		}
	}

	public void mNameSearch() {
		String mname = comMname.getSelectedItem().toString();
		
		if (mname.isEmpty() ) {
			//JOptionPane.showMessageDialog(null, "����Ʈ�� ���ڷ� �Է��ϼ���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("�а��� �Է��ϰ� �˻��ؾ���!!!" );
			return;				
		}		
		
		students = dao.selectStudentByMname(mname);		
		
		if (students.isEmpty()) {
			txtPool.setText("���� �й��Դϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");
									
			for (StudentDto s: students) {
				dbcp.add(1, s.getSno());
				dbcp.add(2, s.getSname());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());				
			}
			
			txtPool.setText(dbcp.getPrintStr());
		}
	}

	public void insertStudent() {
		String sno = txtSno.getText().trim();
		String sname = txtSname.getText().trim();
		String mname = comMname.getSelectedItem().toString();
		String strScore= txtScore.getText().trim();
		
		if (sno.isEmpty() || sname.isEmpty() || strScore.isEmpty()) {
			txtPool.setText("�й�, �̸�, �а�, ���� ��� �Է��ϼž� �Է� ����" );
			return;
		}
		
		int score = Integer.parseInt(strScore);
		
		StudentDto newStudent = new StudentDto(sno, sname, mname, score, 0);
		
		int result = dao.insertStudent(newStudent);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sname + "�� �Է� ����");
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedIndex(0);					
			txtScore.setText("");			
			curExpel = 0;
		}
				
	}

	public void updateStudent() {
		String sno = txtSno.getText().trim();
		String sname = txtSname.getText().trim();
		String mname = comMname.getSelectedItem().toString();
		String strScore= txtScore.getText().trim();
		
		if (sno.isEmpty() || sname.isEmpty() || strScore.isEmpty()) {
			txtPool.setText("�й�, �̸�, �а�, ���� ��� �Է��ϼž� ���� ����" );
			return;
		}
		
		int score = Integer.parseInt(strScore);
		
		StudentDto updateStudent = new StudentDto(sno, sname, mname, score, curExpel);
		
		int result = dao.updateStudent(updateStudent);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sname + "�� ���� ����");
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedIndex(0);					
			txtScore.setText("");			
			curExpel = 0;
		}
	}

	public void selectAllStudent() {
		students = dao.selectStudentAll();		
		
		if (students.isEmpty()) {
			txtPool.setText("�л��� �����ϴ�");
			
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");
									
			for (StudentDto s: students) {
				dbcp.add(1, s.getSno());
				dbcp.add(2, s.getSname());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());				
			}
			
			txtPool.setText(dbcp.getPrintStr());
		}
	}

	public void selectExpel() {
		students = dao.selectTopnByEx(1);	
		
		if (students.isEmpty()) {
			txtPool.setText("����� �����ϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");
			
			for (StudentDto s: students) {
				dbcp.add(1, s.getRank());
				dbcp.add(2, s.getNameno());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());
			}
			
			txtPool.setText(dbcp.getPrintStr());
		}
	}

	public void UpdateExpel() {
		String sno = txtSno.getText().trim();
		
		if (sno.isEmpty()) {
			txtPool.setText("�й��� �Է��ؾ���!!!!" );
			return;
		}
		
		int result = dao.updateExpel(sno);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sno + "�� ���� ����");
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedIndex(0);					
			txtScore.setText("");			
			curExpel = 0;
		}
	}

	public void selectTopnMname() {
		String mname = comMname.getSelectedItem().toString();
		
		if (mname.isEmpty() ) {
			//JOptionPane.showMessageDialog(null, "����Ʈ�� ���ڷ� �Է��ϼ���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("�а��� �Է��ϰ� �˻��ؾ���!!!" );
			return;				
		}		
		
		students = dao.selectTopnByMname(mname);		
		
		if (students.isEmpty()) {
			txtPool.setText("�а��� �л��� �����ϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");

			for (StudentDto s: students) {
				dbcp.add(1, s.getRank());
				dbcp.add(2, s.getNameno());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());
			}

			txtPool.setText(dbcp.getPrintStr());
		}
	}

	public void selectTopnExpel0() {
		
		students = dao.selectTopnByEx(0);		
		
		if (students.isEmpty()) {
			txtPool.setText("�а��� �л��� �����ϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");

			for (StudentDto s: students) {
				dbcp.add(1, s.getRank());
				dbcp.add(2, s.getNameno());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());
			}

			txtPool.setText(dbcp.getPrintStr());
		}
	}
	
	public void selectTopnExpel1() {
		students = dao.selectTopnByEx(1);		
		
		if (students.isEmpty()) {
			txtPool.setText("�а��� �л��� �����ϴ�");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "�й�");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "�а���");
			dbcp.add(4, "����");

			for (StudentDto s: students) {
				dbcp.add(1, s.getRank());
				dbcp.add(2, s.getNameno());
				dbcp.add(3, s.getMname());
				dbcp.add(4, s.getScore());
			}

			txtPool.setText(dbcp.getPrintStr());
		}
	}	
	
	public static void main(String[] args) {
		new StudentGUI("�л����");
	}
	
	
}
