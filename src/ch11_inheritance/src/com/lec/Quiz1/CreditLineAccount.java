package com.lec.Quiz1;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	
	@Override
	public void printAccount() {
		super.printAccount();
		printCardInfo();
	}
	
	public void printCardInfo() {
		System.out.println("카드한도 : "+ creditLine);
	}

	@Override
	public void pay(String cardNo, int amount) {
		if( chkCardNo(cardNo) ) {
			if(creditLine >= amount ) {
				creditLine -= amount;
				System.out.println("카드가 결제 되었습니다 : "+amount);
			} 
			else {
				System.out.println("카드 한도가 부족합니다");
			}
		}
		
		//printAccount();
	}
	
	
}
