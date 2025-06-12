package com.edu.test;

import java.util.Set;
import java.util.TreeSet;

import com.edu.vo.Employee;

/*
 * TreeSet: 중복 X, 순서 X, 정렬 O
 * 
 */
public class TreeSetTest2 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
//		set.add("BBB");
//		set.add("FFF");
//		set.add("AAA");
//		set.add("BBB");
//		set.add("QQQ");
//		
//		System.out.println(set);
		
		set.add(11);
		set.add(3);
		set.add(90);
		set.add(2);
		set.add(90);
		
		System.out.println(set);
		System.out.println(set.higher(3));
		System.out.println(set.lower(3));
		System.out.println(set.headSet(11));
		System.out.println(set.tailSet(90));
	}

}
