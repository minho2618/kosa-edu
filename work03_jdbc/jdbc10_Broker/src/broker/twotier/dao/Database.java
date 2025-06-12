package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate {
	// 싱글톤
	private static Database database = new Database("127.0.0.1");
	
	private Database(String serverIp) {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Database getInstace() {
		return database;
	}

	//////// 공통로직 (외부, 다른 클래스에서 호출할 일이 없다.)
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB 연결...");
		return conn;
	}

	// DML 쿼리문일 때 사용할 자원 반납 메소드
	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	// SELECT 쿼리문일때 사용할 자원 반납 메소드
	private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	//////////// 존재 유무 확인
	public boolean isExist(String ssn, Connection conn) throws SQLException {
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
	
	private ArrayList<SharesRec> getPortfolio(String ssn, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SharesRec> portfolio = new ArrayList<>();
		
		try {
			String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				portfolio.add(new SharesRec(rs.getString("ssn"), rs.getString("symbol"), rs.getInt("quantity")));
			}
			
		} finally {
			closeAll(ps, null);
		}
		
		return portfolio;
	}
	
	///////////// 비지니스 로직
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if (!isExist(cust.getSsn(), conn)) {
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES (?,?, ?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate() + "명 INSERT 성공...addCustomer");
			} else {
				throw new DuplicateSSNException("추가하려는 고객은 이미 등록된 상태입니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if (isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);			
				
				System.out.println(ps.executeUpdate() + "명 DELETE 성공...deleteCustomer");
			} else {
				throw new RecordNotFoundException("삭제하려는 고객은 이미 삭제된 상태입니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if (isExist(cust.getSsn(), conn)) {
				String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate() + "명 UPDATE 성공...updateCustomer");
				
			} else {
				throw new RecordNotFoundException("수정하려는 고객이 존재하지 않습니다.");
			}
			
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SharesRec> portfolio = new ArrayList<>();
		
		try {
			conn = getConnect();
			
			portfolio = getPortfolio(ssn, conn);
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return portfolio;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec customer = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				customer = new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), rs.getString("address"));
			}
			
			customer.setPortfolio(getPortfolio(ssn, conn));
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customer;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerRec> customerList = new ArrayList<>();
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				customerList.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), 
						rs.getString("address"), getPortfolio(rs.getString("ssn"), conn)));				
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return customerList;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		ArrayList<StockRec> stockList = new ArrayList<>();
		
		
		try {
			conn = getConnect();
			
			String query = "SELECT symbol, price FROM stock";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				stockList.add(new StockRec(rs.getString("symbol"), rs.getFloat("price")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return stockList;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			conn.setAutoCommit(false);
			
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, rs.getInt("quantity") + quantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
			} else {
				query = "INSERT INTO shares (ssn, symbol, quantity) VALUES (?, ?, ?)";
				ps = conn.prepareStatement(query);				
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				ps.setInt(3, quantity);
			}
			
			System.out.println(ps.executeUpdate() + "명 주식 구매 완료");
			
			conn.commit();
		} finally {
			conn.rollback();
			conn.setAutoCommit(true);
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			conn.setAutoCommit(false);
			
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			
			if (!rs.next()) {
				throw new RecordNotFoundException("주식을 갖고 있지 않습니다.");
			}
			
			if (rs.getInt("quantity") > quantity) {
				query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, rs.getInt("quantity") - quantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
			} else if (rs.getInt("quantity") == quantity) {
				query = "DELETE FROM shares WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				ps.setString(2, symbol);
			} else {
				throw new InvalidTransactionException("현재 가지고 있는 주식보다 많은 양을 판매하려했습니다.");
			}
						
			System.out.println(ps.executeUpdate() + "명 주식 판매 완료");
			
			conn.commit();
		} finally {
			conn.rollback();
			conn.setAutoCommit(true);
			closeAll(rs, ps, conn);
		}
		
	}

}
