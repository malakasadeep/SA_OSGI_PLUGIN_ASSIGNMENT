package travel_package_producer;

import java.util.List;



public interface TravelPackageService {
	
	public String publishService();
	
	boolean checkLoyaltyMember(int id);
	
	public void displayBill(double amount, String name, String phone, Boolean loyal);
	
	public double calculateEstimatedCost(int location, int style, int activity, int days);


}
