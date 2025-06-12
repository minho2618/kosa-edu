package com.edu.array.test2;

public class ArrayTest1 {

	public static void main(String[] args) {
		int[] members = {1, 2, 3, 4, 6, 10};
		
		for (int member : members) System.out.print(member + " ");
		
		System.out.println();
		
		members = new int[9]; // 칸이 3칸 더 늘어났다.
		
		members[6] = 9;
		members[7] = 23;
		members[8] = 7;
		
		for (int member : members) System.out.print(member + " ");
	}
	
}
