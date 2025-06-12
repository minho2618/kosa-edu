package step1;
/*
 * Collection Stream의 특징
 * 1. Read Only - 스트림은 데이터 소스로부터 데이터를 읽어들이기만 할 뿐 변경하지 않는다.
 * 2. 일회용이다 - 최종연산이 한번 진행되었다면 해당 스트림은 닫히고 다시 사용될 수 없다.
 * 				필요하다면 다시 생성해서 사용해야 한다.
 * 3. 최종연산 전까지 스트림의 중간연산이 수행되지 않는다. - 지연된 연산
 * 4. 병렬처리 작업이 가능하다 - 멀티 쓰레드 지원
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest2 {

	public static void main(String[] args) {
		// 1. 리스트 생성
		List<String> fruits = Arrays.asList(
				"Apple", "Melon", "Banana", "Apple", "Orange", 
				"Grape", "Grape", "Water Melon", "Banana"
				);
		System.out.println("원본 리스트: " + fruits);
		
		// 1. 스트림 생성
		Stream<String> stream = fruits.stream();
		
		// 2. 중간연산 + 최종연산
		stream.distinct().limit(4).sorted().forEach((i) -> System.out.println(i));
		
		System.out.println("원본 리스트2: " + fruits); // 원본 데이터와 동일
		System.out.println("\n-------------------------일회성----------------------------");
		
		String[] arr = {"aaa", "bbb", "ccc", "ddd", "eee"};
		Stream<String> strStream = Stream.of(arr);
		strStream.forEach(System.out::println);
		
		//long count = strStream.count();
		//System.out.println("스트림 안의 데이터 갯수: " + count);
		System.out.println("\n--------------------------------------------------------");
		IntStream intStream = new Random().ints(1, 46); // 1 ~ 45 사이의 랜덤한 값을 반환
		//intStream.forEach(System.out::println);
		// 중복된 값은 없애고, 값 중에서 6개만 추출, 정렬해서 출력
		intStream.distinct().limit(6).sorted().forEach((i) -> System.out.print(i + " "));
	}

}
