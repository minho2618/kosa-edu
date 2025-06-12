package com.edu.test;

import com.edu.child.Manager;
import com.edu.util.MyDate;

public class InheritanceTes1 {

	public static void main(String[] args) {
		Manager m1 = new Manager(123, "James", 450000.0, new MyDate(1990, 10, 10), "IT");
		Manager m2 = new Manager(456, "Adams", 380000.0, new MyDate(1995, 2, 11), "Marketing");
		
		System.out.println(m1);
		System.out.println(m2);
	}

}
