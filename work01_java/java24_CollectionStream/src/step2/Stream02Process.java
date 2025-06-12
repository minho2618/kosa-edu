package step2;

import java.util.List;
import java.util.stream.Stream;

public class Stream02Process {

	public static void main(String[] args) {
		List<String> strings = List.of("I", "am", "list", "String");
		
		Stream<String> stream = strings.stream();
		stream = stream.limit(4);
		//System.out.println(stream);
		
		// 1. stream에서 첫번째 데이터를 찾아서 그걸 바로 출력
	 	System.out.println(stream.findFirst().get());
	 	
	 	// 2. stream 안에 들어있는 데이터의 갯수를 출력
	 	System.out.println(strings.stream().count());
	}

}
