package com.edu.service;

import java.util.Arrays;

/*
 * 1. 서비스의 기능들을 주석으로 먼저 달아둔다
 * 2. 모든 기능의 선언부만 먼저 작성한다...
 *    메소드이름, 인자값, 반환타입
 *    인자값과 반환타입은 받드시 정확해야한다.
 *    
 * 3. 메소드를 하나만 먼저 구현한다.
 * 4. 테스트에서 호출해서 잘 작성이 되었는지 확인...
 *    다음 메소드 작성으로 넘어간다...반복
 */

import com.edu.vo.Customer;
import com.edu.vo.Product;

/*
 * Outlet에서 상품들을 구매하는 고객관련 기능들만 모아놓은 서비스 클래스
 * 데이터베이스와 연결되면 이후에 이 클래스는 DAO(Data Access Object)
 * VO, TEST 클래스 중간에 위치함으로 해당 클래스는 Controller 역할을 여기서 한다.
 */
public class OutletCustomerService {
	// 1. 특정 고객이 구매한 모든 상품을 반환하는 기능
	public Product[] getProducts(Customer customer) {
		return customer.getProducts();
	}
	
	// 2. 특정 고객이 구매한 모든 상품의 메이커만 반환하는 기능
	public String[] getProductMakers(Customer customer) {
		String[] temp = new String[customer.getProducts().length];
		
		int idx = 0;
		for (Product p : customer.getProducts()) {
			temp[idx++] = p.getMaker();
		}
		
		return temp;
	}
	
	/*
	 * Method Overloading Rule(규칙, 문법)
	 * 1. 메소드 이름은 반드시 같아야 한다.
	 * 2. 메소드 인자값은 반드시 달라야 한다.
	 * (순서, 갯수, 타입 중 하나라도 달라야 한다.)
	 * 3. 메소드 리턴 타입은 상관없다.
	 * 
	 * 하는 일이 같지만(메소드 이름이 같다) 처리하는 데이터를 달리하는 기법
	 * 결론적으로 코드의 가독성을 높이는데 중요한 역할을 하는 기업
	 */
	
	// 3. Outlet 안에 있는 고객들 중 특정고객을 검색하는 기능
	// for 문에서 특정한 대상을 발견
	public Customer findCustomer(Customer[] customers, int ssn) {
		Customer temp = null;
		
		for (Customer c : customers) {
			if (c.getSsn() == ssn) {
				temp = c;
				break;
			}
		}
		
		return temp;
	}
	
	// 4. Outlet 안에 있는 고객들 중에서 "혜화동"에 거주하는 고객을 검색하는 기능
	public Customer[] findCustomer(Customer[] customers, String address) {
		Customer[] temp = new Customer[customers.length];
		
		int idx = 0;
		for (Customer c : customers) {
			if (c.getAddress().equals(address)) {
				temp[idx++] = c;
			}
		}
		
		//return temp;
		return Arrays.copyOf(temp, idx);
	}
	
	// 5. 특정 고객이 구입한 물건 중에서 최고가에 해당하는 물건의 가격을 반환
	public int getMaxPrice(Customer customer) {
		int maxPrice = 0;
		
		for (Product p : customer.getProducts()) {
			if (maxPrice < p.getPrice())
				maxPrice = p.getPrice();
		}
		
		return maxPrice;
	}
	
	// 6. 모든 고객이 구입한 물건 중에서 특정 가격 이상되는 상품을 반환
	public Product[] getProductOverPrice(Customer[] customers, int price) {
		int count = 0;
		for (Customer c : customers) {
			for (Product p : c.getProducts()) {
				if (p.getPrice() >= price) {
					count += 1;
				}
			}
		}
		
		Product[] temp = new Product[count];
		
		int idx = 0;
		for (Customer c : customers) {
			for (Product p : c.getProducts()) {
				if (p.getPrice() >= price) {
					temp[idx++] = p;
				}
			}
		}
		
		return temp;		
	}
}
