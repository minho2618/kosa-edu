package com.jdbc.test;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.dao.impl.CustomDAOImpl;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOTest {

	public static void main(String[] args) {
		CustomDAOImpl dao = CustomDAOImpl.getInstance();
		
		// Test addCustom
		try {
			System.out.println("Test addCustom");
			dao.addCustom(new Custom(6, "홍길동", "동대문"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// Test removeCustom 
		try {
			System.out.println("Test removeCustom");
			dao.removeCustom(6);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//Test updateCustom
		try {
			System.out.println("Test updateCustom");
			dao.updateCustom(new Custom(2, "김상덕", "알래스카"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// Test getCustomer One
		try {
			System.out.println("Test getCustomer One");
			Custom customer = dao.getCustom(2);
			System.out.println(customer);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Custom> customers = dao.getCustom();
			customers.stream()
					 .forEach((c) -> System.out.println(c));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			System.out.println(e.getMessage());
		}
	}
}
 