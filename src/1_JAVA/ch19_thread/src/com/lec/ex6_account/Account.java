package com.lec.ex6_account;

public class Account {
	private int balance;
	
	public Account() {}

	public Account(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int amount, String who) {
		amount = amount < 0 ? 0 : amount; 
		
		System.out.println(who+"가 입금 시작★★★");
		System.out.println("입금전 잔액 : " + balance);
		balance += amount;
		System.out.println(amount+"원 입금 후 잔액"+balance);
		System.out.println(who+"가 입금 끝★★★");
		System.out.println();
	}
	
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who+"가 출금 시작★★★");
		System.out.println("출금전 잔액 : " + balance);
		if(amount > balance) {
			System.out.println("떽");
		} else {
			balance -= amount;
		}
		System.out.println(amount+"원 출금 후 잔액"+balance);
		System.out.println(who+"가 입금 끝★★★");
		System.out.println();
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
