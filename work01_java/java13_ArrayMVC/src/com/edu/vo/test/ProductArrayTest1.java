package com.edu.vo.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

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
		
		for (Product pro : pro1) System.out.println(pro.getProductInfo()); 
		System.out.println();
		for (Product pro : pro2) System.out.println(pro.getProductInfo()); 
	}

}
