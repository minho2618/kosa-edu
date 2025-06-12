package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/*
 * Optional의 용도
 */
public class Stream03Optional {
	public static void main(String[] args) {
		//List<Integer> list = new ArrayList<>(5);
		
		// list 안에 데이터 없이 중간처리연사자를 가동시키면 NoSuchElementException 발생
		// 이런 경우에 Optional이 필요하다
		
//		Stream<Integer> stream = list.stream();
//		double avg = stream.mapToInt(Integer :: intValue)
//			  .average()
//			  .getAsDouble();
//		System.out.println(avg);
//		
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		OptionalDouble optional = list.stream()
									  .mapToInt(Integer :: intValue)
									  .average();
		
		if (optional.isPresent()) 
			System.out.println(optional.getAsDouble());
		else
			System.out.println("없음");
	}
}
