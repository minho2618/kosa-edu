/*
 * 배열은 여러개의 데이터를 저장할 수 있는 일정의 Collection이다.
 * 클래스가 제공되지 않기 때문에 특정한 데이터를 저장, 삭제, 수정, 가져올때마다
 * 직접 기능을 만들어야 하는 번거로움이 있다.
 * 
 * 또한 배열의 특징으로
 * 1) ReSizing이 안됨 --- 사이즈가 변경되면 새로운 배열이 만들어짐
 * 2) Same Data Type --- 데이터 타입이 같은 서로 다른 값들을 저장
 *    Homogeneous Collection (동종 간의 집합체)
 *    
 * 상속을 기술이 적용되는 순간 이기종 간의 집합체가 가능하다
 * Heterogeneous Collection이 만들어진다.
 * 
 * Employee
 * ㄴManager
 * ㄴEngineer
 * ㄴSeceretary
 * 
 * Manager[] mamnagers
 * Engineer[] engineers
 * Secretary[] secretaries
 * 
 * Employee[] employees 에 다 담을 수 있어진다.
 */
package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolymorphismTest1 {

	public static void main(String[] args) {
		// 1.Heterogeneous Collection
		// 이기종 간의 집합체...Same Date Type이 무너짐
		// Polymorphism
		Employee[] employees = {
			new Manager(111, "김관식", 34000.0, new MyDate(1975, 10, 20), "기획부"),
			new Manager(222, "박해일", 24000.0, new MyDate(1984, 10, 20), "기획부"),
			new Engineer(333, "아이유", 54000.0, new MyDate(1999, 1, 12), "Java", 300),
			new Engineer(444, "James", 34000.0, new MyDate(1990, 3, 20), "Python", 200),
			new Secretary(555, "김두식", 30000.0, new MyDate(1999, 4, 21), "James"),
		};

		/*
		 * 2.
		 * Virtual Method Invocation 원리
		 * 상속 관계시 오버라이딩한 자식에서만 발생하는 현상
		 * 컴파일 타입하고 실행 타입이 달라짐
		 * 컴파일 시점 --- 부모의 메소드 호출
		 * 실행 시점 --- 자식 메소드를 호출
		 * Virtual -> 자식
		 */
		for (Employee e : employees) {
			System.out.println(e);
		}
		
		System.out.println();
		// 3. Object Casting
		/*
		 * 
		 */
		for (Employee e : employees) {
			if (e.getEmpno() == 333) {
				((Engineer) e).changeTech("AI");
				//Engineer eg = (Engineer)e;
				//eg.changeTech("AI");
			}
		}
		
		for (Employee e : employees) {
			System.out.println(e);
		}
	}

}
