package com.edu.method.test;
/*
	EmployeeTest2에서는 여러명의 직원을 생성하는 코드를 작성
	Scott, Adams 총 3명의 직원을 생성
	세 명의 직원 정보를 출력
 */

import java.util.Date;

import com.edu.method.Employee;

public class EmployeeTest2 {

	public static void main(String[] args) {
		Employee e1 = new Employee(); 
		Employee e2 = new Employee();
		Employee e3 = new Employee();		
		
		e1.name = "James";
		e1.address = "Texas";
		Date date = new Date(2042, 4, 10);
		e1.hiredate = date;
		
		e2.name = "Scott";
		e2.address = "New York";
		date = new Date(2009, 3, 10);
		e2.hiredate = date;
		
		e3.name = "Adams";
		e3.address = "Califonia";
		date = new Date(2020, 2, 10);
		e3.hiredate = date;
		
		System.out.println(e1.getEmployee());
		System.out.println(e2.getEmployee());
		System.out.println(e3.getEmployee());
	}

}
/*
 이런식으로 코드작업을 하게되면
 직원이 늘어날때마다 그에 따라 증가되는 코드 라인은 급속도로 증가하게 된다.
 이유는 필드에 직접 값을 할당하기 때문이다.
 해결책: 필드에 값을 할당하는...필드 초기화하는 기능을 추가로 정의해서 사용하도록 한다
*/