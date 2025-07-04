package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {
	//공통적인 로직
		public Connection getConnection() throws SQLException;
		public void close(PreparedStatement ps, Connection conn)throws SQLException;
		public void close(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException;
		
		//비지니스로직
		public ArrayList<Book> getAllBook()throws SQLException;
		void registerBook(String isbn, String title, String catalogue, String nation, String publish_date,
				String publisher, String author, int price, String currency, String bookSummary) throws SQLException;
}
