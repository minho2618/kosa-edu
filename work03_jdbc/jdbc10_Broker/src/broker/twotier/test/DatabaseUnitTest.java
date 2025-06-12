package broker.twotier.test;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;

/*
 * 비지니스 로직 하나하나에 대한 단위테스트 클래스
 */
public class DatabaseUnitTest {

	public static void main(String[] args) {
		Database db = Database.getInstace();
		
//		try {
//			db.addCustomer(new CustomerRec("777-777", "이민호", "평택"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			db.deleteCustomer("222-222");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			db.updateCustomer(new CustomerRec("777-777", "김상덕", "오산시"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			System.out.println(db.getPortfolio("777-777"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			System.out.println(db.getCustomer("777-777"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			System.out.println(db.getAllCustomers());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			db.buyShares("777-777", "DUKE", 50);
//			System.out.println(db.getCustomer("777-777"));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			db.sellShares("777-777", "JDK", 40);
			System.out.println(db.getCustomer("777-777"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
