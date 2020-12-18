package com.lec.ex3_exceptionExs;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {}
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	
	
	@Override
	public String toString() {
		return "계좌번호 : " + accountNo + ", 예금주 : " + ownerName + 
				", 잔액  : " + balance;
	}

	public void deposit(int amount){
		System.out.println("예금전 : " + this);
		balance += ( amount > 0 ? amount : 0);		
		System.out.println("예금후 : " + this);
	}
	
	public void withrow(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception(amount+"원 출금하기에는 잔액("+balance+")이 부족합니다");
		}
		System.out.println("출금전 : "+this);
		
		balance -= amount;
				
		System.out.println(amount +"원 출금후 : "+this);
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
