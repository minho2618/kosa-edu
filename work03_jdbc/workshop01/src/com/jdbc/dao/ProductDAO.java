package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class ProductDAO {
	public ProductDAO() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection...Success");
		
		String insertQuery = "INSERT INTO product (no, pname, maker, price) VALUES (?, ?, ?, ?)";
		String deleteQuery = "DELETE FROM product WHERE no=?";
		PreparedStatement ps = conn.prepareStatement(insertQuery);
		
		insert(ps, 1, "Thinkpad", "Lenovo", 499.99);
		insert(ps, 2, "Zenbook", "ASUS", 399.50);
		insert(ps, 3, "Gram", "LG", 999.99);
		
		ps = conn.prepareStatement(deleteQuery);
		ps.setInt(1, 3);
		System.out.println(ps.executeUpdate() + " ROW UPDATE SUCCESS");
	}
	
	private void insert(PreparedStatement ps, int no, String pname, String maker, double price) throws SQLException {
		ps.setInt(1, no);
		ps.setString(2, pname);
		ps.setString(3, maker);
		ps.setDouble(4, price);
		System.out.println(ps.executeUpdate() + " ROW UPDATE SUCCESS");
	}
}
