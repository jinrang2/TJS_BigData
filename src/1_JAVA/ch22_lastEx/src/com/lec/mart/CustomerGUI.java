package com.lec.mart;

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
import com.lec.student.StudentDao;
import com.lec.student.StudentDto;

public class CustomerGUI extends JFrame implements ActionListener  {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	
	private JTextField txtCid, txtCTel, txtCName, txtCPoint, txtCAmount;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCTelSearch, btnCNameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
			
	private JTextArea 			txtPool;
	private JScrollPane 		scrollPane;

	private CustomerDao dao = CustomerDao.getInstance();
	private ArrayList<CustomerDto> customers;	
	
	public CustomerGUI(String title) throws HeadlessException {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(6,3));
		jpbtn = new JPanel(new FlowLayout());		
		

		txtCid = new JTextField(10);
		txtCTel = new JTextField(10);
		txtCName = new JTextField(10);
		txtCPoint = new JTextField(10);
		txtCAmount = new JTextField(10);
		
		comLevelName = new JComboBox<String>(dao.selectLevelNames());
				
		btnCidSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("폰4자리(FULL)검색");
		btnCNameSearch = new JButton("고객 이름 검색");		
		btnBuyWithPoint	= new JButton("포인트로만 구매");
		
		btnBuy		 		= new JButton("물품구매");
		btnLevelNameOutput	= new JButton("등급별출력");
		btnAllOutput	 	= new JButton("전체 출력");
		btnInsert 			= new JButton("회원가입");
		btnCTelUpdate 		= new JButton("번호수정");
		
		btnDelete			= new JButton("회원탈퇴");
		btnExit				= new JButton("나가기");
				
		txtPool = new JTextArea(10,100);
		
		txtPool.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("아 이 디", (int)CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		
		jpup.add(new JLabel("고객전화", (int)CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		
		jpup.add(new JLabel("고객이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		
		jpup.add(new JLabel("포 인 트", (int)CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		
		jpup.add(new JLabel("구매금액", (int)CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel("", (int)CENTER_ALIGNMENT));
		
		jpup.add(new JLabel("고객등급", (int)CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		
		txtPool.setText("★★★고객 검색후 구매하세요★★★");
				
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);		
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		txtPool.setSize(700, 200);
				
		setBounds(500,300, 750, 550);
		setResizable(true);
		setVisible(true);
						
		btnCidSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
				
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new CustomerGUI("슈퍼마켓 관리");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//btnCidSearch, , , ;
		//, , , , , , ;
			
		if(e.getSource() == btnCidSearch) {
			cidSearch();
		} else if (e.getSource() == btnCTelSearch) {
			cTelSearch();
		} else if (e.getSource() == btnCNameSearch) {
			cNameSearch();
		} else if (e.getSource() == btnBuyWithPoint) {
			buyWithPoint();
		} else if (e.getSource() == btnBuy) {
			buy();
		} else if (e.getSource() == btnLevelNameOutput) {
			levelNameOutput();
		} else if (e.getSource() == btnAllOutput) {
			allOutput();
		} else if (e.getSource() == btnInsert) {
			insert();
		} else if (e.getSource() == btnCTelUpdate) {
			telUpdate();
		} else if (e.getSource() == btnDelete) {
			System.out.println(1);
			delete();
			System.out.println(2);
		} else if (e.getSource() == btnExit) {
			Integer yn = JOptionPane.showConfirmDialog(null, "슈퍼마켓관리 종료", "종료 하시겠습니까?", JOptionPane.YES_NO_OPTION);
			if (yn == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		} 
	}
	
	private void clearTextField() {
		txtCid.setText("");
		txtCTel.setText("");
		txtCName.setText("");
		txtCPoint.setText("");
		txtCAmount.setText("");
	}
	
	public void cidSearch() {
		String cid = txtCid.getText().trim();
		
		if (cid.isEmpty()) {
			txtPool.setText("유효한 고객ID를 입력하시고 아이디 검색하세요");			
			return;
		}
		
		customers = dao.selectById(cid);
		
		if (customers.isEmpty()) {
			txtPool.setText("검색되지 않은 ID입니다");
			clearTextField();
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "전화");
			dbcp.add(3, "이름");
			dbcp.add(4, "포인트");
			dbcp.add(5, "구매누적액");
			dbcp.add(6, "고객레벨");
			dbcp.add(7, "다음레벨");		
					
			for (CustomerDto c:customers) {
				txtCid.setText(c.getCid());
				txtCTel.setText(c.getcTel());
				txtCName.setText(c.getcName());
				txtCPoint.setText(c.getcPoint());
				txtCAmount.setText(c.getcAmount());
				
				dbcp.add(1, c.getCid());
				dbcp.add(2, c.getcTel());
				dbcp.add(3, c.getcName());
				dbcp.add(4, c.getcPoint());
				dbcp.add(5, c.getcAmount());
				dbcp.add(6, c.getLevelName());
				dbcp.add(7, c.getNext());
			}
			
			txtPool.setText(dbcp.getPrintStr());			 
		}
	}
	
	public void cTelSearch() {
		String cTel = txtCTel.getText().trim();
		
		if (cTel.isEmpty()) {
			txtPool.setText("★★★고객 검색후 구매하세요★★★");			
			return;
		}
		
		customers = dao.selectByTel(cTel);
		
		if (customers.isEmpty()) {
			txtPool.setText("검색되지 않는 전화번호입니다");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "전화");
			dbcp.add(3, "이름");
			dbcp.add(4, "포인트");
			dbcp.add(5, "구매누적액");
			dbcp.add(6, "고객레벨");
			dbcp.add(7, "다음레벨");		
					
			for (CustomerDto c:customers) {
				txtCid.setText(c.getCid());
				txtCTel.setText(c.getcTel());
				txtCName.setText(c.getcName());
				txtCPoint.setText(c.getcPoint());
				txtCAmount.setText(c.getcAmount());
				
				dbcp.add(1, c.getCid());
				dbcp.add(2, c.getcTel());
				dbcp.add(3, c.getcName());
				dbcp.add(4, c.getcPoint());
				dbcp.add(5, c.getcAmount());
				dbcp.add(6, c.getLevelName());
				dbcp.add(7, c.getNext());
			}
			
			txtPool.setText(dbcp.getPrintStr());			 
		}
	}

	public void cNameSearch() {
		String cName = txtCName.getText().trim();
		
		if (cName.isEmpty()) {
			txtPool.setText("★★★고객 검색후 구매하세요★★★");			
			return;
		}
		
		customers = dao.selectByName(cName);
		
		if (customers.isEmpty()) {
			txtPool.setText("해당 이름의 고객이 검색되지 않습니다. 회원가입 해 주세요");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "전화");
			dbcp.add(3, "이름");
			dbcp.add(4, "포인트");
			dbcp.add(5, "구매누적액");
			dbcp.add(6, "고객레벨");
			dbcp.add(7, "다음레벨");		
					
			for (CustomerDto c:customers) {
				txtCid.setText(c.getCid());
				txtCTel.setText(c.getcTel());
				txtCName.setText(c.getcName());
				txtCPoint.setText(c.getcPoint());
				txtCAmount.setText(c.getcAmount());
				
				dbcp.add(1, c.getCid());
				dbcp.add(2, c.getcTel());
				dbcp.add(3, c.getcName());
				dbcp.add(4, c.getcPoint());
				dbcp.add(5, c.getcAmount());
				dbcp.add(6, c.getLevelName());
				dbcp.add(7, c.getNext());
			}
			
			txtPool.setText(dbcp.getPrintStr());			 
		}
	}
	
	public void buyWithPoint() {
		String cid = txtCid.getText().trim();
		String strPoint = txtCPoint.getText().trim();
		String strSAmount = txtCAmount.getText().trim();
				
		int point = Integer.parseInt(strPoint);
		int amount = Integer.parseInt(strSAmount);
		
		if (amount > point ) {
			txtPool.setText("포인트가 부족하여 포인트로 구매 불가합니다");
			return;
		}
				
		int result = dao.buyPoint(strSAmount, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("포인트로만 구매 성공");
			clearTextField();
		}		
	}
	
	public void buy() {
		String cid = txtCid.getText().trim();		
		String strSAmount = txtCAmount.getText().trim();
		
		int result = dao.buyCache(strSAmount, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("포인트로만 구매 성공");
			clearTextField();
		}
	}
	
	public void levelNameOutput() {
		String levelName = comLevelName.getSelectedItem().toString();
		
		customers = dao.selectByLevelName(levelName);
		Integer i=0;

		DBConsolePrint dbcp = new DBConsolePrint();

		dbcp.add(1, "ID");
		dbcp.add(2, "전화");
		dbcp.add(3, "이름");
		dbcp.add(4, "포인트");
		dbcp.add(5, "구매누적액");
		dbcp.add(6, "고객레벨");
		dbcp.add(7, "다음레벨");

		for (CustomerDto c:customers) {
			dbcp.add(1, c.getCid());
			dbcp.add(2, c.getcTel());
			dbcp.add(3, c.getcName());
			dbcp.add(4, c.getcPoint());
			dbcp.add(5, c.getcAmount());
			dbcp.add(6, c.getLevelName());
			dbcp.add(7, c.getNext());
			i++;
		}

		txtPool.setText(dbcp.getPrintStr());			 
		txtPool.append("총 " + i.toString() + "명" );
	}
	
	public void allOutput() {
		customers = dao.selectByAll();
		
		DBConsolePrint dbcp = new DBConsolePrint();

		dbcp.add(1, "ID");
		dbcp.add(2, "전화");
		dbcp.add(3, "이름");
		dbcp.add(4, "포인트");
		dbcp.add(5, "구매누적액");
		dbcp.add(6, "고객레벨");
		dbcp.add(7, "다음레벨");

		for (CustomerDto c:customers) {
			dbcp.add(1, c.getCid());
			dbcp.add(2, c.getcTel());
			dbcp.add(3, c.getcName());
			dbcp.add(4, c.getcPoint());
			dbcp.add(5, c.getcAmount());
			dbcp.add(6, c.getLevelName());
			dbcp.add(7, c.getNext());
		}

		txtPool.setText(dbcp.getPrintStr());
	}
	
	public void insert() {
		String cTel = txtCTel.getText().trim();		
		String cName = txtCName.getText().trim();
		
		if (cTel.isEmpty() || cName.isEmpty() ) {
			txtPool.setText("전화번호와 이름을 입력후 회원가입이 가능해요");			
			return;
		}
		
		int result = dao.joinCustomer(cTel, cName);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("회원 가입 감사합니다. 포인트 1000점을 회원 가입 선물로 드립니다.");
			txtCPoint.setText("1000");
			comLevelName.setSelectedIndex(0);
		}
	}
	
	public void telUpdate() {
		String cid = txtCid.getText().trim();		
		String cTel = txtCTel.getText().trim();
		
		if (cTel.isEmpty() || cTel.isEmpty() ) {
			txtPool.setText("유효한 고객ID를 검색 후 번호 변경을 하세요. 전화번호도 필수 입력");			
			return;
		}
		
		int result = dao.updateTel(cTel, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("전화 번호가 수정 되었습니다");
			
		}
	}
	
	public void delete() {
		String cTel = txtCTel.getText().trim();
		
		if (cTel.isEmpty() ) {
			txtPool.setText("전화번호가 있어야 회원 탈퇴가 가능합니다.");			
			return;
		}
		
		int result = dao.deleteCustomer(cTel);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(cTel + "님의 회원 탈퇴가 완료되었습니다.");
			
		}
	}
	
	
}

	
