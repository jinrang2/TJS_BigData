package com.lec.ex6_account;

public class ATM_card implements Runnable {
	private Account obj;
	private boolean flag=false;
	
	
	
	public ATM_card(Account obj) {
		this.obj = obj;
	}

	@Override
	public void run() {				
		for(int i=0 ;  i<10 ; i++) {
			if(flag) {
				obj.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			} else {
				obj.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
	}

}
