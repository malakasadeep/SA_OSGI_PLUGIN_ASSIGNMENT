package hotel_booking_producer;

public class HotelBillInfo {
	
	private String customerName;
	private String phoneNumber;
	private String hotel;
	private int roomTypeNumber;
	private int numberOfRooms;
	private int numberOfDays;
	private double roomPrice;
	
	public HotelBillInfo(String customerName, String phoneNumber, String hotel, int roomTypeNumber, int numberOfRooms,
			int numberOfDays,double roomPrice) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.hotel = hotel;
		this.roomTypeNumber = roomTypeNumber;
		this.numberOfRooms = numberOfRooms;
		this.numberOfDays = numberOfDays;
		this.roomPrice = roomPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getHotel() {
		return hotel;
	}

	public int getRoomTypeNumber() {
		return roomTypeNumber;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public double getRoomPrice() {
		
		return roomPrice;
		
	}
	
	public String getRoomType() {
		if (this.roomTypeNumber == 1) {
			return "Standered Room";
			
		}else if(this.roomTypeNumber == 2) {
			return "Deluxe Room";
			
		}else if(this.roomTypeNumber == 3) {
			return "Luxury Room";
			
		}else {
			return null;
		}
		
	}

}
