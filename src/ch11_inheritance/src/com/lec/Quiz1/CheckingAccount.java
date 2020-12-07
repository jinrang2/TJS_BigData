package com.lec.Quiz1;

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	
	public boolean chkCardNo(String cardNo) {
		if( !this.cardNo.equals(cardNo) ) {
			System.out.println("카드 번호가 틀립니다. 카드번호를 확인해주세요.");
			System.out.println("입력한 카드번호 : "+cardNo);
			System.out.println("소유한 카드번호 : "+this.cardNo);
			return false;
		}
		
		return true;
	}
	
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드번호 : "+cardNo);
	}
	
	public void pay(String cardNo, int amount) {
		if( chkCardNo(cardNo) ) {
			withdraw(amount);
		} 
		
		printAccount();
	}
}
