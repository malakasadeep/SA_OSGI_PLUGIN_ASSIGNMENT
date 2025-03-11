package travel_package_producer;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import loyaltyprogramproducer.LoyaltyProgramService;

public class TravelPackageServiceImp implements TravelPackageService {
	
	private double amount = 0;

	Bundle bundle = FrameworkUtil.getBundle(this.getClass());
	BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
	
	ServiceReference reference2 = context.getServiceReference(LoyaltyProgramService.class.getName());
	LoyaltyProgramService lpService = (LoyaltyProgramService) context.getService(reference2);
	
	@Override
	public String publishService() {
		// TODO Auto-generated method stub
		return ("Travel Package Service Started");
	}

	@Override
	public boolean checkLoyaltyMember(int id) {
		boolean isTrue = lpService.checkLoyaltyIdValidity(id);
		return isTrue;
	}


	@Override
	public double calculateEstimatedCost(int location, int style, int activity, int days) {
        // Calculate estimated cost based on location, travel style, and activities
		
		CalcFeeByStyle obj = new CalcFeeByStyle();
		
		CalcFeeByActivity obj2 = new CalcFeeByActivity();
		
		if(location == 1) {
			amount = 30000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
			
		}else if(location == 2) {
			amount = 40000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 3) {
			amount = 50000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 4) {
			amount = 450000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 5) {
			amount = 60000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 6) {
			amount = 520000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 7) {
			amount = 240000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 8) {
			amount = 340000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 9) {
			amount = 350000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}else if(location == 10) {
			amount = 360000;
			amount = amount + obj.calc_fee(activity, style) + obj2.calc_payment(style, activity);
		}
		
		
        
		return amount * days;
    }

	@Override
	public void displayBill(double amount, String name, String phone, Boolean loyal) {
	    double loy_dis = 0;

	    System.out.println("\n=====================================================");
	    System.out.println("                  ✨ STEP IT UP Bill ✨              ");
	    System.out.println("=====================================================");
	    System.out.println("👤 Customer Name       : " + name);
	    System.out.println("📞 Phone Number        : " + phone);
	    System.out.println("-----------------------------------------------------");

	    if (loyal) {
	        loy_dis = lpService.getLoyaltyDiscount(amount);
	        System.out.println("🎉 Loyalty Discount Applied! 🎉");
	    }

	    System.out.printf("💰 Subtotal           : Rs. %, .2f%n", amount);
	    System.out.printf("🎖️ Loyalty Discount   : Rs. %, .2f%n", loy_dis);
	    System.out.println("-----------------------------------------------------");
	    System.out.printf("🤑 Total Payable       : Rs. %, .2f%n", (amount - loy_dis));

	    System.out.println("=====================================================");
	    System.out.println("  			🚀 2025 ABC Company 🚀                 ");
	    System.out.println("    ✈️ Have a wonderful and safe journey! ✈️       ");
	    System.out.println("=====================================================\n");
	}
}
