package hotel_booking_producer;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import loyaltyprogramproducer.LoyaltyProgramService;



public class HotelBillingServiceImp implements HotelBillingService{
	
	Bundle bundle = FrameworkUtil.getBundle(this.getClass());
	BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
	
	ServiceReference reference2 = context.getServiceReference(LoyaltyProgramService.class.getName());
	LoyaltyProgramService lpService = (LoyaltyProgramService)context.getService(reference2);
	
	@Override
	public boolean checkLoyaltyMember(int id) {
		boolean isTrue = lpService.checkLoyaltyIdValidity(id);
		return isTrue;
	}

	@Override
	public double calcTotalAmount(double roomAmount, int numberOfRooms, int numberOfDays) {
		// TODO Auto-generated method stub
		return roomAmount*numberOfRooms*numberOfDays;
	}

	@Override
	public void generateReport(List<HotelBillInfo> obj, CustomerProfile cObj, HotelProfile hObj) {
		
		double totalAmount = 0;
		double discount = 0;
		double serviceCharge = 500.00;
		double loyaltyDiscount = 0;
		
		System.out.println("===================================== "+hObj.getHotelName()+" Hotel Bill ====================================");
		System.out.println();
		System.out.println("Address : "+hObj.getHotelAddress());
		System.out.println("Phone   : "+hObj.getHotelPhone());
		System.out.println();
		System.out.println("===================================================================================================");
		System.out.println();
		System.out.println("Customer Name : "+cObj.getCustomerName());
		System.out.println();
		System.out.println("=====================================================================================================");
		
		System.out.format("%-18s %-10s %20s %25s %15s","Room Type","Price","Number of Rooms","Number of days of stay","Amount");
		System.out.println();
		System.out.println("=====================================================================================================");
		
		for(HotelBillInfo bil : obj) {
			double amount = calcTotalAmount(bil.getRoomPrice(),bil.getNumberOfRooms(),bil.getNumberOfDays());
			System.out.format("%-18s %-10s %10s %20s %29s",bil.getRoomType(),"Rs. "+bil.getRoomPrice(),bil.getNumberOfRooms(),bil.getNumberOfDays(),amount);
			System.out.println();
			
			if(bil.getNumberOfDays()>=5) {
				discount = (amount*10)/100.0;
			}
			
			totalAmount += amount; 
				
		}
		
		if(cObj.getIsRoyaltyMember()) {
			loyaltyDiscount = lpService.getLoyaltyDiscount(totalAmount);
		}
		
		System.out.println("=====================================================================================================");
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","Service Charges =      "+serviceCharge);
		System.out.println();
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","Discount        =      "+discount);
		System.out.println();
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","==================================");
		System.out.println();
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","LoyaltyDiscount           =      "+loyaltyDiscount);
		System.out.println();
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","==================================");
		System.out.println();
		System.out.format("%-18s %-10s %10s %25s %15s","","","","","Total           =      "+(((totalAmount+serviceCharge)-discount)-loyaltyDiscount));
		
		
		
	}

	

}
