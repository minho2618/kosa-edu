package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent{
	// 자식만의 메소드
	public void childAccess() {
		System.out.println(publicField + ", " + protectedField);
		System.out.println("defaultField, privateField 접근 할 수 없어");
	}
		
	@Override
	public void access() {
		super.access();
		System.out.println("부모에 접근가능하는 필드 ::" + publicField);
		System.out.println("부모에 접근가능하는 필드2 ::" + protectedField);
	}
}
