package com.edu.bank;

public class Customer {
	private String name;
	private String address;
	
	private Account account;
	
	public Customer() {}
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getCustomerInfo() {
		return "이름: " + name + ", 주소: " + address;
	}
}
