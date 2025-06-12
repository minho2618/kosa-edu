package com.edu.test;

import java.util.HashSet;
import java.util.Set;

import com.edu.vo.Employee;

public class HashSetTest {

	public static void main(String[] args) {
		// 중복을 벗겨내는 Filtering 역할을 한다
		Set<Employee> set = new HashSet<Employee>();
		Employee e1 = new Employee(111, "이수근", 23000.0);
		Employee e2 = new Employee(222, "서장훈", 23000.0);
		Employee e3 = new Employee(333, "민경훈", 23000.0);
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e1);
		
		System.out.println(set.size() + "명입니다.");
		System.out.println(set);
		
		// 1.
		System.out.println(set.contains(e2) ? "서장훈 있음" : "서장훈 없음");
		
		// 2.
		set.remove(e1);
		System.out.println(set);
		
		// 3.
		set.clear();
		System.out.println(set.isEmpty() ? "Empty" : "Not Empty");
	}

}
