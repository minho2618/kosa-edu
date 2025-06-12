package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Comparator 사용 시 람다형식을 적용
public class LambdaTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(100, 45, 22, 200, 4, 1, 23, 45, 66);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, (o1, o2) -> o2 - o1);
		System.out.println(list);
	}

}
