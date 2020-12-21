package com.lec.ex6_account;

public class AccountSyncMain {
	public static void main(String[] args) {
		Account acc = new Account(2000);
		
		Runnable target = new ATM_card(acc);
				
		Thread mom = new Thread(target, "mom");
		Thread dad = new Thread(target, "dad");
		
		mom.start();
		dad.start();
		
	}
}
