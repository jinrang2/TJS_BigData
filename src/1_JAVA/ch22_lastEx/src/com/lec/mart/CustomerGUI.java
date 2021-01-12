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
				
		btnCidSearch = new JButton("���̵� �˻�");
		btnCTelSearch = new JButton("��4�ڸ�(FULL)�˻�");
		btnCNameSearch = new JButton("�� �̸� �˻�");		
		btnBuyWithPoint	= new JButton("����Ʈ�θ� ����");
		
		btnBuy		 		= new JButton("��ǰ����");
		btnLevelNameOutput	= new JButton("��޺����");
		btnAllOutput	 	= new JButton("��ü ���");
		btnInsert 			= new JButton("ȸ������");
		btnCTelUpdate 		= new JButton("��ȣ����");
		
		btnDelete			= new JButton("ȸ��Ż��");
		btnExit				= new JButton("������");
				
		txtPool = new JTextArea(10,100);
		
		txtPool.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("�� �� ��", (int)CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		
		jpup.add(new JLabel("����ȭ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		
		jpup.add(new JLabel("���̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		
		jpup.add(new JLabel("�� �� Ʈ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		
		jpup.add(new JLabel("���űݾ�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel("", (int)CENTER_ALIGNMENT));
		
		jpup.add(new JLabel("�����", (int)CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		
		txtPool.setText("�ڡڡڰ� �˻��� �����ϼ���ڡڡ�");
				
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
		new CustomerGUI("���۸��� ����");
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
			Integer yn = JOptionPane.showConfirmDialog(null, "���۸��ϰ��� ����", "���� �Ͻðڽ��ϱ�?", JOptionPane.YES_NO_OPTION);
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
			txtPool.setText("��ȿ�� ��ID�� �Է��Ͻð� ���̵� �˻��ϼ���");			
			return;
		}
		
		customers = dao.selectById(cid);
		
		if (customers.isEmpty()) {
			txtPool.setText("�˻����� ���� ID�Դϴ�");
			clearTextField();
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "��ȭ");
			dbcp.add(3, "�̸�");
			dbcp.add(4, "����Ʈ");
			dbcp.add(5, "���Ŵ�����");
			dbcp.add(6, "������");
			dbcp.add(7, "��������");		
					
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
			txtPool.setText("�ڡڡڰ� �˻��� �����ϼ���ڡڡ�");			
			return;
		}
		
		customers = dao.selectByTel(cTel);
		
		if (customers.isEmpty()) {
			txtPool.setText("�˻����� �ʴ� ��ȭ��ȣ�Դϴ�");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "��ȭ");
			dbcp.add(3, "�̸�");
			dbcp.add(4, "����Ʈ");
			dbcp.add(5, "���Ŵ�����");
			dbcp.add(6, "������");
			dbcp.add(7, "��������");		
					
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
			txtPool.setText("�ڡڡڰ� �˻��� �����ϼ���ڡڡ�");			
			return;
		}
		
		customers = dao.selectByName(cName);
		
		if (customers.isEmpty()) {
			txtPool.setText("�ش� �̸��� ���� �˻����� �ʽ��ϴ�. ȸ������ �� �ּ���");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "ID");
			dbcp.add(2, "��ȭ");
			dbcp.add(3, "�̸�");
			dbcp.add(4, "����Ʈ");
			dbcp.add(5, "���Ŵ�����");
			dbcp.add(6, "������");
			dbcp.add(7, "��������");		
					
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
			txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���� �Ұ��մϴ�");
			return;
		}
				
		int result = dao.buyPoint(strSAmount, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("����Ʈ�θ� ���� ����");
			clearTextField();
		}		
	}
	
	public void buy() {
		String cid = txtCid.getText().trim();		
		String strSAmount = txtCAmount.getText().trim();
		
		int result = dao.buyCache(strSAmount, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("����Ʈ�θ� ���� ����");
			clearTextField();
		}
	}
	
	public void levelNameOutput() {
		String levelName = comLevelName.getSelectedItem().toString();
		
		customers = dao.selectByLevelName(levelName);
		Integer i=0;

		DBConsolePrint dbcp = new DBConsolePrint();

		dbcp.add(1, "ID");
		dbcp.add(2, "��ȭ");
		dbcp.add(3, "�̸�");
		dbcp.add(4, "����Ʈ");
		dbcp.add(5, "���Ŵ�����");
		dbcp.add(6, "������");
		dbcp.add(7, "��������");

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
		txtPool.append("�� " + i.toString() + "��" );
	}
	
	public void allOutput() {
		customers = dao.selectByAll();
		
		DBConsolePrint dbcp = new DBConsolePrint();

		dbcp.add(1, "ID");
		dbcp.add(2, "��ȭ");
		dbcp.add(3, "�̸�");
		dbcp.add(4, "����Ʈ");
		dbcp.add(5, "���Ŵ�����");
		dbcp.add(6, "������");
		dbcp.add(7, "��������");

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
			txtPool.setText("��ȭ��ȣ�� �̸��� �Է��� ȸ�������� �����ؿ�");			
			return;
		}
		
		int result = dao.joinCustomer(cTel, cName);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("ȸ�� ���� �����մϴ�. ����Ʈ 1000���� ȸ�� ���� ������ �帳�ϴ�.");
			txtCPoint.setText("1000");
			comLevelName.setSelectedIndex(0);
		}
	}
	
	public void telUpdate() {
		String cid = txtCid.getText().trim();		
		String cTel = txtCTel.getText().trim();
		
		if (cTel.isEmpty() || cTel.isEmpty() ) {
			txtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ ������ �ϼ���. ��ȭ��ȣ�� �ʼ� �Է�");			
			return;
		}
		
		int result = dao.updateTel(cTel, cid);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText("��ȭ ��ȣ�� ���� �Ǿ����ϴ�");
			
		}
	}
	
	public void delete() {
		String cTel = txtCTel.getText().trim();
		
		if (cTel.isEmpty() ) {
			txtPool.setText("��ȭ��ȣ�� �־�� ȸ�� Ż�� �����մϴ�.");			
			return;
		}
		
		int result = dao.deleteCustomer(cTel);
		
		if (result == StudentDao.SUCCESS) {
			txtPool.setText(cTel + "���� ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
			
		}
	}
	
	
}

	
