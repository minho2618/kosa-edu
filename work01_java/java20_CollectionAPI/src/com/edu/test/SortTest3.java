package com.edu.test;
// Comparable 방식으로 정렬
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edu.vo.Employee;

public class SortTest3 {

	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee(888, "AAA", 20000.0));
		list.add(new Employee(222, "BBB", 21000.0));
		list.add(new Employee(444, "CCC", 22000.0));
		list.add(new Employee(333, "DDD", 23000.0));
		
		System.out.println("=== 정렬전 ===");
		for (Employee e : list) System.out.println(e);
		
		Collections.sort(list);
		System.out.println("=== 정렬후 ===");
		for (Employee e : list) System.out.println(e);
	}
}