package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.EmployeeDAO;
import com.jdbc.vo.Employee;

import config.ServerInfo;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl dao = new EmployeeDAOImpl();
	
	private EmployeeDAOImpl() {
		
	}
	
	public static EmployeeDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB 연결 성공");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if(conn != null)
			conn.close();		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void insertEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "INSERT INTO employee (num, name, salary, address) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setShort(1, emp.getNum());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
			System.out.println(ps.executeUpdate() == 0 ? "등록 실패" : "등록 성공");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void removeEmployee(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "DELETE FROM employee WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setShort(1, (short)num);
			System.out.println(ps.executeUpdate() == 0 ? "삭제 실패" : "삭제 성공");
		} finally {
			closeAll(ps, conn);
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
			ps.setShort(4, emp.getNum());
			System.out.println(ps.executeUpdate() == 0 ? "수정 실패" : "수정 성공");
		} finally {
			closeAll(ps, conn);
		}		
	}

	@Override
	public List<Employee> selectEmployee() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT num, name, salary, address FROM employee";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getShort(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
		} finally {
			closeAll(ps, conn);
		}
		
		return employees;
	}

	@Override
	public Employee selectEmployee(int num) throws SQLException {
		Employee employees = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT num, name, salary, address FROM employee WHERE num=?";
			ps = conn.prepareStatement(query);
			ps.setShort(1, (short) num);
			rs = ps.executeQuery();
			if (rs.next()) {
				employees = new Employee(rs.getShort(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
			}
		} finally {
			closeAll(ps, conn);
		}
		
		return employees;
	}

}
