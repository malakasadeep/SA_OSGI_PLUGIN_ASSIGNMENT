package hotel_booking_producer;

public class CustomerProfile {
	
	private String customerName;
	private String mobileNumber;
	private boolean isRoyaltyMember;
	
	public CustomerProfile(String customerName, String mobileNumber, boolean isRoyaltyMember) {
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.isRoyaltyMember = isRoyaltyMember;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public boolean getIsRoyaltyMember() {
		return isRoyaltyMember;
	}
	
	

}
