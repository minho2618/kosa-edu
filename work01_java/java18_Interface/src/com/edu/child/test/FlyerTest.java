package com.edu.child.test;

import com.edu.child.AirPlane;
import com.edu.child.Bird;
import com.edu.child.SuperMan;
import com.edu.parent.Flyer;

public class FlyerTest {

	public static void main(String[] args) {
		
		//Flyer f = new Flyer();
		//AirPlane a = new AirPlane();
		//SuperMan man = new SuperMan();
		// Polymorphism
		
		Flyer[] flies = {
				new Bird(),
				new SuperMan(),
				new Bird(),
		};
		
		for (Flyer f : flies) {
			f.flyer();
			f.takeOff();
			f.land();
			System.out.println("---------------------------");
		}
		
		for (Flyer f : flies) {
			if (f instanceof Bird) {
				System.out.println(((Bird) f).layEgg());
			} else if (f instanceof SuperMan) {
				System.out.println(((SuperMan) f).stopBullet());
			}
			System.out.println("---------------------------");
		}
	}

}
