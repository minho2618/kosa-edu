package com.edu.dice.play;

import com.edu.dice.Dice;
import com.edu.dice.DiceA;
import com.edu.dice.DiceB;

/*
 *	FileName : Player02.java
 *	ㅇ DiceA 을 직접적으로 연하지 않고 인터페이스 Dice와 경결되어 느슨하 작업을 징ㄴ행
 *  ㅇ Dice와 결합되었기 때문에 Dice의 자식 클래스인 DiceAImpl, DiceAImpl, DiceAImpl과도
 *     언제든기 연결될 수 있다.
 *     해당 소스코드 수정없이 가능하다
 *     결과적으로 코드의 재사용성이 좋아졌다.
 */
public class Player02 {

	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}
	
	public Player02(Dice dice) {
		super();
		this.dice = dice;
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class