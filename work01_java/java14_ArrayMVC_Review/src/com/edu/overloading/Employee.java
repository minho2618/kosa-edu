package com.edu.overloading;
/*
 * 직원에 대한 정보를 저장하는 클래스
 */
public class Employee {
	// 사원번호
	// 사원이름
	// 급여
	// 주소
	private int empno;
	private String name;
	private double salary;
	private String address;
	
	/// 필드 기본값 설정 --> 상수 ///
	public final static String DEFAUTLT_NAME = "홍길동";
	public final static double BASIC_SALARY = 100.0;
	public final static String DEFAUTLT_ADDRESS = "서울시";
	
	/*
	 * Employee 생성자는 3개
	 * 생성자명은 동일 / 인자값 리스트는 서로 다르다
	 * --> 생성자 오버로딩
	 * 
	 * 필수값만으로 객체를 생성할 때 사용
	 * 나머지 필드는 초기화가 안되어서 기본값으로 진행될 것이다.
	 * 결과적으로 데이터베이스 테이블 컬럼에 기본값이 들어갈 것이다.	 */
	public Employee(int empno) {
		// this.empno = empno;
		this(empno, DEFAUTLT_NAME, BASIC_SALARY, DEFAUTLT_ADDRESS);
	}	
	public Employee(int empno, String name, double salary, String address) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	public Employee(int empno, String name) {
//		this.empno = empno;
//		this.name = name;
		this(empno, name, BASIC_SALARY, DEFAUTLT_ADDRESS);
	}
	
	public String getDetails() {
		return empno + ", " + name + ", " + salary + ", " + address;
	}
}
