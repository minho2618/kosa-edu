package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionStreamTest1 {

	public static void main(String[] args) {
		// 1. 리스트 생성
		List<String> fruits = Arrays.asList(
				"Apple", "Melon", "Banana", "Apple", "Orange", 
				"Grape", "Grape", "Water Melon", "Banana"
				);
		Stream<String> stream = fruits.stream();
		//stream.distinct().forEach((i) -> System.out.println(i));
		List<String> last = stream.distinct().limit(3).sorted().collect(Collectors.toList());
		System.out.println(last);
	}

}
