package com.kosa.service;

import com.kosa.vo.Movie;
public class MovieMgr {
	private Movie[ ] movies = null;
	private int index;
	
	private static MovieMgr mgr = new MovieMgr();
	private MovieMgr() {
		movies = new Movie[100];
	}
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		if (index >= 100) {
			System.out.println("영화정보를 더 추가할 수 없습니다.");
			return;
		} else {
			movies[index] = m;
			System.out.println(movies[index].getTitle() + " 추가 되었음");
			index += 1;
			System.out.println(100 - index + "개의 영화정보를 더 추가할 수 있습니다.");
		}
	}
	
	public Movie[] search() {
		Movie[] result = new Movie[index];
		
		int idx = 0;
		for (Movie m : movies) {
			if (m == null)
				break;
			result[idx++] = m;
		}
		
		return result;
	}
	
	public Movie search(String title) {		
		Movie result = null;
		
		for (Movie m : movies) {
			if (m.getTitle().equals(title)) {
				result = m;
				break;
			}
		}
		
		return result;
	}

	public Movie[] searchDirector(String name) {
		int count = -1;
		
		for (Movie m : movies) {
			if (m == null)
				break;
			
			if (m.getDirector().equals(name)) {
				count += 1;
			}
		}
		
		if (count < 0)
			return null;
		
		Movie[] result = new Movie[count + 1];
		int index = 0;
		
		for (Movie m : movies) {
			if (m == null)
				break;
			
			if (m.getDirector().equals(name)) {
				result[index++] = m;
			}
		}
		
		return result;
	}

	public Movie[] searchGenre(String genre) {
		int count = -1;
		
		for (Movie m : movies) {
			if (m == null)
				break;
			
			if (m.getGenre().equals(genre)) {
				count += 1;
			}
		}
		
		if (count < 0)
			return null;
		
		Movie[] result = new Movie[count + 1];
		int index = 0;
		
		for (Movie m : movies) {
			if (m == null)
				break;
			
			if (m.getGenre().equals(genre)) {
				result[index++] = m;
			}
		}
		
		return result;
	}

	public void delete(String title) {
		Movie target = null;
		int idx = -1;
		
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				idx = i;
				target = movies[i];
				break;
			}
		}
		
		if (idx < 0) {
			System.out.println("해당하는 영화가 없습니다.");
			return;
		}
		
		for (int i = idx; i < index; i++) {
			movies[i] = movies[i + 1];			
		}
		
		index -= 1;
		
		System.out.println(target.getTitle() + "가 삭제되었습니다.");
	}
	
	public int getSize() {
		return index;
	}
}