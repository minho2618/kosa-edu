package com.edu.exception.test3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * 발생하는 예외를 직접 처리하지 않고 던지겠다.
 */
class FileService3 {
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		System.out.println("2. FileReader Creating...");
		// fileName 파일을 읽어들이는 로직을 작성
		// Stream에 대한 이해가 필요
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(fileName);
			System.out.println("3. 파일을 성공적으로 찾았습니다.");
			fr.read();
		} finally {
			fr.close();
		}
	}
}

public class ComplieExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("1. readFile() Calling...");
		FileService3 service = new FileService3();
		
		try {
			service.readFile("tezt.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getCause());
		} catch (IOException e) {
			System.out.println(e.getCause());
		}
	}

}