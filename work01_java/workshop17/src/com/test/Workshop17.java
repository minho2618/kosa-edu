package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Workshop17 {

	public static void main(String[] args) {
		List<String> coffee = Arrays.asList(
				"Cappuccino", "Americano", "Espresso",
				"Caramel Macchiato", "Mocha", "Cappuccino",
				"Espresso",	"Latte");

//		Stream<String> coffeeStream = coffee.stream();
//		coffeeStream.filter((c) -> c.endsWith("o"))
//					.sorted((c1, c2) -> c2.compareTo(c1))
//					.distinct()
//					.forEach(System.out::println);
		
		// Method Chaining 기법
		List<String> endingCoffee = coffee.stream()
			  .filter((c) -> c.endsWith("o"))
			  .sorted(Comparator.reverseOrder())
			  .distinct()
			  .collect(Collectors.toList());
		System.out.println(endingCoffee);
	}
}

