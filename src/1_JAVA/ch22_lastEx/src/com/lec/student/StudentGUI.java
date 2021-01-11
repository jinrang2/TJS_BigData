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
		
		btnSnoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		
		btnInput		= new JButton("학생입력");
		btnUpdate 		= new JButton("학생수정");
		btnStudentOut	= new JButton("학생출력");
		btnExpelOut 	= new JButton("제적자출력");
		btnExpel 		= new JButton("제적처리");
		btnExit 		= new JButton("종료");
		
		btnFun2			= new JButton("학과TOPN");
		btnFun3			= new JButton("수강TOPN");
		btnFun4			= new JButton("제적TOPN");
				
		txtPool = new JTextArea(15,60);
		
		txtPool.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("학번", (int)CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		
		jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		
		jpup.add(new JLabel("전공", (int)CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		
		jpup.add(new JLabel("점수", (int)CENTER_ALIGNMENT));
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
			Integer yn = JOptionPane.showConfirmDialog(null, "학사관리 종료", "종료 하시겠습니까?", JOptionPane.YES_NO_OPTION);
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
			txtPool.setText("학번은 입력하고 검색해야지!!!" );
			return;				
		}		
		
		students = dao.selectStudentBySno(sno);		
		
		if (students.isEmpty()) {
			txtPool.setText("없는 학번입니다");
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
				
				txtPool.setText(sno + " 검색 완료");
			}
		}
	}

	public void sNameSearch() {
		String sname = txtSname.getText().trim();
		
		if (sname.isEmpty() ) {
			//JOptionPane.showMessageDialog(null, "포인트를 숫자로 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("이름은 입력하고 검색해야지!!!" );
			return;				
		}		
		
		students = dao.selectStudentBySname(sname);		
		
		if (students.isEmpty()) {
			txtPool.setText("해당 이름의 학생이 없습니다.");
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
				
				txtPool.setText(sname + " 검색 완료");
			}
		} else if (students.size() > 1){
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");
									
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
			//JOptionPane.showMessageDialog(null, "포인트를 숫자로 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("학과는 입력하고 검색해야지!!!" );
			return;				
		}		
		
		students = dao.selectStudentByMname(mname);		
		
		if (students.isEmpty()) {
			txtPool.setText("없는 학번입니다");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");
									
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
			txtPool.setText("학번, 이름, 학과, 점수 모두 입력하셔야 입력 가능" );
			return;
		}
		
		int score = Integer.parseInt(strScore);
		
		StudentDto newStudent = new StudentDto(sno, sname, mname, score, 0);
		
		int result = dao.insertStudent(newStudent);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sname + "님 입력 성공");
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
			txtPool.setText("학번, 이름, 학과, 점수 모두 입력하셔야 수정 가능" );
			return;
		}
		
		int score = Integer.parseInt(strScore);
		
		StudentDto updateStudent = new StudentDto(sno, sname, mname, score, curExpel);
		
		int result = dao.updateStudent(updateStudent);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sname + "님 수정 성공");
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
			txtPool.setText("학생이 없습니다");
			
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");
									
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
			txtPool.setText("결과가 없습니다");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");
			
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
			txtPool.setText("학번은 입력해야지!!!!" );
			return;
		}
		
		int result = dao.updateExpel(sno);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(sno + "님 제적 성공");
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
			//JOptionPane.showMessageDialog(null, "포인트를 숫자로 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
			txtPool.setText("학과는 입력하고 검색해야지!!!" );
			return;				
		}		
		
		students = dao.selectTopnByMname(mname);		
		
		if (students.isEmpty()) {
			txtPool.setText("학과에 학생이 없습니다");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");

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
			txtPool.setText("학과에 학생이 없습니다");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");

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
			txtPool.setText("학과에 학생이 없습니다");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "학번");
			dbcp.add(2, "이름");
			dbcp.add(3, "학과명");
			dbcp.add(4, "점수");

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
		new StudentGUI("학사관리");
	}
	
	
}
