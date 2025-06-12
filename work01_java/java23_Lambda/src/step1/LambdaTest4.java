package step1;

@FunctionalInterface
interface Calculable {
	void calc(int a, int b); // 매개변수 2, 반환타입 없다.
}

public class LambdaTest4 {

	public static void main(String[] args) {
		// 1. Calculable를 구현...람다식
		Calculable c = (a, b) -> System.out.println(a + b); // 함수형 인터페이스 구현체
		
		c.calc(10, 20);
		
		action((a, b) -> {
			int result = a + b;
			System.out.println(result);
		});
	}

	// 2. 메소드를 정의(Calculable을 인자값으로 hasing)
	public static void action(Calculable cal) {
		System.out.println("action...method");
		cal.calc(10, 20);
	}
	
}
