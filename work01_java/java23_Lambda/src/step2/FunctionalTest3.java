package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Collection(객체를 저장하는 방법론, 가장 원시적인 저장법)
 * 		|
 *  ----------
 *  |		 |
 * Set		List		Map
 * 저장법이 다르다는 것은
 * 그 안에 저장된 데이터를 뽑아낼 때도 다른 방법으로 뽑혀진다는 것을 의미
 * 이것이 코드가 길어질 수 있고 복잡해질 수 있는 부분이 된다.
 * 자바 8버전 이후에 Collection Stream, Lambda 기술이 제공되면서 이부분이 해소
 */
public class FunctionalTest3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 10; i++)
			list.add(i);
	
//		for (int i : list) System.out.print(i + " ");
//		
//		 System.out.println();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(111, "SCOTT");
		map.put(222, "BLAKE");
		map.put(333, "KING");
		
//		Set<Integer> keys = map.keySet();
//		Iterator<Integer> iter = keys.iterator();
//		
//		while(iter.hasNext()) {
//			int key = iter.next();
//			String value = map.get(key);
//			System.out.println(key + " : " + value);
//		}
		
		System.out.println("1. 리스트에 담긴 객체를 출력 ===> forEach");
		list.forEach((i) -> System.out.print(i + " "));
		
		System.out.println("2. Map에 담긴 객체(key, value)를 출력 ===> forEach");
		map.forEach((i, s) -> System.out.println(i + " : " + s));
		
		System.out.println("\n3. 리스트 값들 중에서 2 혹은 3의 배수를 제거 ===> removeIf");
		list.removeIf((i) -> i % 2 == 0 || i % 3 == 0);
		list.forEach((i) -> System.out.print(i + " "));
		
		System.out.println("\n3. 리스트 모든 값들에 10을 곱한다 ===> replaceAll");
		list.replaceAll((i) -> i * 10);
		list.forEach((i) -> System.out.print(i + " "));
	}
}
