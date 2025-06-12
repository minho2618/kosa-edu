/*
 package 선언부는 클래스의 가장 윗부분에 온다
 package 뒤에 나오는 이름들은 다 소문자
 상위 패키지와 하위 패키지는 . 로 구분한다
 패키지 레벨은 3개 이상이 기본이다
 src 밑에 있는 파일은 Package Path System(.)을 따른다
 */

package com.edu.method;

import java.util.Date;

public class Employee {
	public String name;
	public String address;
	public Date hiredate;
	
//	public void printEmployee() {
//		System.out.println(name + " " + address + " " + hiredate);
//	}
	
	public String getEmployee() {
		return  name + " " + address + " " + hiredate; 
	}
	
	// 필드초기화 기능을 추가
	/*
	 this "이 클래스 자기 자신"
	 this.name --- 이 클래스의 멤버인 name
	 */
	public void setEmployee(String name, String address, Date hiredate) {
		this.name = name;
		this.address = address;
		this.hiredate = hiredate;
	}
}
