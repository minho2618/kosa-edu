package com.edu.array;

public class SawonMBTI2 {
	private int[] people;
	private int[] numList;
	private int mostNum;	
	
	public SawonMBTI2() {}
	
	public SawonMBTI2(int[] people) {
		this.people = people;
		numList = new int[people.length];
	}
	
	public int getMostNum() {
		for (int num : people) {
			numList[num - 1] += 1;
		}
		
		mostNum = 0;		
		for (int i = 0; i < numList.length; i++) {
			if (numList[i] > numList[mostNum]) {
				mostNum = i;
			}
		}
		
		return mostNum + 1;
	}
}
