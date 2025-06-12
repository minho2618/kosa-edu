package com.edu.service.impl;

import java.util.ArrayList;
import java.util.Comparator;

import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService{
	
	//추가
	private ArrayList<Employee> list;
	
	static private EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<Employee>();
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {		
		boolean find = false;
		
		for (Employee emp : list) {
			if (emp.getEmpId().equals(e.getEmpId())) {
				find = true;
				System.out.println("이미 존재하는 직원입니다.");				
				return;
			}
		}
		
		if (!find) {
			list.add(e);
			System.out.println(e.getName() + "님이 추가되었습니다.");
		}
	}
	@Override
	public void deleteEmployee(String empId) {		
		int find = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmpId().equals(empId)) {
				find = i;		
				break;
			}
		}
		
		if (find != -1) {			
			Employee e = list.remove(find);
			System.out.println(e.getName() + "님을 삭제합니다.");
		} else {
			System.out.println("이미 없는 직원입니다.");
		}
	}
	@Override
	public void updateEmployee(Employee e) {		
		int find = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmpId().equals(e.getEmpId())) {
				find = i;		
				break;
			}
		}
		
		if (find != -1) {
			System.out.println(list.get(find).getName() + "님의 정보를 수정합니다.");
			list.set(find, e);
		} else {
			System.out.println("존재하지 않는 직원입니다.");
		}
	}//updateEmployee
	
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> tmp = new ArrayList<>();
		boolean find = false;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAddr().equals(addr)) {
				find = true;
				tmp.add(list.get(i));
			}
		}
		
		if (!find) System.out.println("해당 지역에 사는 직원이 없습니다.");
		
		return tmp;
	}
	
	@Override
	public void findEmployees() {
		if (list.isEmpty()) System.out.println("직원이 없습니다."); 
		
		list.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (Employee e : list) {
			System.out.println(e);
		}		
	}
}
