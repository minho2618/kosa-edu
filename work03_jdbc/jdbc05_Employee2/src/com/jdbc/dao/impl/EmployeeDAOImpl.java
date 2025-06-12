package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.EmployeeDAO;
import com.jdbc.exception.DMLException;
import com.jdbc.exception.DuplicateNumException;
import com.jdbc.exception.RecordNotFound;
import com.jdbc.vo.Employee;

import config.ServerInfo;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl dao = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {
		System.out.println("Singletone Creating...");
	}
	public static EmployeeDAOImpl getInstance() {
		return dao;
	}
	
	// -- 공통 로직
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connect...");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}

	// -- 비즈니스 로직
	// isExist()----select + insertEmployee()----insert :: 쿼리문을 2번 사용
	// 쿼리문 1번 사용으로 정확한 코드를 구현
	@Override
	public void insertEmployee(Employee emp) throws DuplicateNumException, DMLException {
		// try ~ with resource 구문 사용
		String query = "INSERT INTO employee (num, name, salary, address) VALUES (?,?,?,?)";
		
		try(Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query);) { 
			ps.setInt(1, emp.getNum());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
			System.out.println(ps.executeUpdate()+" 명 등록 성공");
			
		} catch (SQLIntegrityConstraintViolationException e) {
			// 사용자 정의 예외를 우회해서 던짐
			throw new DuplicateNumException(emp.getName() + "님은 이미 등록");
		} catch (SQLException e) {
			throw new DMLException("직원 등록하는 중 문제가 발생했습니다.");
		}
	}

	@Override
	public void removeEmployee(int num) throws RecordNotFound, DMLException {
		String query = "DELETE FROM employee WHERE num=?";
		try (Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query);) {			
			ps.setInt(1, num);
			
			int isDeleted = ps.executeUpdate();
			if (isDeleted == 0) {
				throw new RecordNotFound("해당 사용자는 이미 존재하지 않습니다.");
			}
			
		} catch (SQLException e) {
			throw new DMLException("직원 삭제하는 중 문제가 발생했습니다.");
		}
	}
	
	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			conn = getConnect();
			
			String query = "UPDATE employee SET name=?, salary=?, address=? WHERE num=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getAddress());
			ps.setInt(4, emp.getNum());
			System.out.println(ps.executeUpdate()+" 명 수정 성공");
		} finally {
			
			closeAll(ps, conn);
		}
	}

	@Override
	public List<Employee> selectEmployee() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = getConnect();
		
			String query = "SELECT num, name, salary, address FROM employee";
			ps = conn.prepareStatement(query);
	
			rs= ps.executeQuery();
			while(rs.next())
				employees.add(new Employee(rs.getInt("num"), rs.getString("name"), rs.getDouble("salary"), rs.getString("address")));
		} finally {
			
			closeAll(rs, ps, conn);
		}
		return employees;
	}

	@Override
	public Employee selectEmployee(int num) throws SQLException {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			conn = getConnect();			
			String query = "SELECT num, name, salary, address FROM employee WHERE num=?";
			ps = conn.prepareStatement(query);			
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next())
				emp = new Employee(rs.getInt("num"), rs.getString("name"), rs.getDouble("salary"), rs.getString("address"));
		} finally {
			closeAll(rs, ps, conn);
		}
		return emp;
	}
}