package com.jdbc.test;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.dao.impl.EmployeeDAOImpl;
import com.jdbc.vo.Employee;

import config.ServerInfo;

public class EmployeeDAOTest {

	public static void main(String[] args) {
		EmployeeDAOImpl dao = EmployeeDAOImpl.getInstance();
		
		// 등록 테스트
		try {
			System.out.println("직원 등록");
			dao.insertEmployee(new Employee((short)4, "임꺽정", 3000.25, "남대문"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 수정 테스트
		try {
			System.out.println("직원 수정");
			dao.updateEmployee(new Employee((short)2, "이모작", 2222.22, "여의도"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 삭제 테스트
		try {
			System.out.println("직원 삭제");
			dao.removeEmployee(4);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		// 개별 조회 테스트
		try {
			System.out.println("개별 직원 조회");
			Employee employee = dao.selectEmployee((short)2);
			System.out.println(employee);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 전체 조회 테스트
		try {
			System.out.println("전체 직원 조회");
			List<Employee> employees = dao.selectEmployee();
			employees.stream()
			         .forEach((e) -> System.out.println(e));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	static {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("Driver 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
