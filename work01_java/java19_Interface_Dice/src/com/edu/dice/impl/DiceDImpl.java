package com.edu.dice.impl;

import java.util.Random;

import com.edu.dice.Dice;

public class DiceDImpl implements Dice {
	private int value;
	
	public DiceDImpl() {
		System.out.println("::"+getClass().getName()+"기본 생성자....");
	}
	
	public DiceDImpl(int value) {
		this.value = value;
		System.out.println("::"+getClass().getName()+"명시적 생성자....");
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

}
