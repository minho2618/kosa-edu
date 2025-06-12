package com.edu.array.test2;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[] members1 = {1, 2, 3, 4, 5, 6};
		int[] members2 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		// 사이즈가 다른 배열을 copy해서 가져옴
		System.arraycopy(members1, 0, members2, 4, members1.length);
		
		for (int member : members2) System.out.print(member + " ");
	}
	
}
