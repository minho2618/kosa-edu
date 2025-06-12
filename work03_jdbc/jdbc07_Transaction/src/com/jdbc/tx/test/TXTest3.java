package com.jdbc.tx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
/*
 * bank 테이블 생성
 * 111 아이유 Toss 300 
 * 222 박보검 KB 100 
 */
public class TXTest3 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(ServerInfo.URL, "root", "1234");
			System.out.println("디비 서버 연결...");
			
			conn.setAutoCommit(false);
			
			String selectQuery = "SELECT ssn, name, bname, balance FROM bank";
			ps = conn.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
									rs.getString("name") + "\t" + 
									rs.getString("bname") + "\t" + 
									rs.getInt("balance"));
				
			}
			// 아이유 계좌에서 박보검 계좌로 100만원을 이체...UPDATE			
			String minusQuery = "UPDATE bank SET balance=balance - ? WHERE ssn=?";
			ps = conn.prepareStatement(minusQuery);
			ps.setInt(1, 100);
			ps.setInt(2, 111);
			ps.executeUpdate();
			
			// 박보검 계좌에서 100만이 입금
			String plusQuery = "UPDATE bank SET balance=balance + ? WHERE ssn=?";
			ps = conn.prepareStatement(plusQuery);
			ps.setInt(1, 100);
			ps.setInt(2, 222);
			ps.executeUpdate();		
			
			conn.commit();
			
			
		} catch (SQLException e) {
			System.out.println("계좌 이체시 문제가 발생했습니다.");
			conn.rollback();
		} finally {
			System.out.println("계좌 이체 후 정보 확인");
			
			String selectQuery = "SELECT ssn, name, bname, balance FROM bank";
			ps = conn.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
									rs.getString("name") + "\t" + 
									rs.getString("bname") + "\t" + 
									rs.getInt("balance"));				
			}
			conn.setAutoCommit(true);
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩...");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
