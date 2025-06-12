package com.edu.bank;

public class Account {
	private int accNumber;
	private String bankName;
	private double balance;
	
	public Account() {}
	
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	public void withdraw(double amt) {
		balance += amt;
	}
	
	public void deposit(double amt) {
		balance -= amt;
	}
	
	public String getAccountInfo() {
		return "계좌번호: " + accNumber + ", 은행명: " + bankName + ", 잔액: " + balance;
	}
	
	public double getBalance() {
		return balance;
	}
}
