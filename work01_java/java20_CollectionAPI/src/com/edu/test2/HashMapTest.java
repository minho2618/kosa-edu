package com.edu.test2;

import com.edu.vo.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, Employee> map = new HashMap<>();
		map.put(111, new Employee(111, "이수근", 20000.0));
		map.put(444, new Employee(444, "서장훈", 25000.0));
		map.put(333, new Employee(333, "김영철", 32000.0));
		map.put(777, new Employee(777, "이희철", 18000.0));
		map.put(222, new Employee(222, "강호동", 32000.0));
		
		// 1.
		if (map.containsKey(777)) {
			System.out.println(map.get(777)); 
		} else {
			System.out.println("없음");
		}
		
		// 2.
		for (Employee e : map.values()) {
			if (e.getName().equals("서장훈")) {
				System.out.println(e.getSalary());
			}
		}
		
		// 3.
		double max = -1;
		double min = Double.MAX_VALUE;
		
//		Employee maxE = null;
//		Employee minE = null;
//		
//		for (Employee e : map.values()) {
//			if (e.getSalary() > max) {
//				max = e.getSalary();
//				maxE = e;
//			}
//			
//			if (e.getSalary() < min) {
//				min = e.getSalary();
//				minE = e;
//				//System.out.println(minE);
//			}
//		}
//		
//		System.out.println("MAX: " + maxE.getName() + ", MIN: " + minE.getName());
		
//		Comparator<Employee> comp = new Comparator<>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				
//				return (int)((o1).getSalary() - (o2).getSalary());
//			}
//			
//		};
//		
//		System.out.println(Collections.max(map.values(), comp).getSalary());
//		System.out.println(Collections.min(map.values(), comp).getSalary());
		
		Collection<Employee> employees =  map.values();
		Comparator<Employee> comp = Comparator.comparing(Employee::getSalary);
		
		Employee maxEmp = Collections.max(employees, comp);
		Employee minEmp = Collections.min(employees, comp);
		
		System.out.println(maxEmp);
		System.out.println(minEmp);
		
		// 4.
		if (map.containsKey(888)) {
			System.out.println(map.get(888)); 
		} else {
			map.put(888, new Employee(888, "유재석", 0.0));
		}
		
		System.out.println(map);
		
		// 5.
		map.clear();
		
		if (map.isEmpty()) {
			System.out.println("Map is empty");
		}
	}
}
