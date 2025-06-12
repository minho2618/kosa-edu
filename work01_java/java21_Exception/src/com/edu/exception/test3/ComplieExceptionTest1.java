package com.edu.exception.test3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileService {
	public void readFile(String fileName) {
		System.out.println("2. FileReader Creating...");
		// fileName 파일을 읽어들이는 로직을 작성
		// Stream에 대한 이해가 필요
		
		try {
			FileReader fr = new FileReader(fileName);
			System.out.println("3. 파일을 성공적으로 찾았습니다.");
			fr.read();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
}

public class ComplieExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1. readFile() Calling...");
		FileService service = new FileService();
		
		service.readFile("test.txt");
	}

}