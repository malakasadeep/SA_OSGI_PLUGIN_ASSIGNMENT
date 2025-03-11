package flightbookingsubscriber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.service.filghtServicePublish;
import loyaltyprogramproducer.LoyaltyProgramService;

public class flightsubscriberActivator implements BundleActivator {
	
	ServiceReference flightServiceReference;
	ServiceReference loyaltyServiceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("✨✈️ ------ Welcome to Flight Booking Service ------ ✈️✨");

		// Getting Flight Service
		flightServiceReference = context.getServiceReference(filghtServicePublish.class.getName());
		filghtServicePublish flightService = (filghtServicePublish) context.getService(flightServiceReference);

		// Getting Loyalty Service
		loyaltyServiceReference = context.getServiceReference(LoyaltyProgramService.class.getName());
		LoyaltyProgramService loyaltyService = (LoyaltyProgramService) context.getService(loyaltyServiceReference);
		
		Scanner sc = new Scanner(System.in);
		
		int destNum, start;
		String flightClass, seatType, fname, lname, phone, passportID;
		double bagKg, totalFee;
		String repeatBooking = null;
		int loyaltyID;

		System.out.print("👤 Enter your First Name: ");
		fname = sc.next();
		
		System.out.print("👤 Enter your Last Name: ");
		lname = sc.next();
		
		System.out.print("📞 Enter your Phone number: ");
		phone = sc.next();
		
		System.out.print("🛂 Enter your Passport number: ");
		passportID = sc.next();
		
		do {
			System.out.println("\n-------------------------------------------------");
			System.out.print("📅 Enter your preferred flight date (yyyy-mm-dd): ");
			String inputDate = sc.next();
	        
			LocalDate currentDate = LocalDate.now();
			LocalDate enteredDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
	        
			if (enteredDate.isBefore(currentDate) || enteredDate.isEqual(currentDate)) {
				System.out.println("⚠️ Invalid date! You cannot book for today or past dates.");
			} else {
				System.out.println("\n🌍 ✈️  Available Flight Destinations:");
				System.out.println("  1️ India");
				System.out.println("  2️ Australia");
				System.out.println("  3️ Japan");
				System.out.println("  4️ France");
				System.out.println("  5️ Italy");
				System.out.println("-------------------------------------------------");
				flightService.prices();
				
				System.out.print("\n📍 Enter Starting Place Number: ");
				start = sc.nextInt();
				
				System.out.print("📍 Enter Destination Number: ");
				destNum = sc.nextInt();
				
				System.out.println("\n🎫 Select Flight Class:");
				System.out.println("  💎 f - First Class (+75,000 Rs)");
				System.out.println("  🏢 b - Business Class (+35,000 Rs)");
				System.out.println("  ✈️ e - Economy Class (Base Price)");
				System.out.print("🔽 Enter Your Preferred Class: ");
				flightClass = sc.next();
				
				System.out.println("\n🧳 Luggage Policy:");
				System.out.println("  ✅ First 20Kg free. Extra weight costs Rs 1000 per Kg.");
				System.out.print("💼 Enter Luggage Weight (Kg): ");
				bagKg = sc.nextDouble();
				
				System.out.println("\n🪑 Seat Selection:");
				System.out.println("  🌟 Window Seat? Enter 'w' or 'W' (+5000 Rs). Otherwise, press any key.");
				seatType = sc.next();

				// Calculate the total flight fee
				totalFee = flightService.clac_flight_fee(destNum, start, flightClass, seatType);
				totalFee += flightService.cal_fee_by_weight(bagKg);

				// Apply loyalty discount if user has a valid loyalty ID
				System.out.println("\n🎟️ Do you have a Loyalty ID? (Enter ID or -1 to skip): ");
				loyaltyID = sc.nextInt();

				double discount = 0;
				if (loyaltyID != -1 && loyaltyService.checkLoyaltyIdValidity(loyaltyID)) {
					discount = loyaltyService.getLoyaltyDiscount(totalFee);
					System.out.println("✅ Loyalty Discount Applied: " + discount + " Rs 🎉");
					totalFee -= discount;
				} else {
					System.out.println("❌ No valid Loyalty ID provided. No discount applied.");
				}
				
				// Display Final Booking Details
				System.out.println("\n📜 ✨ **Booking Receipt** ✨");
				System.out.println("===============================================");
				System.out.printf("| %-18s : %-20s |\n", "Passenger Name", fname + " " + lname);
				System.out.printf("| %-18s : %-20s |\n", "Phone", phone);
				System.out.printf("| %-18s : %-20s |\n", "Passport ID", passportID);
				System.out.printf("| %-18s : %-20s |\n", "Flight Date", enteredDate);
				System.out.println("-----------------------------------------------");
				System.out.printf("| %-18s : %-10s |\n", "Flight Class", flightClass.toUpperCase());
				System.out.printf("| %-18s : %-10s |\n", "Luggage (Kg)", bagKg);
				System.out.printf("| %-18s : %-10s |\n", "Seat Type", seatType.toUpperCase());
				System.out.println("-----------------------------------------------");
				System.out.printf("| %-18s : Rs. %-10.2f |\n", "Base Price", totalFee + discount);
				if (discount > 0) {
					System.out.printf("| %-18s : Rs. -%-10.2f |\n", "Loyalty Discount", discount);
				}
				System.out.printf("| %-18s : Rs. %-10.2f |\n", "Final Total", totalFee);
				System.out.println("===============================================");
				System.out.println("🎉 Thank you for booking with us! Have a great flight! ✈️");

			}
			
			System.out.print("\n🔄 Do you want to book another flight? (y/Y for Yes): ");
			repeatBooking = sc.next();
	        
		} while (repeatBooking.equalsIgnoreCase("y"));
		
		System.out.println(flightService.flightPublishService());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("❌ Flight Booking Service Stopped.");
		context.ungetService(flightServiceReference);
		context.ungetService(loyaltyServiceReference);
	}
}
