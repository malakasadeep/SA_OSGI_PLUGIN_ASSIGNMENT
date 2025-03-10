package transportation_service_consumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import step_it_up_transportation_service_producer.ItransportationServiceProducer;
import step_it_up_transportation_service_producer.TransportationBill;

//import osgi_service_publisher.IservicePublish;
//import step_it_up_transportation_service_producer.ItransportationServiceProducer;

public class TransportSrviceConsumerActivator implements BundleActivator {

	ServiceReference serviceref;

	public void start(BundleContext context) throws Exception {
		System.out.println("Transportation Subscriber Service is Starting.............");

		serviceref = context.getServiceReference(ItransportationServiceProducer.class.getName()); // refer registered
																									// service

		ItransportationServiceProducer servicepublish = (ItransportationServiceProducer) context.getService(serviceref);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		String customerName;
		String phoneNumber;
		int passengers = 0;
		int noOfDays = 0;
		int vehicle = 0;
		int driver = 0;
		int decision = 0;
		int selectLoylty = 0;
		boolean isRoyalty = false;
		int loyaltyNumber= 0;
		
		ArrayList<TransportationBill> list = new ArrayList<TransportationBill>();

		Scanner myObj = new Scanner(System.in);

		// take inputs
		System.out.print("Name:");
		customerName = myObj.nextLine();
		// System.out.println();

		System.out.print("Phone number:");
		phoneNumber = myObj.nextLine();

		/////////////////////////////////////////////////////////////////////////////////

		do {

			System.out.println("Are you a Loyalty Member: 1.Yes 2.No");

			selectLoylty = myObj.nextInt();
			if (selectLoylty == 1) {

				while (true) {
					System.out.print("Enter your 6 digit royalty number : ");
					loyaltyNumber = myObj.nextInt();
					if (servicepublish.checkLoyaltyCustomer(loyaltyNumber)) {
						System.out.println("Your Royalty Number is Valid!");
						isRoyalty = true;
						break;
					} else {
						System.out.println("The Royalty number is invalid do you need to try again : 1. Yes    2. No");
						int need = myObj.nextInt();
						if (need == 1) {
							continue;
						} else {
							break;
						}
					}

				}
				;

				break;
			} else if (selectLoylty == 2) {

				break;
			}

		} while (selectLoylty != 1 || selectLoylty != 2);

		/////////////////////////////////////////////////////////////////////////////////

		while (true) {// another existing order block => add another vehicle to existing order

			System.out.print("Number of passengers:");
			passengers = myObj.nextInt();
			// System.out.println();

			System.out.print("Number of days:");
			noOfDays = myObj.nextInt();
			// System.out.println();

			System.out.print("Do you want a driver(If yes press 1, If no press 0):");
			driver = myObj.nextInt();
			System.out.println();

			while (driver != 1 && driver != 0) {

				System.out.println("Error!!! Enter a valid number.");
				System.out.println("Do you want a driver(If yes press 1, If no press 0):");
				driver = myObj.nextInt();
				System.out.println();

			}

			System.out.println("===================================================================");
			System.out.format("%-15s %10s %18s %16s", "Vehicle number", "Vehicle type", "Passenger Limit",
					"Unit price(Rs)");
			System.out.println();
			System.out.println("===================================================================");
			System.out.format("%7s %17s %17s %18s", "1", "Bike", "1 to 2", "2500.00");
			System.out.println();
			System.out.format("%7s %17s %17s %18s", "2", "Car", "3 to 4", "4500.00");
			System.out.println();
			System.out.format("%7s %17s %17s %18s", "3", "Van", "5 to 14", "6000.00");
			System.out.println();
			System.out.format("%7s %17s %17s %18s", "4", "Rosa Bus", "15 to 25", "10000.00");
			System.out.println();
			System.out.format("%7s %17s %17s %18s", "5", "Bus", "above 25", "130000.00");
			System.out.println();
			System.out.println();

			System.out.print("Vehicle number : ");
			vehicle = myObj.nextInt();
			System.out.println(" ");

			// vehicle check box => check whether customer selects the correct vehicle
			// according to the passengers
			if (vehicle == 1 || vehicle == 2 || vehicle == 3 || vehicle == 4 || vehicle == 5) {

				if (passengers > 25) {
					while (vehicle != 5) {
						System.out.println("Can not load your gang.Please select a BUS(5).");
						System.out.println(" ");

						System.out.print("Vehicle : ");
						vehicle = myObj.nextInt();
					}
					System.out.println("YOUR VEHICLE WILL BE READY");
					System.out.println(" ");
				} else if (passengers > 14 && passengers <= 25) {
					while (vehicle != 4 && vehicle != 5) {
						System.out.println("Can not load your gang.Please select a ROSA BUS(4) or a BUS(5).");
						System.out.println(" ");

						System.out.print("Vehicle : ");
						vehicle = myObj.nextInt();
					}
					System.out.println("YOUR VEHICLE WILL BE READY");
					System.out.println(" ");
				} else if (passengers > 4 && passengers <= 14) {
					while (vehicle != 3 && vehicle != 4) {
						if (vehicle == 1 || vehicle == 2) {
							System.out.println("Can not load your gang.Please select a VAN(3) or a ROSA BUS(4).");
							System.out.println(" ");

							System.out.print("Vehicle : ");
							vehicle = myObj.nextInt();
						} else if (vehicle == 5) {
							System.out
									.println("A Bus is too big for your gang.Please select a VAN(3) or a ROSA BUS(4).");
							System.out.println(" ");

							System.out.print("Vehicle : ");
							vehicle = myObj.nextInt();
						}
					}
					System.out.println("YOUR VEHICLE WILL BE READY");
					System.out.println(" ");
				} else if (passengers == 3 || passengers == 4) {
					while (vehicle != 2 && vehicle != 3) {
						if (vehicle == 1) {
							System.out.println("Can not load your gang.Please select a VAN(3) or a CAR(2).");
							System.out.println(" ");

							System.out.print("Vehicle : ");
							vehicle = myObj.nextInt();
						} else if (vehicle == 4 || vehicle == 5) {
							System.out.println("A Bus is too big for your gang.Please select a VAN(3) or a CAR(2)");
							System.out.println(" ");

							System.out.print("Vehicle : ");
							vehicle = myObj.nextInt();
						}
					}
					System.out.println("YOUR VEHICLE WILL BE READY");
					System.out.println(" ");
				} else if (passengers <= 2) {
					while (vehicle != 1 && vehicle != 2) {

						System.out.println(
								"Other type of vehicles are too big for you.Please select a CAR(2) or a BIKE(1).");
						System.out.println(" ");

						System.out.print("Vehicle : ");
						vehicle = myObj.nextInt();

					}
					System.out.println("YOUR VEHICLE BE READY");
					System.out.println(" ");
				}

			} else {
				System.out.println("Error!!! Please select a valid number.");
				System.out.println(" ");
				continue;
			}
			// vehicle check box

			// calculate bill
			TransportationBill bill = new TransportationBill(customerName, phoneNumber, passengers, noOfDays, vehicle,
					driver,isRoyalty);
			list.add(bill);

			// display bill
			servicepublish.displayBill(list);

			// continue order vehicles
			System.out
					.print("Do you want make another order with your previous order? (If yes press 1, If no press 0)");
			decision = myObj.nextInt();
			System.out.println();

			while (decision != 1 && decision != 0) {

				System.out.print("Do you want make another with your previous order? (If yes press 1, If no press 0)");
				decision = myObj.nextInt();
				System.out.println();

			}

			System.out.println();

			if (decision == 1) {
				continue;
			} else if (decision == 0) {
				System.out.println("Thankyou!!!!");
				System.out.println("");
				System.out.println("Contact us in case of any problem.");
				System.out.println("****24/7 Service.****");
				System.out.println("phone : 011 2 705 311");
				System.out.println("email : stepitup.tranportation@gmail.com");
				break;
			}

		} // another existing order block
	}

	public void stop(BundleContext context) throws Exception {

		System.out.println("Bye");
		context.ungetService(serviceref);

	}

}
