package com.edu.bank.test;
// workshop08
import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest2 {

	public static void main(String[] args) {
		int customerNum = 0;
		Customer[] customers = null;
		Account[] accounts= null;
		boolean run = true; // flag 값
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1. 고객 수 | 2. 고객 정보 입력 | 3. 계좌 개설 | 4. 정보 출력 | 5. 종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("메뉴 선택 >> ");
			
			int menu = sc.nextInt();
			switch(menu) {
			case 1: // 고객 수
				customerNum = inputCustomerNum();
				break;
			case 2: // 고객 정보 입력
				customers = inputCustomerInfo(customerNum);
				break;
			case 3: // 계좌 개설
				accounts = makeAccount(customers);
				break; // 정보 출력
			case 4: // 정보 출력
				getInfo(customers);
				break;
			case 5:
				run = false;
			}
		}
		System.out.println("프로그램을 종료합니다.");	
	}//main
	
	private static int inputCustomerNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("고객 수 입력 >>");
		int customerNum = sc.nextInt();
		return customerNum;
	}
	private static Customer[] inputCustomerInfo(int customerNum) {
		Scanner sc = new Scanner(System.in);
		Customer[] customers = new Customer[customerNum];
		System.out.println("고객 정보 입력 >>");
		for(int i=0; i<customerNum; i++) {
			System.out.println(i+1+"번 고객 정보 입력 (이름 주소) >> ");
			customers[i] = new Customer(sc.next(), sc.next());
		}
		return customers;
	}
	private static Account[] makeAccount(Customer[] customers) {
		Scanner sc = new Scanner(System.in);
		int customerNum = customers.length;
		Account[] accounts = new Account[customerNum];
		System.out.println("계좌 정보 입력 >>");
		for(int i=0; i<customerNum; i++) {
			System.out.println(customers[i].getCustomerName()+"님 계좌 번호, 은행명, 잔액 입력 >> ");
			accounts[i] = new Account(sc.nextInt(), sc.next(), sc.nextDouble());
			customers[i].setAccount(accounts[i]);
		}
		return accounts;
	}
	private static void getInfo(Customer[] customers) {
		Scanner sc = new Scanner(System.in);
		int customerNum = customers.length;
		for(int i=0; i<customerNum; i++) {
			System.out.println(customers[i].getCustomerName()+"님 계좌 정보입니다.");
			System.out.println(customers[i].getCustomerInfo());
			System.out.println(customers[i].getAccount().getAccountInfo());
			System.out.println("===========================");
		}
	}
}