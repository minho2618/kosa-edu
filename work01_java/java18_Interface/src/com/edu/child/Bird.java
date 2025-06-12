package com.edu.child;

import com.edu.parent.Flyer;

public class Bird implements Flyer {

	@Override
	public void flyer() {
		System.out.println("Bird flyer...");		
	}

	@Override
	public void takeOff() {
		System.out.println("Bird takeOff...");	
	}

	@Override
	public void land() {
		System.out.println("Bird land...");	
	}
	
	public String layEgg() {
		return "알을 낳는다.";
	}
}
