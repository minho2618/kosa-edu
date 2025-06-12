package self;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongsStreamTest {

	public static void main(String[] args) {
		List<Song> songs = new Songs().getSongs();
		
		/*
		 1.  수집하기 - 중간처리 filter | 최종처리 collect
			 스트림으로 만들어서 함수 적용
			 노래의 쟝르 중에서 Rock인 쟝르만 추출
			 정보를 출력한다.
		*/		
//		List<Song> rockSong = songs.stream()
//								   .filter((s) -> s.getGenre().equals("Rock"))
//								   .collect(Collectors.toList());
		
		List<Song> rockSong = songs.stream()
				   .filter((s) -> s.getGenre().equals("Rock"))
				   .toList();
		System.out.println(rockSong);
								   
		System.out.println();	
			
		
		/*
		  2.  존재여부 확인하기 - 최종처리 anyMatch
		      노래의 장르중에서 R&B장르가 있는지 여부를 확인하고 출력한다.
		 */		
		boolean result = songs.stream()
							  .anyMatch((s) -> s.getGenre().equals("R&B"));
		System.out.println(result);
		
		System.out.println();
		 /*
		   3.  항목 갯수세기 - 중간 처리 map, peek, distinct | 최종 처리 count
		       아티스트정보 만으로 새로운 스트림을 만들고 
		       정보들을 뽑아서 먼저 중간출력을 해본다.
		       중복된 정보들이 있으면 제거하고
		       아티스트 갯수를 출력한다.		       
		 */		
		 long result1 = songs.stream()
				 			 .map((s) -> s.getArtist())
				 			 .peek((a) -> System.out.println(a))
				 			 .distinct()
				 			 .count();
		 System.out.println(result1);
					
		 System.out.println();
		 /*
		    4. 1995년도에 발매된 노래만 추출해서 그 중에서 첫번째 노래를 찾아서 정보를 출력
		 */
		Song song = songs.stream()
				 		 .filter((s) -> s.getYear() == 1995)
				 		 .findFirst()
				 		 .get();
		System.out.println(song);
		
	}
}







