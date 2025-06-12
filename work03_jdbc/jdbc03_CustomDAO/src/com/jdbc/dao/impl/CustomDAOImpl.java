package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.CustomDAO;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOImpl implements CustomDAO {
	// 싱글톤 패턴
	private static CustomDAOImpl dao = new CustomDAOImpl();
	
	private CustomDAOImpl() {
		System.out.println("singletone...creating...");
	}
	
	public static CustomDAOImpl getInstance() {
		return dao;
	}
	
	// 공통 로직 //
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		
		return conn;
	}
	
	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}
	
	private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	
	// 비즈니스 로직 //
	@Override
	public void addCustom(Custom custom) throws SQLException { // 회원가입
		/*
		 * 1. DB에 연결...Connection을 반환받기
		 * 2. PreparaedStatement 생성...sql문 인자값
		 * 3. Custom 객체로 쿼리를 바인딩하고 실행
		 * 4. 자원반환
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "INSERT INTO custom (id, name, address) VALUES (?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, custom.getId());
			ps.setString(2, custom.getName());
			ps.setString(3, custom.getAddress());
			System.out.println(ps.executeUpdate() + "명 등록 성공");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void removeCustom(int id) throws SQLException { // 회원탈퇴
		/*
		 * 1. DB에 연결
		 * 2. PreparaedStatement로 쿼리를 컴파일
		 * 3. pk로 쿼리를 바인딩하고 실행
		 * 4. ps, db 연결 해제
		 */		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "DELETE FROM custom WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			System.out.println(ps.executeUpdate() + "명 삭제 성공");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustom(Custom custom) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			
			String query = "UPDATE custom SET name=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, custom.getName());
			ps.setString(2, custom.getAddress());
			ps.setInt(3, custom.getId());
			
			System.out.println(ps.executeUpdate() + "명 수정 성공");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public Custom getCustom(int id) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Custom custom = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT id, name, address FROM custom WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				custom = new Custom(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
			}			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return custom;
	}

	@Override
	public List<Custom> getCustom() throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Custom> customers = new ArrayList<>();
		
		try {
			conn = getConnect();
			
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				customers.add(new Custom(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			}			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customers;
	}
	
}
