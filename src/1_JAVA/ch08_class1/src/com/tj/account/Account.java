package com.tj.account;

/**
 *  ���� ���� Ŭ����
 *
 *	������  :	���¹�ȣ(accountNo:String)
 *				������  (ownerName:String)
 *				�ܾ�    (balance:int)
 *
 *	�޼ҵ�	: �����ϴ� (void deposit(int money))
 *			  �����ϴ� (void  withdraw(int money))
 *			  �ܾ���ȸ 
 */
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	
	public void deposit(int money) {
		balance += money > 0 ? money : 0; 
	}
	
	public void withdraw(int money) {
		if(balance >= money ) {
			balance -= money;
		}
		else {
			System.out.println("�ܾ׺��� ����");
		}
	}
	
	public void info() {
		System.out.println("���¹�ȣ:"+accountNo+", "+ownerName+"�� �ܾ���"+balance);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
