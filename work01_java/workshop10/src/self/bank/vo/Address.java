package self.bank.vo;

public class Address {
	private int zipCode;
	private String region;
	private String city;
	
	public final static int DEFAULT_ZIPCODE = 0000;
	public final static String DEFAULT_REGION = "경기도";
	public final static String DEFAULT_CITY = "평택";
	
	public Address() {
		this(DEFAULT_ZIPCODE, DEFAULT_REGION, DEFAULT_CITY);
	}
	
	public Address(int zipCode, String region, String city) {
		this.zipCode = zipCode;
		this.region = region;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", region=" + region + ", city=" + city + "]";
	}
	
}
