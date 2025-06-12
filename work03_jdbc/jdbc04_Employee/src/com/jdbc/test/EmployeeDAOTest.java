package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.impl.EmployeeDAOImpl;
import com.jdbc.exception.DuplicateNumException;
import com.jdbc.exception.RecordNotFound;
import com.jdbc.vo.Employee;

import config.ServerInfo;

public class EmployeeDAOTest {

	public static void main(String[] args) {
		EmployeeDAOImpl dao = EmployeeDAOImpl.getInstance();
		
		// insertEmployee
//		try {
//			System.out.println(dao.isExist(99));
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}

		// insertEmployee
		try {
			dao.insertEmployee(new Employee(1, "이지금", 7000.0, "강북구"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateNumException e) {
			System.out.println(e.getMessage());
		}
		
		// removeEmployee
		
		try {
			dao.removeEmployee(66);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// updateEmployee
		/*
		try {
			dao.updateEmployee(new Employee(2, "이지금", 7000.0, "강북구"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		*/
//		// selectEmployee()
//		try {
//			dao.selectEmployee().stream().forEach(e->System.out.println(e));
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		// selectEmployee(int)
//		try {
//			System.out.println(dao.selectEmployee(2));
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
	}

	static {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}