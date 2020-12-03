package com.tj.account;

/**
 *  은행 계좌 클래스
 *
 *	데이터  :	계좌번호(accountNo:String)
 *				예금주  (ownerName:String)
 *				잔액    (balance:int)
 *
 *	메소드	: 예금하다 (void deposit(int money))
 *			  인출하다 (void  withdraw(int money))
 *			  잔액조회 
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
			System.out.println("잔액부족 떼끼");
		}
	}
	
	public void info() {
		System.out.println("계좌번호:"+accountNo+", "+ownerName+"님 잔액은"+balance);
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
