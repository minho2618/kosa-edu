package com.edu.service;

import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRService {
	// 필드 레벨에 배열을 선언
	// int size = 0;
	
	Engineer[] engineers = null;
	int eidx = 0;
	SalesMan[] salesMans = null;
	int sidx = 0;
	
	// 1.
	private static HRService service = new HRService(10);
	
	// 2.
	private HRService(int size) {
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}
	
	// 3.
	public static HRService getInstance() {
		return service;
	}
	
	// 서비스 기능 정의
	// 특정한 대상을 추가하는 기능...C
	public void addEmployee(Engineer engineer) {
		// engineer를 배열에 추가...인덱스를 하나 증가
		if (eidx >= engineers.length) {
			System.out.println("엔지니어 티오가 꽉 찼습니다.");
		} else {
			engineers[eidx++] = engineer;
			System.out.println(engineer.getName() + "님이 등록되었습니다.");
		}
		
	}
	
	public void addEmployee(SalesMan salesMan) {
		// salesMan를 배열에 추가...인덱스를 하나 증가
		if (sidx >= engineers.length) {
			System.out.println("세일즈맨 티오가 꽉 찼습니다.");
		} else {
			salesMans[sidx++] = salesMan;
			System.out.println(salesMan.getName() + "님이 등록되었습니다.");
		}
	}
	// empno에 해당하는 나머지 정보를 수정하는 기능...U
	public void updateEmployee(Engineer engineer) {
		// 배열 안에서 수정하고자 하는 대상을 찾아서...empno...mainSkill을 수정
		for (Engineer tmpEng : engineers) {
			if (tmpEng == null)
				break;
			if (engineer.getEmpno() == tmpEng.getEmpno()) {
				tmpEng.changeMainSkill(engineer.getMainSkill());
				System.out.println("엔지니어 변경 " + tmpEng.toString());
				break;
			}
		}
	}
	
	public void updateEmployee(SalesMan salesMan){
		for (SalesMan tmpSale : salesMans) {
			if (tmpSale == null)
				break;
			if (salesMan.getEmpno() == tmpSale.getEmpno()) {
				tmpSale.changeBous(salesMan.getBonus());
				System.out.println("세일즈맨 변경 " + tmpSale.toString());
				break;
			}
		}
	}
	
	// 정보를 검색하는 기능...R
	public Engineer getEngineer(int empno) {
		Engineer find = null;
		
		for (Engineer e : engineers) {
			if (e == null)
				break;
			
			if (empno == e.getEmpno()) {
				find = e;
				break;
			}
		}
		
		return find;
	}
	
	public SalesMan getSalesMan(int empno) {
		SalesMan find = null;
		
		for (SalesMan s : salesMans) {
			if (s == null)
				break;
			
			if (empno == s.getEmpno()) {
				find = s;
				break;
			}
		}
		
		return find;
	}
	
	public Engineer[] getAllEngineer() {
		return engineers;
	}
	
	public SalesMan[] getAllSalesMan() {
		return salesMans;
	}
	
	// 특정한 대상을 삭제하는 기능...D
	public void deleteEngineer(int empno) {
		int idx = -1;
		for (int i = 0; i < eidx; i++) {
			if (empno == engineers[i].getEmpno()) {
				idx = i;
				break;
			}
		}
		
		if (idx < 0) {
			System.out.println("Not Found Engineer");
			return;
		}
		
		for (int i = idx; i < eidx; i++) {
			engineers[i] = engineers[i + 1];
		}
		engineers[eidx-1] = null;
		eidx--;
		
		return;
	}
	
//	public void deleteEngineer(int empno) {
//		int idx = -1;
//		for (int i = 0; i < eidx; i++) {
//			if (empno == engineers[i].getEmpno()) {
//				idx = i;
//				break;
//			}
//		}
//		
//		if (idx < 0) {
//			System.out.println("Not Found Engineer");
//			return;
//		}
//		
//		for (int i = idx; i < eidx; i++) {
//			engineers[i] = engineers[i + 1];
//		}
//		engineers[eidx-1] = null;
//		eidx--;
//		
//		return;
//	}
}
