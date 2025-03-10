package hotel_booking_producer;

import java.util.List;

public interface HotelBillingService {
	
	boolean checkLoyaltyMember(int id);
	double calcTotalAmount(double roomAmount, int numberOfRooms, int numberOfDays);
	void generateReport(List<HotelBillInfo> obj, CustomerProfile cObj, HotelProfile hObj);

}
