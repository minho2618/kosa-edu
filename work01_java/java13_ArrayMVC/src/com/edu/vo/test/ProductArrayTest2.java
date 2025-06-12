package com.edu.vo.test;

import com.edu.vo.Customer;
import com.edu.vo.Product;
/*
 * Test 클래스는
 * 1) Scanner로 값 입력받는다.
 * 2) 메소드 호출(서비스 요청)
 * 3) 메소드 동작 후 반환되는 값을 콘솔로 출력
 * 
 * 1), 2), 3) 작업만 있어야 하는데
 * 해당코드에서는 로직이 작동하고 있다...
 * 총 가격, 특정 제품 출력...고가제품 출력...
 * 
 * 기능만을 따로 모아놓은 서비스 클래스를 추가적으로 작성
 * vo ---- service ---- test
 */
public class ProductArrayTest2 {

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

		Customer[] customers = {
				new Customer(111, "정우성", "서울"), 
				new Customer(222, "이정재", "경기")
				};
		
		customers[0].buyProducts(pro1);
		customers[1].buyProducts(pro2);
		
		// 이정재의 총 가격
		int sum = 0;
		for (Product pro : customers[1].getProducts()) {
			sum += pro.getPrice() * pro.getQuantity();
		}
		System.out.printf("%s님의 총 가격: %d\n", customers[1].getName(), sum);
		System.out.println();
		
		System.out.printf("%s님의 구매한 제품명: ", customers[0].getName());
		
		// 정우성의 제품명
		for (Product pro : customers[0].getProducts()) {
			System.out.print(pro.getMaker() + " ");
		}
		
		System.out.println();
		
		System.out.println("-----------------------------------------------------");
		// 정우성의 구매품목 중 1만원 이상의 제품명과 가격을 출력
		System.out.printf("%s님의 구매한 1만원 이상의 제품명과 가격 ", customers[0].getName());
		for (Product pro : customers[0].getProducts()) {
			if (pro.getPrice() >= 10000)
				System.out.print("제품명: " + pro.getMaker() + ", 가격: " + pro.getPrice() + "원");
		}
	}

}
