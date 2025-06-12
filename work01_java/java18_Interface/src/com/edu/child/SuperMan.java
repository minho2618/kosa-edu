package com.edu.child;

import com.edu.parent.Flyer;

public class SuperMan implements Flyer{

	@Override
	public void flyer() {
		System.out.println("SuperMan flyer...");
	}

	@Override
	public void takeOff() {
		System.out.println("SuperMan takeOff...");
	}

	@Override
	public void land() {
		System.out.println("SuperMan land...");
	}

	public String stopBullet() {
		return "SuperMan stopBullet...";
	}
}
