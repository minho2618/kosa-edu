package step2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * 함수형 인터페이스 구성요소
 * 1) 추상 메소드 -- 이게 핵심이다
 * 2) default 메소드
 * 3) static 메소드
 * :::
 * 대표적인 Functional 인터페이스
 * 매개변수 X, 반환타입 X -------------> Runnable   void run()
 * 매개변수 O, 반환타입 X -------------> Consumer   void accept(T t)
 * 매개변수 X, 반환타입 O -------------> Supplier   R get()
 * 매개변수 O, 반환타입 O -------------> Function   R apply(T t)
 * 매개변수 O, 반환타입 O(boolean) ----> Predicate  boolean test(T t)
 */
public class FunctionalTest1 {
	public static void main(String[] args) {
		System.out.println("-- 1. Runnable   void run() --");
		Runnable r = () -> System.out.println("run...함수");
		r.run();
		
		System.out.println("-- 2. Supplier   R get() --");
		// 1. 익명 클래스...1~100 사이의 난수를 반환
		Supplier<Integer> s1 = new Supplier<Integer>() {

			@Override
			public Integer get() {
				int num = (int)(Math.random() * 100) + 1;
				return num;
			}
			
		};		
		System.out.println(s1.get());
		
		Supplier<Integer> s2 = () -> {
			int num = (int)(Math.random() * 100) + 1;
			return num;
		};		
		System.out.println(s2.get());
		
		System.out.println("-- 3. Consumer   void accept(T t) --");
		Consumer<Integer> c1 = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		};
		c1.accept(100);
		
		Consumer<Integer> c2 = (a) -> System.out.println(a);
		c2.accept(200);
		
		System.out.println("-- 4. Function   R apply(T t) --");
		Function<Integer, Integer> f1 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t / 10 * 10;
			}
			
		};
		System.out.println(f1.apply(13));
		
		Function<Integer, Integer> f2 = (t) -> t / 10 * 10;
		System.out.println(f2.apply(27));
		
		System.out.println("-- 5. Predicate  boolean test(T t) --");
		Predicate<Integer> p = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
			
		};
		System.out.println(p.test(14));
		
		Predicate<Integer> p2 = (t) -> t % 2 == 0;
		System.out.println(p2.test(14));
	}

}
