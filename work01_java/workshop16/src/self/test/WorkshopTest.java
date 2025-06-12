package self.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WorkshopTest {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
					new Employee(1, "SCOTT", 30000.0),
					new Employee(2, "ADAMS", 25000.0),
					new Employee(3, "SMITH", 21000.0),
					new Employee(4, "KING", 50000.0)
				);
		
		System.out.println("\n==== 1. 직원 급여를 15% 인상한 정보를 출력 :: forEach 사용 ====");
		employees.forEach((e) -> {
			e.setSalary(e.getSalary() * 1.15);
			System.out.println(e);
		});

		System.out.println("\n==== 2. 직원 급여를 15% 인상한 정보를 출력 :: Consumer로 구현 ====");
		Consumer<Employee> consumer = (e) -> e.setSalary(e.getSalary() + e.getSalary() * 0.15); 
		raiseSalary(employees, consumer.andThen(System.out::println));
	}

	private static void raiseSalary(List<Employee> emps, Consumer<Employee> c) {
		for (Employee e : emps) {
			c.accept(e);
		}
	}
}

class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emplyee [id=" + id + ", name=" + name + ", salary=" + String.format("%.1f", salary) + "]";
	}
}