package com.lec.ex12account;

public class AccountMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "홍길동");
		CheckingAccount a2 = new CheckingAccount("222-2222", "성춘향", 2000, "1234-1234-1234-1323");
		CreditLineAccount a3 = new CreditLineAccount("222-2222", "성춘향", 2000, "1234-1234-1234-1323", 10000);
		
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		a1.printAccount();
		a2.pay("1234-1234-1234-1321", 200);
		a2.pay("1234-1234-1234-1323", 300);
		a3.pay("1234-1234-1234-1321", 200);
		a3.pay("1234-1234-1234-1323", 5000);
		
	}
}
