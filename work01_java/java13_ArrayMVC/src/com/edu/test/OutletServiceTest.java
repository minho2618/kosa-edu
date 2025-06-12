package com.edu.test;

import com.edu.service.OutletCustomerService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletServiceTest {

	public static void main(String[] args) {
		Product[] pro1 = {
				new Product("신라면", 1000, 5, "농심"), 
				new Product("삼다수생수", 2000, 1, "농심"), 
				new Product("초코파이", 3000, 2, "오리온"), 
				new Product("피존", 5000, 1, "LG생활건강"),
				new Product("RTX5090", 5000000, 1, "엔비디아")
				};
		Product[] pro2 = {
				new Product("테라", 3000, 1, "진로"), 
				new Product("진라면", 1000, 5, "오뚜기"),
				new Product("맥심커피", 5000, 10, "오뚜기")
				};	

		Product[] pro3 = {
				new Product("LG gram", 900000, 1, "LG")
				};
		
		Customer c1 = new Customer(111, "정우성", "방배동");
		Customer c2 = new Customer(222, "이정재", "신사동");		
		Customer c3 = new Customer(333, "이제니", "방배동");	
		
		Customer[] customers = {c1, c2, c3};
		
		
		//Product와 Customer의 Assoctiation(연관)
		customers[0].buyProducts(pro1);
		customers[1].buyProducts(pro2);
		customers[2].buyProducts(pro3);
		
		OutletCustomerService service = new OutletCustomerService();
		
		System.out.println("=== 1. customer[1] 고객이 구매한 제품들 ===");
		Product[] rProd1 = service.getProducts(customers[1]);
		for (Product p : rProd1) {
			System.out.println(p.getProductInfo());
		}
		
		System.out.println("=== 2. customer[0] 고객이 구매한 제품 상품명 ===");
		String[] makers = service.getProductMakers(customers[0]);
		for (String s : makers) {
			System.out.println(s);
		}
		
		System.out.println("=== 3. customer[2] ssn 조회 ===");
		Customer customer = service.findCustomer(customers, 222);
		if (customer != null)
			System.out.println(customer.getName());
		else
			System.out.println("해당 고객 없음");
		
		System.out.println("=== 4. 방배동 거주 고객 조회 ===");
		Customer[] people = service.findCustomer(customers, "방배동");
		for (Customer c : people) {
			System.out.println(c.getName() + " " + c.getAddress());
		}
		
		System.out.println("=== 5. 특정 고객의 구매 목록 중 최고가 조회 ===");
		int max = service.getMaxPrice(customers[0]);
		System.out.println(max);
		
		System.out.println("=== 6. 고객들의 구매 목록 특정 금액 이상의 품목 조회  ===");
		Product[] rProd02 = service.getProductOverPrice(customers, 20000);
		for (Product p : rProd02) {
//			if (p == null)
//				break;
			System.out.println(p.getMaker() + " " + p.getPrice());
		}
		
	}

}
