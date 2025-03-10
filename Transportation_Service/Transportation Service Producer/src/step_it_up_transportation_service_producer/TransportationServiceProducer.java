package step_it_up_transportation_service_producer;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import loyaltyprogramproducer.LoyaltyProgramService;

public class TransportationServiceProducer implements ItransportationServiceProducer {

	/////////////////////////////////////////////////////////////////////////////////////////////////
	Bundle bundle = FrameworkUtil.getBundle(this.getClass());
	BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	ServiceReference reference2 = context.getServiceReference(LoyaltyProgramService.class.getName());
	LoyaltyProgramService lpService = (LoyaltyProgramService) context.getService(reference2);
	/////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean checkLoyaltyCustomer(int id) {
		boolean isTrue = lpService.checkLoyaltyIdValidity(id);
		return isTrue;
	}

	@Override
	public double transportationBillCalculator(int noOfDays, int vehicle, int driver) {

		double tot = 0;
		double vtot = 0;
		double dtot = 2500;
		double dis = 0;

		if (vehicle == 1) {
			if (noOfDays <= 5 && noOfDays > 0) {
				dis = 0;
				vtot = 2500.00 * noOfDays;
			} else if (noOfDays > 5 && noOfDays <= 10) {
				dis = ((2500.00 * noOfDays) * 0.1);
				vtot = (2500.00 * noOfDays) - ((2500.00 * noOfDays) * 0.1);
			} else if (noOfDays > 10) {
				dis = ((2500.00 * noOfDays) * 0.2);
				vtot = (2500.00 * noOfDays) - ((2500.00 * noOfDays) * 0.2);
			} else {
				System.out.println("Error!!! Please Enter valid number for days");
			}
		} else if (vehicle == 2) {
			if (noOfDays <= 5) {
				dis = 0;
				vtot = 4500.00 * noOfDays;
			} else if (noOfDays > 5 && noOfDays <= 10) {
				dis = ((4500.00 * noOfDays) * 0.1);
				vtot = (4500.00 * noOfDays) - ((4500.00 * noOfDays) * 0.1);
			} else if (noOfDays > 10) {
				dis = ((4500.00 * noOfDays) * 0.2);
				vtot = (4500.00 * noOfDays) - ((4500.00 * noOfDays) * 0.2);
			} else {
				System.out.println("Error!!! Please Enter valid number for days");
			}
		} else if (vehicle == 3) {
			if (noOfDays <= 5) {
				dis = 0;
				vtot = 6000.00 * noOfDays;
			} else if (noOfDays > 5 && noOfDays <= 10) {
				dis = ((6000.00 * noOfDays) * 0.1);
				tot = (6000.00 * noOfDays) - ((6000.00 * noOfDays) * 0.1);
			} else if (noOfDays > 10) {
				dis = ((6000.00 * noOfDays) * 0.2);
				vtot = (6000.00 * noOfDays) - ((6000.00 * noOfDays) * 0.2);
			} else {
				System.out.println("Error!!! Please Enter valid number for days");
			}
		} else if (vehicle == 4) {
			if (noOfDays <= 5) {
				dis = 0;
				vtot = 4500.00 * noOfDays;
			} else if (noOfDays > 5 && noOfDays <= 10) {
				dis = ((10000.00 * noOfDays) * 0.1);
				tot = (10000.00 * noOfDays) - ((10000.00 * noOfDays) * 0.1);
			} else if (noOfDays > 10) {
				dis = ((10000.00 * noOfDays) * 0.2);
				vtot = (10000.00 * noOfDays) - ((10000.00 * noOfDays) * 0.2);
			} else {
				System.out.println("Error!!! Please Enter valid number for days");
			}
		} else if (vehicle == 5) {
			if (noOfDays <= 5) {
				dis = 0;
				vtot = 13000.00 * noOfDays;
			} else if (noOfDays > 5 && noOfDays <= 10) {
				dis = ((130000.00 * noOfDays) * 0.1);
				vtot = (130000.00 * noOfDays) - ((130000.00 * noOfDays) * 0.1);
			} else if (noOfDays > 10) {
				dis = ((130000.00 * noOfDays) * 0.2);
				vtot = (130000.00 * noOfDays) - ((130000.00 * noOfDays) * 0.2);
			} else {
				System.out.println("Error!!! Please Enter valid number for days");
			}
		}

		if (driver == 1) { // with driver
			dtot = dtot * noOfDays;
			tot = dtot + vtot;
		} else if (driver == 0) { // without driver
			tot = vtot;
		} else {
			System.out.println("Error!!! Please Enter valid number for days");
		}

		return tot;
	}

	public void displayBill(List<TransportationBill> obj) {

		double totalBill = 0;
		String cus_name = null;
		String ph_num = null;
		boolean loy_num = false;
		double loy_dis = 0; 

		// first
		for (TransportationBill data : obj) {
			cus_name = data.getCustomerName();
			ph_num = data.getPhoneNumber();
			loy_num = data.getIsLoyalty();
		}

		System.out.println("======================= STEP IT UP Bill =======================");

		System.out.println("Customer name        : " + cus_name);
		System.out.println("Phone number 		 : " + ph_num);

		// second
		for (TransportationBill bill : obj) {
			double amount = transportationBillCalculator(bill.getNoOfDays(), bill.getVehicle(), bill.getDriver());

			System.out.println("Number of passengers : " + bill.getPassengers());
			System.out.println("Number of days       : " + bill.getNoOfDays());
			System.out.println("Vehicle              : " + bill.getVehicle());
			System.out.println("Driver               : " + bill.getDriver());

			System.out.println();

			totalBill += amount;

		}
		
		if(loy_num) {
			loy_dis = lpService.getLoyaltyDiscount(totalBill);
		}

		System.out.println("=====================================================================");
		System.out.format("Loyalty discount = " + loy_dis);
		System.out.println("");
		System.out.format("Total = " + (totalBill-loy_dis));
		System.out.println("");
		System.out.println("");

	}

}
