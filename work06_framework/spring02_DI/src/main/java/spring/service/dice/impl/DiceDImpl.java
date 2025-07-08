package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceDImpl implements Dice{

	///Field
	private int value;
	
	public DiceDImpl() {}
	public DiceDImpl(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}
	
}
