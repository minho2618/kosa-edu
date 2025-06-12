package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	
}

public class Stream01Student {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
					new Student("SCOTT", 90),
					new Student("BLAKE", 80),
					new Student("KING", 95)
				);
		
		Stream<Student> studentStream = students.stream();
		IntStream scoreStream = studentStream.mapToInt((s) -> s.getScore());
		double avg = scoreStream.average().getAsDouble();
		System.out.println("평균: " + (int)avg);
		
		// Method Chaining
		double avg1 = students.stream()
							  .mapToInt((s) -> s.getScore())
							  .peek(System.out::println)							  
							  .average()
							  .getAsDouble();
		System.out.println("평균2: " + (int)avg1);
		
		System.out.println("\n----------map----------");
		long count = students.stream()
		        .map((s) -> s.getName())
		        .count();
		
		System.out.println("학생수 : " + count);
		
		System.out.println("\n----------중간연산자(filter, map) | 최종연산자(anyMatch)----------");
		boolean isKing = students.stream().anyMatch((s) -> s.getName().equals("KING"));
		System.out.println("Is KING student? : " + isKing);
	}

}

/*
 * 중간연산자
 * map, filter, mapToInt
 * peek
 * distinct
 * limit
 */

/*
 * 최종연산자
 * anyMatch
 * count
 * average
 * forEach
 * collect
 */
