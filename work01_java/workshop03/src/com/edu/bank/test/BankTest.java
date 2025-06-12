package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Customer james = new Customer("James", "서울");
		Customer tomas = new Customer("Tomas", "경기");
		
		james.setAccount(new Account(sc.nextInt(), sc.next(), sc.nextDouble()));
		
		tomas.setAccount(new Account(sc.nextInt(), sc.next(), sc.nextDouble()));
		
		System.out.println("\n=== 계좌정보 ===");
		System.out.println(james.getCustomerInfo() + ", " + james.getAccount().getAccountInfo());
		System.out.println(tomas.getCustomerInfo() + ", " + tomas.getAccount().getAccountInfo());
		
		james.getAccount().withdraw(10000);		
		james.getAccount().withdraw(30000);
		
		james.getAccount().deposit(20000);
		
		System.out.println("\n=== James 계좌정보 ===");
		System.out.println(james.getCustomerInfo() + ", 최종잔액: " + james.getAccount().getBalance());
		
		sc.close();
	}

}
