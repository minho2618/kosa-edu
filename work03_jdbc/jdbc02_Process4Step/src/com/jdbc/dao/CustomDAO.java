package com.jdbc.dao;
/*
 * jdbc 4단계
 * 1. 드라이버 로딩
 * 2. DB 서버 연결 getConnection()...Connection 반환
 * 3. PreparedStatement 생성
 * 4. 값 바인딩 및 SQL문 실행
 *           +
 *        자원 반납(연 순서 반대로 닫아준다)
 *    finally
 *    rs.close()
 *    ps.close()
 *    conn.close() // 이걸 닫는 것이 제일 중요함
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomDAO {
	public CustomDAO(String driver, String url, String user, String pass) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		
			// 2. DB 서버 연결...Connection 반환
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 서버 연결 성공");
		
			// 3. PreparedStatement 생성
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
		
			// 4. 쿼리문 실행
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close(); // 이걸 닫는 것이 제일 중요함
		}
	}
}
