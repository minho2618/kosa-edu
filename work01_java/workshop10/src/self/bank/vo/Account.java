package self.bank.vo;

public class Account {
	private int balance;
	
	public static final int DEFAULT_BALANCE = 1000;

	public Account() {
		this(DEFAULT_BALANCE);
	}
	
	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		if (money < 1000) {
			System.out.println("1000원 이상부터 예금이 가능합니다.");
			return;
		}
		balance += money;
	}
	
	public void withdraw(int money) {
		if (balance < money) {
			System.out.println("잔액만큼 출금할 수 있습니다.");
			return;
		}
		balance -= money;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}	
	
}
