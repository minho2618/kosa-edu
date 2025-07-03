package web.servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAOImpl dao = new ProductDAOImpl();
	private DataSource ds = null;
	
	private ProductDAOImpl() {
		try {
			// 1. JNDI 서비스 코드로 수정
			Context ic = new InitialContext(); // 
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			
			System.out.println("DataSource Lookup...Success!!");
		} catch (Exception e) {
			System.out.println("DataSource Lookup...Fail!!");
		}
	}
	
	public static ProductDAOImpl getInstance() {
		return dao;
	}
	
	// 공통 로직
	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}
	
	private void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	
	private Connection getConnect() throws SQLException {
		// 2. 이 부분 변경
		Connection conn = ds.getConnection();
		System.out.println("디비 연결 성공");
		
		return conn;
	}
	
	// 비지니스 로직
	@Override
	public void addProduct(Product vo) throws SQLException {
		Connection conn = getConnect();
		
		String query = "INSERT INTO product (name, price, detail) VALUE (?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getPrice());
		ps.setString(3, vo.getDetail());
		
		System.out.println(ps.executeUpdate() + "개 등록 성공");
		
		closeAll(ps ,conn);
	}
	
	@Override
	public ArrayList<Product> getAllProduct() throws SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection conn = getConnect();
		
		String query = "SELECT num, name, price, detail FROM product";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			productList.add(new Product(
					rs.getInt("num"), 
					rs.getString("name"), 
					rs.getInt("price"), 
					rs.getString("detail")));
		}
		
		closeAll(ps, conn, rs);
		
		return productList;
	}
	
	public static void main(String[] args) {
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		try {
			dao.getAllProduct().forEach((p) -> {
				System.out.println(p);
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
