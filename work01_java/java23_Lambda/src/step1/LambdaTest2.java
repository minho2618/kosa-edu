package step1;


@FunctionalInterface
interface Workable {
	String monthPayment(String ename, double weekSal);
}

class Employee {
	String ename;
	double weekSal;
	
	public Employee(String ename, double weekSal) {
		super();
		this.ename = ename;
		this.weekSal = weekSal;
	}
	
	// work() 함수와 workable Has a 관계로 연결
	public void work(Workable w) {
		String result = w.monthPayment(ename, weekSal);
		System.out.println(result);
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", weekSal=" + weekSal + "]";
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getWeekSal() {
		return weekSal;
	}

	public void setWeekSal(double weekSal) {
		this.weekSal = weekSal;
	}
	
	
}

public class LambdaTest2 {

	public static void main(String[] args) {
		Employee e = new Employee("James", 500.0);
		// 익명클래스로 구현
//		e.work(new Workable() {
//
//			@Override
//			public String monthPayment(String ename, double weekSal) {
//				double pay = weekSal * 4 + 100.0;
//				return "Employee Name: " + ename + " Month Payment: " + pay;
//			}
//			
//		});
		
		// 구현부가 2줄 이상일때는 {}, return은 생략할 수 없다.
		e.work((ename, weekSal) -> {
			double pay = weekSal * 4 + 100.0;
			return "Employee Name: " + ename + " Month Payment: " + pay;
		});
	}

}
