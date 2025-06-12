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
/*
 * 배열 관련된 유용한 기능을 가지고 있는 클래스
 * Arrays.copyOf()
 * Arrays.toString()
 * System.arraycopy(source, o, target, 0, length);
 */
import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolymorphismTest2 {

	public static void main(String[] args) {
		Employee[] employees = {
			new Manager(111, "김관식", 34000.0, new MyDate(1975, 10, 20), "기획부"),
			new Manager(222, "박해일", 24000.0, new MyDate(1984, 10, 20), "기획부"),
			new Engineer(333, "아이유", 54000.0, new MyDate(1999, 1, 12), "Java", 300),
			new Engineer(444, "James", 34000.0, new MyDate(1990, 3, 20), "Python", 200),
			new Secretary(555, "김두식", 30000.0, new MyDate(1999, 4, 21), "James"),
		};
		System.out.println("=== Employees Information ===");
		// 배열안에 들어있는 데이터들의 정보를 문자열로 출력
		System.out.println(Arrays.toString(employees));
		
		// 엔지니어의 보너스가 포함되지 않아 잘못됨
		System.out.println("\n=== Employee's AnnnualSalary 아님 ===");
		int annualSalary = 0;
		for (Employee e : employees) {
			annualSalary += (e.getSalary() * 12);
		}
		System.out.println("Employees All Cost : " + annualSalary);
		
		/*
		 * 부모 타입으로 여러 자식 객체들을 관리할 때 특정한 타입의 자식객체를 찾을 수 있어야한다.
		 * instanceof 키워드를 사용
		 * 
		 * if (e instanceof Manager) { // 부모타입안에 생성된 객체가 Manager라면
		 *  
		 * } else if ((e instanceof Enginner) { // 부모타입안에 생성된 객체가 Engineer라면
		 * 
		 * } else if ((e instanceof secretary) { // 부모타입안에 생성된 객체가 Secretary라면
		 * 
		 * }
		 */
		System.out.println("\n=== Employee's AnnnualSalary ===");
		int total = 0;
		for (Employee e : employees) {
			if (e instanceof Engineer) {
				total += (int)(e.getSalary() * 12) + ((Engineer) e).getBonus();
			} else {
				total += (int)(e.getSalary() * 12);
			}
		}
		System.out.println("Employees All Cost : " + total);
	}

}
