package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * 함수의 인자값으로 Functional Interface가 사용되는 핵심 예제
 */

public class FunctionalTest2 {
	public static void main(String[] args) {
		System.out.println("-- 1. Runnable   void run() --");
		Runnable r = () -> System.out.println("run...함수");
		r.run();
		
		System.out.println("-- 2. Supplier   R get() --");
		// 1. 익명 클래스...1~100 사이의 난수를 반환		
		Supplier<Integer> s2 = () -> {
			int num = (int)(Math.random() * 100) + 1;
			return num;
		};		
		List<Integer> list = new ArrayList<>();
		makeRandomList(list, s2);
		System.out.println(list);
		
		
		System.out.println("-- 3. Consumer   void accept(T t) --");
		Consumer<Integer> c2 = (a) -> System.out.print(a + " ");
		
		System.out.println("-- 4. Function   R apply(T t) --");
		Function<Integer, Integer> f2 = (t) -> t / 10 * 10;
		//System.out.println(f2.apply(2002));
		List<Integer> newList = doSomething(list, f2);
		System.out.println(newList);
		
		System.out.println("-- 5. Predicate  boolean test(T t) --");
		Predicate<Integer> p2 = (t) -> t % 2 == 0;
		printEvenNumber(list, p2, c2);
	}
	
	private static void makeRandomList(List<Integer> list, Supplier<Integer> s) {
		// 10회를 반복...Supplier로부터 임의의 값을 받고...그 값을 list에 저장
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}

	private static List<Integer> doSomething(List<Integer> list, Function<Integer, Integer> f) {
		List<Integer> newList = new ArrayList<>(list.size());
		
		for (int n : list) newList.add(f.apply(n));
		
		return newList;
	}
	
	private static void printEvenNumber(List<Integer> list, Predicate<Integer> p, Consumer<Integer> c) {
		for (int n : list) {
			if (p.test(n)) {
				c.accept(n);
			}
		}
		
	}
}
