package com.edu.vo;
/*
 상품들을 구매하는 고객
 필드로....ssn, name, address, Product[] products
 */
public class Customer {
	private int ssn;
	private String name;
	private String address;
	private Product[] products;
	
	public Customer( ) {}
	
	public Customer(int ssn, String name, String address) {
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	public void changeAddress(String address) {
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}
	public void buyProducts(Product[] products) {
		this.products = products;
	}
	
	
}
