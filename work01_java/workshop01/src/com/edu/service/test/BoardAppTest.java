package com.edu.service.test;

import java.util.Date;

import com.edu.service.Board;
import com.edu.service.Writer;

public class BoardAppTest {

	public static void main(String[] args) {
		Writer writer = new Writer();
		Board board = new Board();
		
		writer.setWriterInfo("Jim", "1234");

		board.setBoard("Test", "테스트 콘텐츠", new Date(2024, 4, 10), 0, writer);
		
		System.out.println(board.getBoard());
	}

}
