package com.edu.test;

import java.util.ArrayList;

import com.edu.vo.Employee;

/*
 * ArrayList
 * List의 자식
 * 순서를 가지면서 객체를 저장...중복도 가능하다
 * add(), remove(), get(), set(), size(), isEmpty(), clear(), removeAll()
 * 
 * 이전의 배열과 같다
 * 대신에 사이즈가 알아서 늘어난다
 * 신경 쓸 필요 없다
 */
public class ArrayListTest1 {

	public static void main(String[] args) {
		//알아서 10칸짜리 배열이 만들어지고...11명을 추가하려면 알아서 다시 10칸이 늘어난다.
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee(111, "AAA", 20000.0));
		list.add(new Employee(222, "BBB", 21000.0));
		list.add(new Employee(333, "CCC", 22000.0));
		list.add(new Employee(444, "DDD", 23000.0));
		
		//		list.remove(2);
		Employee delEmp = list.get(2);
		boolean find = list.remove(delEmp);
		System.out.println(find);
		
		list.add(1, new Employee(555, "FFF", 24000.0));
		
		list.set(list.size() - 1, new Employee(444, "DDD", 32000.0));
		
		if (!list.isEmpty()) {
			for (Employee e : list) {
				System.out.println(e.toString());
			}
		}
	}

}
