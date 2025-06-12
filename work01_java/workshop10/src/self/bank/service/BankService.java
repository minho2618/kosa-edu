package self.bank.service;

import self.bank.vo.Customer;

/*
 * SingleTone Pattern
 * 하나의 클래스로부터 오직 하나의 인스턴스가 생성되도록 하는 패턴
 */

public class BankService {
	public static final int MAX_CUSTOMERS = 100;
	public int numberOfCustomers = 0;
	private Customer[] customers = null;
	
	private static BankService bankService = new BankService();
	
	private BankService() {
		customers = new Customer[MAX_CUSTOMERS];
	}
	
	public static BankService getInstance() {
		return bankService;
	}

	public void addCustomer(Customer customer) {
		if (numberOfCustomers < MAX_CUSTOMERS) {
			customers[numberOfCustomers++] = customer;
			System.out.println(customer.getName() + "님이 등록되었습니다.");
			System.out.println(MAX_CUSTOMERS - numberOfCustomers + "명을 추가등록할 수 있습니다.");
		}			
		else {		
			System.out.println("더 이상 고객을 추가할 수 없습니다.");
			return;
		}
	}
	
	public Customer getCustomer(int ssn) {
		Customer result = null;
		
		for (Customer c : customers) {
			if (c == null)
				break;
			
			if (c.getSsn() == ssn) {
				result = c;
				break;
			}				
		}
		
		return result;
	}
	
	public void showAll() {
		for (Customer c : customers) {
			if (c == null) {
				System.out.println("등록된 고객이 없습니다.");
				break;
			}
			
			System.out.println(c);			
		}
	}
}
