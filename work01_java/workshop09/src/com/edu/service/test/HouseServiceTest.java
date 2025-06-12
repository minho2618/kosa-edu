package com.edu.service.test;

import com.edu.service.HouseSurveyService;
import com.edu.vo.House;
import com.edu.vo.Resident;

public class HouseServiceTest {

	public static void main(String[] args) {
		HouseSurveyService service = new HouseSurveyService();
		
		Resident[] residents1 = {
				new Resident("Kim Minsoo",     900101123, 34, true,  2),
	            new Resident("Lee Jihye",      850505234, 39, true,  1),
	            new Resident("Park Seojun",    980712345, 26, false, 0),
	            new Resident("Choi Yujin",     770303456, 48, true,  3),
	            new Resident("Jung Hana",      20000229,  24, false, 1)
				};
		Resident[] residents2 = {
				 new Resident("Kim Minsoo",  900101123, 34, true,  2),
		         new Resident("Lee Jihye",   850505234, 39, true,  1),
		         new Resident("Park Seojun", 980712345, 26, false, 0),
				};	

		Resident[] residents3 = {

	            new Resident("Jung Hana",   20000229,  24, false, 1)
				};
		
		
		House h1 = new House("Ocean View Villa", 120.5, 1995, "123 Beach Rd, Busan",      'A');
		House h2 = new House("Mountain Cabin",    85.0, 1982, "45 Pine St, Gangwon-do",   'B');		
		House h3 = new House("City Center Apt.",  55.3, 2008, "789 Metro Ave, Seoul",      'A');	
		
		House[] houses = new House[999];
		
		houses[0] = h1;
		houses[1] = h2;
		houses[2] = h3;
		int houseCount = 3;
		
		House[] tmpHouses = null;
		Resident[] tmpResidents = null;
		
		houses[0].setResidents(residents1);
		houses[1].setResidents(residents2);
		houses[2].setResidents(residents3);

		System.out.println("=== Test 1 House[]의 정보 출력 ===");
		System.out.println(service.getHousesInfo(houses));
		System.out.println();
		
		System.out.println("=== Test 2 House[]에서 House 추가 ===");
		tmpHouses = service.addHouse(houses, new House("Suburban Bungalow", 99.9, 2012, "22 Maple Dr, Incheon", 'C'), houseCount);
		houseCount += 1;
		System.out.println(service.getHousesInfo(tmpHouses));
		System.out.println();
		
		System.out.println("=== Test 3 House[]에서 House 제거 ===");
		houseCount -= 1;
		tmpHouses = service.removeHouse(houses, "Suburban Bungalow", houseCount);
		System.out.println(service.getHousesInfo(tmpHouses));
		System.out.println();
		
		System.out.println("=== Test 4 House의 Resident[] 반환 ===");
		System.out.println(service.getResidentHouse(houses[0]));
		System.out.println();
		
		System.out.println("=== Test 5 전체 차량 수가 ?개 이상인 거주자들 반환 ===");
		tmpResidents = service.getAllResidentOverCar(houses, 2);
		for (Resident resident : tmpResidents)
			System.out.println(resident.getResidentInfo());
		System.out.println();
		
		System.out.println("=== Test 6 한 집에서 결혼한 거주자들 반환 ===");
		tmpResidents = service.getResidentMarriage(houses[0]);
		for (Resident resident : tmpResidents)
			System.out.println(resident.getName() + " " + (resident.isMarriage() ? "기혼" : "미혼"));
		System.out.println();
		
		System.out.println("=== Test 7 전체 나이 별 인구수  ===");
		int[] ageList = service.countPopulationAge(houses);
		
		int idx = 0;
		for (int ageNum : ageList) {
			System.out.printf("%d대(60대의 경우 60세 이상): %d명\n", idx, ageNum);
			idx += 10;
		}
		System.out.println();
		
		System.out.println("=== Test 8 전체 집 넓이의 평균 ===");
		System.out.println(service.getHouseAreaAvg(houses, houseCount));
		System.out.println();
		
		System.out.println("=== Test 9 n인 가구의 집 넓이의 평균  ===");
		System.out.println(service.getHouseAreaAvg(3, houses));
		System.out.println();
	}

}
