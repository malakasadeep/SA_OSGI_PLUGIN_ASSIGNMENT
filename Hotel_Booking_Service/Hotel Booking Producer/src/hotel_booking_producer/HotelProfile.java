package hotel_booking_producer;

public class HotelProfile {
	
	private String hotelName;
	private String hotelAddress;
	private String hotelPhone;
	
	public HotelProfile(String hotelName, String hotelAddress, String hotelPhone) {
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhone = hotelPhone;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}	
	

}
