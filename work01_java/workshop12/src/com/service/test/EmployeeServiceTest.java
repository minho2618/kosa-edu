package com.service.test;

import com.service.EmployeeService;
import com.util.MyDate;
import com.vo.child.Architect;
import com.vo.child.Engineer;
import com.vo.child.Manager;
import com.vo.parent.Employee;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		EmployeeService service = EmployeeService.getInstance();

        Employee e1 = new Manager(1, "Alice", 5000.0, new MyDate(1990,  1,  1), "개발부", 1);
        Employee e2 = new Manager(2, "Bob", 6000.0, new MyDate(1991,  2,  2), "인사부", 2);
        Employee e3 = new Engineer(3, "Charlie", 5500.0, new MyDate(1992,  3,  3), "Java", 500);
        Employee e4 = new Engineer(4, "Alice", 5000.0, new MyDate(1993, 4,  4), "Python", 250);
        Employee e5 = new Architect(5, "Bob", 6000.0, new MyDate(1994, 5, 5), "인사 관리 구현", 3);
        Employee e6 = new Architect(6, "Karma", 5500.0, new MyDate(1995,  6,  6), "게시판 구현",4);

        service.addEmployee(e1);
        service.addEmployee(e2);
        service.addEmployee(e3);
        service.addEmployee(e4);
        service.addEmployee(e5);
        service.addEmployee(e6);
        
        System.out.println();

        Employee[] allEmployee = service.getEmployee();
        for (Employee e : allEmployee) {
        	if (e == null)
        		break;
        	System.out.println(e);
        }
        
        System.out.println();

        Employee found = service.getEmployee(2);
        System.out.println(found);
        		
        System.out.println();

        Employee[] byName = service.getEmployee("Alice");
        for (Employee e : byName) {
        	if (e == null)
        		break;
        	System.out.println(e);
        }
        
        System.out.println();

        service.deleteEmployee(6);
        allEmployee = service.getEmployee();
        for (Employee e : allEmployee) {
        	if (e == null)
        		break;
        	System.out.println(e);
        }

        System.out.println();

        service.increaseSalary(10, 500);
        allEmployee = service.getEmployee();
        for (Employee e : allEmployee) {
        	if (e == null)
        		break;
        	System.out.println(e);
        }

        System.out.println();
    
        System.out.println("직원 정보 변경");
        service.changeEmployeeInfo(new Engineer(3, "Charlie", 5500.0, new MyDate(1992,  3,  3), "AI", 500));
        found = service.getEmployee(3);
        System.out.println(found);
        
        System.out.println();

        ((Manager) e1).setDept("인사부", 2);       

        System.out.println("인사부 소속 매니저 찾기");
        Employee[] hr = service.findEmployeeDept("인사부");
        for (Employee e : hr) {
        	if (e == null)
        		break;
        	System.out.println(e);
        }
        
        System.out.println();
        
        System.out.println("가장 보너스를 많이 받는 엔지니어 찾기");
        Employee top = service.findEmployeeMostBonus();
        System.out.println(top);
        
        System.out.println();
        
        System.out.println("아키텍트의 담당 엔지니어 찾기");
        Employee test01 = service.findEmployeeSupervisioned(e5);
        System.out.println(test01);
        
        System.out.println();
        
        System.out.println("엔지니어의 아키텍트 찾기");
        Employee test02 = service.findEmployeeArchitect(e3);
        System.out.println(test02);
        
        System.out.println();
	}

}
