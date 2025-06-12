package com.edu.test;
import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolymorphismTest3 {

	public static void main(String[] args) {
		Employee[] employees = {
			new Manager(111, "김관식", 34000.0, new MyDate(1975, 10, 20), "기획부"),
			new Manager(222, "박해일", 24000.0, new MyDate(1984, 10, 20), "기획부"),
			new Engineer(333, "아이유", 54000.0, new MyDate(1999, 1, 12), "Java", 300),
			new Engineer(444, "James", 34000.0, new MyDate(1990, 3, 20), "Python", 200),
			new Secretary(555, "김두식", 30000.0, new MyDate(1999, 4, 21), "James"),
		};
		
		// 1. employees 안에 저장된 직원들 중에서 Manager인 직원을 찾고 그 직원의 사원번호가 222라면 그 사원의 부서를 교육부로 변경
		//    employees 안에 저장된 직원들 중에서 Secretary인 직원을 찾아서 해당 상사를 222 사번에 해당하는 상사이름으로 변경
		for (Employee e : employees) {
			if (e instanceof Manager && e.getEmpno() == 222) {
				((Manager) e).changeDept("교육부");
				System.out.println(e.getName() + " 부서 변경 완료");
				break;				
			}
		}
		
		for (Employee e : employees) {
			boolean isDone = false;			
			if (e instanceof Secretary) {
				for (Employee eTmp : employees) {
					if (eTmp.getEmpno() == 222) {
						((Secretary) e).changeNameOfBoss(eTmp.getName());
						System.out.println(e.getName() + " 담당 보스 " + eTmp.getName() + "으로 변경 완료");
						isDone = true;
					}
				}
			}
			
			if (isDone)
				break;
		}		

		System.out.println();
		
		// 2. employees 안에 저장된 직원들의 모든 정보를 출력
		for (Employee e : employees)
			System.out.println(e);

		System.out.println();
		
		// 3. Manager 부서의 모든 직원의 급여를 10% 인상
		//    Engineer 부서의 모든 직원의 보너스를 100달러 차감
		//    Secretary 부서의 모든 직원의 급여는 동결
		for (Employee e : employees) {
			if (e instanceof Manager) {
				e.setSalary(e.getSalary() * 1.1);
			} else if (e instanceof Engineer) {
				if (((Engineer)e).getBonus() < 0)
					((Engineer)e).changeBonus(0);
				else
					((Engineer)e).changeBonus(((Engineer)e).getBonus() - 100);
			}
		}		
		
		// 4. employees 안에 저장된 직원들의 모든 정보를 출력  
		for (Employee e : employees)
			System.out.println(e);
		
		System.out.println();
		
		// 부모타입으로 자식객체를 생성...Polymorphism
		Employee e1 = new Manager(7369, "이서연", 50000.0, new MyDate(1988, 12, 12), "교육부");
		Employee e2 = new Engineer(7369, "이지수", 40000.0, new MyDate(1980, 12, 12), "자바", 100);
		
		System.out.println(e1);
		System.out.println(e2);
		
		e1.setSalary(52000);
		System.out.println(e1);
		
		((Manager) e1).changeDept("개발부");
		System.out.println(e1);
	}

}
