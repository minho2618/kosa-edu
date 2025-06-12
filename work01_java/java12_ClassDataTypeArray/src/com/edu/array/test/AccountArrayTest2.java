package com.edu.array.test;

import com.edu.array.Account;

public class AccountArrayTest2 {

	public static void main(String[] args) {
		Account[] accounts = new Account[3];

		accounts[0] = new Account(111, "Toss", 10000.0);
		//accounts[1] = new Account(222, "국민", 20000.0);
		accounts[2] = new Account(333, "하나", 30000.0);
		
		System.out.println("accounts 위치값: " + accounts);
		
		for (Account account : accounts) {
			if (account == null)
				continue;
			System.out.println(account.getAccountInfo());
		} 
	}

}
