package com.edu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Kickboard {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;
		
		static int result = 0;
		static int[] movX = {1, 0, -1, 0};
		static int[] movY = {0, 1, 0, -1};

		public static int execute(File path) throws FileNotFoundException {
			//구현 하세요			
			result = 0;
			
			Scanner sc = new Scanner(path);
			N = sc.nextInt();
			M = sc.nextInt();
			
			
			
			map = new int[4][5];
			visited = new boolean[4][5];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}			
			
			search(0, 0);
			
			return result;
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}
		
		public static void search(int x, int y) {
		    visited[y][x] = true;

		    if (x == M - 1 && y == N - 1) {
		        result++;
		        visited[y][x] = false;
		        return;
		    }

		    for (int i = 0; i < 4; i++) {
		        int nx = x + movX[i];
		        int ny = y + movY[i];

		        if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
		            if (map[y][x] > map[ny][nx] && !visited[ny][nx]) {
		                search(nx, ny);
		            }
		        }
		    }

		    visited[y][x] = false; // 백트래킹
		}
}
