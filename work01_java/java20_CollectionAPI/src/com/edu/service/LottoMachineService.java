package com.edu.service;

import java.util.Random;
import java.util.TreeSet;

/*
 * 중복된 번호를 받아들이지 않는 Set의 성질을 이용한 로직을 작성
 * 번호의 rangesms 1~45 사이의 숫자
 * 숫자의 갯수는 모두 6개의 숫자가 반환
 * 함수를...TreeSet createLottoNumber()
 * 
 * 
 */
public class LottoMachineService {
	
	public TreeSet<Integer> createLottoNumber() {
		TreeSet<Integer> set = new TreeSet<>();
		Random r = new Random();
		
		while (set.size() < 6) {			
			set.add(r.nextInt(45) + 1);
		}
		
		return set;
	}
}
