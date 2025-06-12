package com.edu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edu.vo.Employee;

public class SortTest2 {

	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee(888, "AAA", 20000.0));
		list.add(new Employee(222, "BBB", 21000.0));
		list.add(new Employee(444, "CCC", 22000.0));
		list.add(new Employee(333, "DDD", 23000.0));
		
		// Collection은 자체적으로 toString() 오버라이딩 되어져있다.
		// Collection 안의 데이터를 출력하도록 되어져있다.
		//System.out.println(list);
		
		for (Employee e: list) {
			System.out.println(e);
		}
		
		// Comparator를 사용한 정렬
		System.out.println("=== 오름차순 정렬 ===");
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getEmpno() - e2.getEmpno();
			}
		});
		
		for (Employee e: list) {
			System.out.println(e);
		}
		
		System.out.println("=== 내림순 정렬 ===");
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e2.getEmpno() - e1.getEmpno();
			}
		});
		
		for (Employee e: list) {
			System.out.println(e);
		}
	}
}