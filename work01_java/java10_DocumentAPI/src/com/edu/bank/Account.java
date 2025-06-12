package com.edu.bank;
/**
 * <pre>
 * {@code
 * Account 클래스는 계좌 관련된 정보를 가지고 있는 클래스
 * 해당 클래스에서는 Java Document 주석을 달아서 처리했다
 * 아래에서 사용된 주석은 가장 많이 사용되는 주석이다.
 * }
 * </pre>
 * 
 * @author LEE MIN HO
 * @version project version 1.0.2
 * @since JDK17
 * 
 */
public class Account {
	/**
	 * 계좌번호 12자리 정수형
	 */
	private int accNumber;
	/**
	 * 은행명
	 */
	private String bankName;
	/**
	 * 계좌에 남아있는 잔액
	 * 계좌를 개설할 때 최초 입금금액
	 */
	private double balance;
	
	/**
	 * 기본생성자
	 */
	public Account() {}
	/**
	 * 명시적 생성자
	 * @param accNumber 계좌번호
	 * @param bankName 은행명
	 * @param balance 잔액
	 */
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	/**
	 * 
	 * @param amt 출금할 일정금액
	 * 특정금액을 출금하는 기능
	 * 잔액보다 더 큰 금액이 출금될시 예외 발생
	 */
	public void withdraw(double amt) {
		balance -= amt;
	}
	
	/**
	 * 
	 * @param amt 입금할 일정금액
	 * 특정금액을 입금하는 기능
	 * 1천원 이상의 금액만 입금가능
	 */
	public void deposit(double amt) {
		balance += amt;
	}
	
	/**
	 * 
	 * @return 통장정보(계좌번호, 은행명, 잔액)을 문자열로 반환
	 */
	public String getAccountInfo() {
		return "계좌번호: " + accNumber + ", 은행명: " + bankName + ", 잔액: " + balance;
	}
	
	/**
	 * 
	 * @return 잔액을 반환
	 */
	public double getBalance() {
		return balance;
	}
}
