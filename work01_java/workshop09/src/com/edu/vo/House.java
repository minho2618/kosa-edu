package com.edu.vo;

public class House {
	private String houseName;
	private double houseArea;
	private int buildYear;
	private String address;
	private char safetyLevel;
	
	private Resident[] residents;
	
	public House() {}

	public House(String houseName, double houseArea, int buildYear, String address, char safetyLevel) {
		this.houseName = houseName;
		this.houseArea = houseArea;
		this.buildYear = buildYear;
		this.address = address;
		this.safetyLevel = safetyLevel;
	}

	public String getHouseName() {
		return houseName;
	}

	public double getHouseArea() {
		return houseArea;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public String getAddress() {
		return address;
	}

	public char getSafetyLevel() {
		return safetyLevel;
	}

	public void setSafetyLevel(char safetyLevel) {
		this.safetyLevel = safetyLevel;
	}

	public Resident[] getResidents() {
		return residents;
	}

	public void setResidents(Resident[] residents) {
		this.residents = residents;
	}
	
	public String getHouseInfo() {		
		//System.out.println(houseArea + " " + buildYear + " " + address + " " + safetyLevel);		
		return houseArea + " " + buildYear + " " + address + " " + safetyLevel;
	}
}
