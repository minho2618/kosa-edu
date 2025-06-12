package com.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.exception.DuplicateEmpException;
import com.edu.exception.RecordNotFoundException;
import com.edu.service.EmployeeMapService;
import com.edu.vo.Employee;

public class EmployeeMapServiceImpl implements EmployeeMapService{
	
	private Map<Integer, Employee> map;
	
	static private EmployeeMapServiceImpl service = new EmployeeMapServiceImpl();
	private EmployeeMapServiceImpl() {
		map = new HashMap<Integer, Employee>();
	}
	
	public static EmployeeMapServiceImpl getInstance() {
		return service;
	}	
	@Override
	public void addEmployee(Employee e) throws DuplicateEmpException {		
		if (map.containsKey(e.getEmpId())) {
			throw new DuplicateEmpException(e.getName() + "님은 이미 등록되어져 있어요.");
		}
		
		map.put(e.getEmpId(), e);
	}

	@Override
	public void deleteEmployee(int empId) throws RecordNotFoundException {		
		Employee delEmp = map.remove(empId);
		if (delEmp == null) {
			throw new RecordNotFoundException("삭제할 직원이 존재하지 않습니다.");
		}
		
		System.out.println("직원번호 " + empId + "삭제 성공");
	}
	@Override
	public void updateEmployee(Employee e) throws RecordNotFoundException {		
		if (!map.containsKey(e.getEmpId())) {
			throw new RecordNotFoundException(e.getName() + "님은 존재하지 않습니다.");
		}
		
		map.put(e.getEmpId(), e);
	}
	
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		
		
		return temp;
	}	
	@Override
	public ArrayList<Employee> findEmployees() {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		
		Set<Integer> set = map.keySet();
		for (int n : set) {
			temp.add(map.get(n));
		}
		
		return temp;
	}
}













