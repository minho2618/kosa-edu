package step1;

// Annontation을 붙히면 컴파일시에 추상메소드가 1개인지를 확인
@FunctionalInterface
interface MyFunction {
	int max(int a, int b); // 2개의 숫자중 더 큰수를 반환하는 기능의 Template}
}

public class LambdaTest1 {

	public static void main(String[] args) {
		// 1. 익명클래스로 구현...여태까지 한 방법
		MyFunction mf = new MyFunction() {
			
			@Override
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		int result = mf.max(5, 3);
		
		System.out.println(result);
		
		// 2. 람다식으로 구현
		MyFunction mf2 = (x, y) -> x > y ? x : y;
		
		System.out.println(mf2.max(8, 3));
	}

}
