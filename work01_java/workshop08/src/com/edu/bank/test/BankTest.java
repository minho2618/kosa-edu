package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		boolean isRunning = true;
		Customer[] customers = null;
		Customer customer = null;
		
		while (isRunning) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1. 고객수 | 2. 고객 정보 입력 | 3. 계좌 개설 | 4. 정보 출력 | 5. 종료");
			System.out.println("-------------------------------------------------------------");
			System.out.print("메뉴 선택> ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				customers = countCustomer();
				break;
			case 2:
				System.out.println("고객 정보 입력 >>> ");			
				customers = inputCustomerInfo(customers);
				break;
			case 3:
				System.out.println("계좌 정보 입력 >>> ");
				customers = inputCustomerAccount(customers);
				break;
			case 4:
				printCustomer(customers);
				break;
			case 5:
				isRunning = false;
				break;
			default:
				System.out.println("다시 입력하시오.");
			}
		}
		
		System.out.print("프로그램을 종료합니다....");
		
		sc.close();
	}

	
	private static Customer[] countCustomer() {
		System.out.print("고객수 입력 >>> ");
		Scanner sc = new Scanner(System.in);
		
		int customer = sc.nextInt();		
		Customer[] customers = new Customer[customer];
		
		return customers;
	}
	
	private static Customer[] inputCustomerInfo(Customer[] customers) {
		Scanner sc = new Scanner(System.in);
		Customer[] tmpCustomers = customers;
		
		int idx = 0;
		for (Customer person : tmpCustomers) {
			System.out.printf("%d번 계좌번호,은행명,잔액입력 >>", idx + 1);
			String customerName = sc.next();
			String customerAddress = sc.next();
			
			tmpCustomers[idx++] = new Customer(customerName, customerAddress);
		}
		
		return tmpCustomers;
	}
	
	private static Customer[] inputCustomerAccount(Customer[] customers) {
		Scanner sc = new Scanner(System.in);
		Customer[] tmpCustomers = customers;
		
		int idx = 0;
		for (Customer person : tmpCustomers) {
			System.out.printf("%s님 계좌번호, 은행명, 잔액 입력\n", person.getCustomerName());
			int customerAccNum = sc.nextInt();
			String customerBankName = sc.next();
			double customerBalance = sc.nextDouble();
			
			person.setAccount(new Account(customerAccNum, customerBankName, customerBalance));
			
			tmpCustomers[idx++] = person;
		}	
		
		return tmpCustomers;
	}
	
	private static void printCustomer(Customer[] customers) {
		for (Customer person : customers) {
			System.out.printf("%s님 고객 정보입니다.\n", person.getCustomerName());
			System.out.println(person.getCustomerInfo());
			System.out.println(person.getAccount().getAccountInfo());
			System.out.println("===================================");
		}
	}
}
