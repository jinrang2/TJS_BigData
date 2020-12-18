package com.lec.ex12account;

/**
 *  
 *
 *	계좌번호(accountNo:String)
 *	소유자  (ownerName:String)
 *	잔액 (balance:int)
 *
 *	예금 (void deposit(int money))
 *	출금 (void  withdraw(int money))
 *	
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
		System.out.println("=====================입    금=====================");
		balance += money > 0 ? money : 0; 
		System.out.println("금액이 입금되었습니다 : "+money+"\t잔고 : "+balance);
		System.out.println("==================================================");
		System.out.println();
	}
	
	public void withdraw(int money) {
		System.out.println("=====================출    금=====================");
		printAccount();
		if(balance >= money ) {
			balance -= money;
			System.out.println("금액이 출금되었습니다 : "+money+"\t잔고 : "+balance);
		}
		else {
			System.out.println("잔액이 부족합니다");
			
		}
		
		System.out.println("==================================================");
		System.out.println();
	}
	
	public void printAccount() {
		
		System.out.println("계좌번호 : "+accountNo+", 이름 :"+ownerName+" 잔액 : "+balance);
		
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
