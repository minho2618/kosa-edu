package com.self.service;

import java.util.Arrays;

import com.self.vo.child.Engineer;
import com.self.vo.child.Manager;
import com.self.vo.child.Secretary;
import com.self.vo.parent.Employee;

public class EmployeeService {
	private Employee[] emps;
	private int eidx;
	public static final int MAX_SIZE = 100;
	
	private static EmployeeService service = new EmployeeService();

	private EmployeeService(){
		emps = new Employee[MAX_SIZE];
	}
	
	public static EmployeeService getInstance() {
		return service;
	}
	
	/// 서비스 클래스의 기본 기능 CRUD 5개 ///
	public void addEmployee(Employee emp) {	
		if (eidx == emps.length) {
			System.out.println("직원을 더 이상 등록할 수 없습니다.");
			return;
		} else {
			emps[eidx++] = emp;
			System.out.println(emp.getName() + "님이 등록되었습니다.");
		}
	}

	
	public void deleteEmployee(int empno) {	
		int find = -1;
		
		for (int i = 0; i < eidx; i++) {
			if (emps[i].getEmpno() == empno) {// 몇번째 직원을 삭제할 지 확인
				find = i;
				break;
			}
		}
		
		if (find == -1) {
			System.out.println("해당 직원이 존재하지 않습니다.");
			return;
		}
		
		
		for (int i = find; i < eidx; i++) {
			if (find == MAX_SIZE - 1) {// 삭제할 대상이 맨 마지막 사람이라면
				emps[find] = null;
			} else {
				emps[i] = emps[i + 1];
			}
		}	
		
		eidx--;
	}
	
	public void updateEmployee(Employee emp) {	
		for(Employee e : emps) {
			if (e == null) 
				break;
			
			if (e.getEmpno() == emp.getEmpno()) {
				e.setName(emp.getName());
				e.setBirthDate(emp.getBirthDate());
				e.setSalary(emp.getSalary());
				
				if (e instanceof Manager) {
					((Manager)e).changeDept(((Manager)emp).getDept());
				} else if (e instanceof Engineer) {
					((Engineer)e).changeTech(((Engineer)emp).getTech());
					((Engineer)e).upgradeBonus(((Engineer)emp).getBonus());
				} else if (e instanceof Secretary) {
					((Secretary)e).changeEmail(((Secretary)e).getEmail());
					((Secretary)e).changePhoneNumber(((Secretary)e).getPhoneNumber());
				}
			}
		}
	}
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Employee getEmployee(int empno) {
		Employee e = null;
		
		for (Employee emp : emps) {
			if (emp.getEmpno() == empno) {
				e = emp;
				break;
			}
		}		
		
		return e;
	}
	
	public Employee[] getEmployee() {
		return emps;
	}
	
	/// 비즈니스 로직 추가 ///
	// 같은 이메일을 사용하는 사람들을 찾아주는 기능
	// Secretary 직원에서만 적용합니다.
	public Secretary[] findCommonEmail(String email) {
		Secretary[] temp = new Secretary[eidx];
		int count = 0;
		
		for (Employee e : emps) {
			if (e != null && e instanceof Secretary) {
				if (((Secretary)e).getEmail().split("@")[1].equals(email)) {
					temp[count++] = (Secretary)e;
				}
			}
		}
		
		Secretary[] real = new Secretary[count];
		System.arraycopy(temp, 0, real, 0, count);
		
		return real;		
	}	

	//부서별 사람수를 출력하는 기능
	public String[] countDept() {
		String[] dept = new String[eidx*2];
		for(int i = 1; i < eidx*2 ; i+=2) {
			dept[i] = "0";
		}
		int didx = 0;
		boolean fin = false;
		for(Employee e : emps) {
			if(e == null) break;
			if(e instanceof Manager) {
				for(int i = 0; i < didx ; i+=2) {
				    if(((Manager)e).getDept().equals(dept[i])) {
					    dept[i+1] = Integer.toString(Integer.parseInt(dept[i+1]) + 1);
				    	fin = true;
				    }
			    }
			    if(!fin) {
			    	dept[didx] = ((Manager)e).getDept();
			    	dept[didx+1] = "1";
			    	didx += 2;
			    }
			}
			
		}
		String[] realDept = new String[didx];
		System.arraycopy(dept, 0, realDept, 0, didx);
		return realDept;
	}
	//Employee 중에서 막내를 찾아 리턴 (아이디어 기능)
	public Employee findBabyOfEmployee() {
		int maxYear = 0;
		int maxMonth = 0;
		int maxDay = 0;
		int babyIndex = 0;
		
		for(int i = 0; i < eidx; i++) {
			String[] birthDay = emps[i].getBirthDate().toString().split("-");
			int year = Integer.parseInt(birthDay[0]);
			int month = Integer.parseInt(birthDay[1]);
			int day = Integer.parseInt(birthDay[2]);
						
			//막내를 구하는 로직... -> 년도, 월, 일 비교 로직
			if (year > maxYear) {
				maxYear = year;
				babyIndex = i;
			} else if (year == maxYear) {
				if(month > maxMonth) {
					maxMonth = month;
					babyIndex = i;
				} else if (month == maxMonth) {
					if(day > maxDay) {
						maxDay = day;
						babyIndex = i;
					}
				}
			}// if 조건문 끝
		}//for 반복문 끝
		return emps[babyIndex];
	}

}

