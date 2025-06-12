package com.edu.exception.test3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileService4 {
	public void readFile(String fileName) throws IOException  {
		System.out.println("2. FileReader Creating...");
		// finally 블락 안에서 자원을 반납해야하는 경우에는 try with resource 구문 사용
		
		try (FileReader fr = new FileReader(fileName)) {
			System.out.println("3. 파일을 성공적으로 찾았습니다.");
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		}
	}
}

public class ComplieExceptionTest4 {

	public static void main(String[] args) {
		System.out.println("1. readFile() Calling...");
		FileService4 service = new FileService4();
		
		try {
			service.readFile("C:\\kosaEdu\\work01_java\\java21_Exception\\src\\com\\edu\\exception\\test3\\test.txt");
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

}