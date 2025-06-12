package com.edu.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
 * put(key, value)
 * remove(key)
 * replace(key, value)
 * get(key)
 * keySet()
 * values()
 * isEmpty()
 * size()
 * containsKey()
 */

public class HashMapTest5 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("이수근", 90); // Integer i = new Integer(90);
		map.put("서장훈", 93);
		map.put("강호동", 88);
		map.put("김영철", 98);
		map.put("김희철", 80);
		
		// 1. 아는 형님 멤버들의 이를을 추출해서 반복문을 통해서 
		// 키 값에 해당하는 성적을 받아오고 
		// 최종적으로 모든 멤버의 성적과 멤버들의 평균을 구해서 출력
		int sum = 0;
		for (String s : map.keySet()) {
			sum += map.get(s);
		}
		System.out.println("멤버의 성적 총합: " + sum + ", 성적 평균: " + (sum / map.size()));
		
		/// 2. 김희철을 삭제
		/// 민경훈, 95 데이터를 추가
		/// 강호동의 성적은 80으로 변경
		
		System.out.println(map.remove("김희철")); 
		
		map.put("민경훈", 95);
		
		map.replace("강호동", 80);
		
//		for (String s : map.keySet()) {
//			System.out.println("이름: " + s + ", 성적: " + map.get(s));
//		}
		
		System.out.println(map); // 주소값이 아니라 정보가 출력된다. 자체적으로 overriding 되어있음
		
		sum = 0;
		for (int score : map.values()) {
			sum += score;
		}
		
		System.out.println(sum);
		
		System.out.println("==== Collections ====");
		
		System.out.println(Collections.max(map.values()));
		System.out.println(Collections.min(map.values()));
		
	}

}
