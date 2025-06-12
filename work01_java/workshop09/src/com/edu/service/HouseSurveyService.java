package com.edu.service;

import com.edu.vo.House;
import com.edu.vo.Resident;

public class HouseSurveyService {
	public String getHousesInfo(House[] houses) {
		String result = "";
		
		for (House house : houses) {
			if (house == null)
				break;
			result += house.getHouseInfo() + "\n" ;
		}
		//System.out.println(result);
		
		return result;
	}
	
	public House[] addHouse(House[] houses, House house, int houseCount) {
		houses[houseCount] = house;
		
		return houses;
	}
	
	public String getResidentHouse(House house) {
		String result = "";
		
		Resident[] tmpResidents = house.getResidents();
		
		for (Resident resident : tmpResidents) {
			if (resident == null)
				break;
			
			result += resident.getResidentInfo() + "\n";
		}
		
		return result;	
	}
	
	public House[] removeHouse(House[] houses, String houseName, int houseCount) {
		int idx = 0;
		for (House house : houses) {
			if (house.getHouseName().equals(houseName)) {
				break;
			}				
			idx += 1;
		}
		
		houses[idx] = null;
		
		for (int i = idx + 1; i > houseCount - idx; i++) {
			if (houses[i] == null)
				break;
			
			houses[i - 1] = houses[i];
			
			houses[i] = null;
		}
		
		return houses;
	}
	
	public Resident[] getAllResidentOverCar(House[] houses, int carQuantitiy) {
		Resident[] residents = null;
		int countResidentOverCar = 0;

		for (House house : houses) {
			if (house == null)
				break;
			Resident[] tmpResident = house.getResidents();			
			
			for (Resident resident : tmpResident) {
				if (resident.getCarQuantity() >= carQuantitiy)
					countResidentOverCar += 1;
			}
		}	
		
		//System.out.println(countResidentOverCar);
		
		residents = new Resident[countResidentOverCar];
		
		int idx = 0;
		for (House house : houses) {
			if (house == null)
				break;
			if (idx >= countResidentOverCar)
				break;
			Resident[] tmpResident = house.getResidents();			
			
			for (Resident resident : tmpResident) {
				if (resident.getCarQuantity() >= carQuantitiy) {
					residents[idx++] = resident;
					//System.out.println(resident.getResidentInfo());
				}
			}
		}
		
//		System.out.println(countResidentOverCar);
//		System.out.println(residents.length);
		
		return residents;
	}
	
	public Resident[] getResidentMarriage(House house) {
		Resident[] tmpResident = null;
		int count = 0;
		
		for (Resident resident : house.getResidents()) {
			if (resident.isMarriage())
				count += 1;
		}
		
		tmpResident = new Resident[count];
		
		int idx = 0;
		for (Resident resident : house.getResidents()) {
			if (idx >= count)
				break;
			if (resident.isMarriage()) {
				tmpResident[idx++] = resident;				
			}				
		}
		
		return tmpResident;
	}
	
	public int[] countPopulationAge(House[] houses) {
		int[] ageList = new int[7];
		
		for (int i = 0; i < ageList.length; i++) {
			ageList[i] = 0;
		}
		
		for (House house : houses) {
			if (house == null)
				break;
			Resident[] tmpResidents = house.getResidents();
			for (Resident resident : tmpResidents) {
				int age = resident.getAge();
				switch (age / 10) {
				case 0:
					ageList[0] += 1;
					break;
				case 1:
					ageList[1]+= 1;
					break;
				case 2:
					ageList[2] += 1;
					break;
				case 3:
					ageList[3] += 1;
					break;
				case 4:
					ageList[4] += 1;
					break;
				case 5:
					ageList[5] += 1;
					break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					ageList[6] += 1;
					break;
				}
			}
		}
		
		return ageList;
	}
	
	public int getHouseAreaAvg(House[] houses, int houseCount) {
		int sum = 0;
		
		for (House house : houses) {
			if (house == null)
				break;
			sum += house.getHouseArea();
		}
		
		return sum / houseCount;
	}
	
	public int getHouseAreaAvg(int familyNum, House[] houses) {
		int sum = 0;
		int count = 0;
		
		for (House house : houses) {
			if (house == null)
				break;
			if (house.getResidents().length == familyNum) {
				count += 1;
				sum += house.getHouseArea();
			}
		}
		
		if (count == 0)
			return 0;
		else
			return sum / count;
	}
}

