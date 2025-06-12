package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class CustomDAO {
	public CustomDAO() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connect...");
		
		String query = "INSERT INTO custom (id, name, address) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, 5);
		ps.setString(2, "염혜경");
		ps.setString(3, "제주 애월읍");
		System.out.println(ps.executeUpdate() + " ROW INSERT SUCCESS");
		
	}
}
