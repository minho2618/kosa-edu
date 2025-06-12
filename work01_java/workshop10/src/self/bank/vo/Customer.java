package self.bank.vo;

public class Customer {
	private String name;
	private int ssn;
	private Account account;
	private Address address;
	
	public final static String DEFAULT_NAME = "홍길동";
	public final static Account DEFALUT_ACCOUNT = new Account();
	public final static Address DEFALUT_ADDRESS = new Address();
	
	public Customer() {}
	
	public Customer(int ssn) {
		this(DEFAULT_NAME, ssn, DEFALUT_ACCOUNT, DEFALUT_ADDRESS);
	}
	
	public Customer(String name, int ssn, Address address) {
		this(name, ssn, DEFALUT_ACCOUNT, address);
	}

	public Customer(String name, int ssn, Account account, Address address) {
		this.name = name;
		this.ssn = ssn;
		this.account = account;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", account=" + account + ", address=" + address + "]";
	}	
	
}
