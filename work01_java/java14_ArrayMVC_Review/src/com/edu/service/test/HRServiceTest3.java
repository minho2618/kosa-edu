package com.edu.service.test;

import com.edu.service.HRService;
import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRServiceTest3 {

	public static void main(String[] args) {
		HRService service = HRService.getInstance();
		
		service.addEmployee(new Engineer(1, "aaa", "Java", new MyDate(2000, 2, 22)));
		service.addEmployee(new Engineer(2, "bbb", "Python", new MyDate(1999, 3, 3)));
		service.addEmployee(new Engineer(3, "ccc", "C#", new MyDate(1998, 4, 4)));

		service.addEmployee(new SalesMan(1, "zzzz", 500, new MyDate(1991, 11, 11)));
		service.addEmployee(new SalesMan(2, "yyyy", 300, new MyDate(1990, 12, 12)));
		
		System.out.println();
		
		service.updateEmployee(new Engineer(2, "bbb", "C++", new MyDate(1999, 3, 3)));
		
		System.out.println();
		
		service.updateEmployee(new SalesMan(1, "zzz", 750, new MyDate(1991, 11, 11)));
		
		System.out.println();
		
		System.out.println(service.getEngineer(3));
		System.out.println(service.getSalesMan(1));
		
		System.out.println();
		
		Engineer[] engineers = service.getAllEngineer();
		for (Engineer e : engineers) {
			if (e == null) {
				break;
			}
			System.out.println(e);
		}
		
		System.out.println();
		
		SalesMan[] salesMans = service.getAllSalesMan();
		for (SalesMan s : salesMans) {
			if (s == null) {
				break;
			}
			System.out.println(s);
		}
		
		//service.printSalesMan();
		System.out.println();
		
		// 삭제
		service.deleteEngineer(2);
		engineers = service.getAllEngineer();
		for (Engineer e : engineers) {
			if (e == null) {
				break;
			}
			System.out.println(e);
		}
	}

}
