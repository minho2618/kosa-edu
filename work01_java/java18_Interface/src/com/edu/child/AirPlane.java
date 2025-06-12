package com.edu.child;

import com.edu.parent.Flyer;
// class는 abstract 메소드가 있으면 안된다.
public abstract class AirPlane implements Flyer {

	@Override
	public void flyer() {
		System.out.println("AirPlane flyer...");
	}

	@Override
	public void takeOff() {
		System.out.println("AirPlane takeOff...");
	}

//	@Override
//	public void land() {
//		System.out.println("AirPlane land...");
//	}

}