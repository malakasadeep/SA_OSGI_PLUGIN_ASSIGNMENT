package travel_package_consumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import travel_package_producer.TravelPackageService;
import travel_package_producer.TravelPackageServiceImp;

public class ServiceActivator implements BundleActivator {

    String customerName;
    String phoneNumber;
    public int location;
    public int style;
    public int activity;
    int selectLoyalty = 0;
    boolean isRoyalty = false;
    int loyaltyNumber = 0;
    int days = 0;

    Scanner myscanner = new Scanner(System.in);
    ServiceReference serviceReference;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("\n==============================✨✨ Welcome to ABC Travel Agency ✨✨==============================\n");
        System.out.println();
		System.out.println("                              Make your tour amazing with us                               ");
		System.out.println();
        System.out.println("------------------------------🌍 Welcome To Package Selection Serbice 🚀------------------------------\n");

        serviceReference = bundleContext.getServiceReference(TravelPackageService.class.getName());
        TravelPackageService servicePublish = (TravelPackageService) bundleContext.getService(serviceReference);

        System.out.print("🔹 Enter Your Name: ");
        customerName = myscanner.nextLine();

        System.out.print("📞 Enter Your Phone Number: ");
        phoneNumber = myscanner.nextLine();

        do {
            System.out.println("\n💎 Are you a Loyalty Member?");
            System.out.println("   1️⃣ Yes");
            System.out.println("   2️⃣ No");
            System.out.print("👉 Choose an option: ");
            selectLoyalty = myscanner.nextInt();

            if (selectLoyalty == 1) {
                while (true) {
                    System.out.print("🔑 Enter your 6-digit Loyalty Number: ");
                    loyaltyNumber = myscanner.nextInt();
                    if (servicePublish.checkLoyaltyMember(loyaltyNumber)) {
                        System.out.println("✅ Your Loyalty Number is Valid!");
                        isRoyalty = true;
                        break;
                    } else {
                        System.out.println("❌ Invalid Loyalty Number. Try again?");
                        System.out.println("   1️⃣ Yes");
                        System.out.println("   2️⃣ No");
                        int need = myscanner.nextInt();
                        if (need == 2) break;
                    }
                }
                break;
            } else if (selectLoyalty == 2) {
                break;
            }
        } while (selectLoyalty != 1 || selectLoyalty != 2);

        System.out.println("\n🌎 ✈️ --------------- Destination Options --------------- ✈️ 🌎\n");
        System.out.println("  1️⃣  Paris, France           💰 Rs.30000.00");
        System.out.println("  2️⃣  Bali, Indonesia         💰 Rs.40000.00");
        System.out.println("  3️⃣  Tokyo, Japan            💰 Rs.50000.00");
        System.out.println("  4️⃣  Maldives                💰 Rs.45000.00");
        System.out.println("  5️⃣  New York, USA           💰 Rs.60000.00");
        System.out.println("  6️⃣  Rome, Italy             💰 Rs.52000.00");
        System.out.println("  7️⃣  Sydney, Australia       💰 Rs.24000.00");
        System.out.println("  8️⃣  Dubai, UAE              💰 Rs.34000.00");
        System.out.println("  9️⃣  Cape Town, South Africa 💰 Rs.35000.00");
        System.out.println("  🔟  Santorini, Greece       💰 Rs.36000.00");
        
        System.out.print("\n🌍 Enter the number of your preferred destination: ");
        location = myscanner.nextInt();

        System.out.println("\n🏕️ 🏨 --------------- Travel Style Options --------------- 🏨 🏕️\n");
        System.out.println("  1️⃣  Backpacker               💰 Rs.2000000.00");
        System.out.println("  2️⃣  Luxury Traveler          💰 Rs.3000000.00");
        System.out.println("  3️⃣  Adventure / Active       💰 Rs.2500000.00");
        System.out.println("  4️⃣  Group Tour / Cruise      💰 Rs.1000000.00");
        System.out.println("  5️⃣  Private Tour             💰 Rs.1500000.00");
        System.out.println("  6️⃣  Slow / Long-Term Travel  💰 Rs.1200000.00");
        
        System.out.print("\n🎒 Select your preferred travel style: ");
        style = myscanner.nextInt();

        System.out.println("\n🎭 🎢 --------------- Activity Options --------------- 🎢 🎭\n");
        System.out.println("  1️⃣  Sightseeing             💰 Rs.1000.00");
        System.out.println("  2️⃣  Hiking                  💰 Rs.5000.00");
        System.out.println("  3️⃣  Visiting Museums        💰 Rs.3000.00");
        System.out.println("  4️⃣  Pack and Paddle         💰 Rs.2000.00");

        System.out.print("\n🎟️ Select your preferred activity: ");
        activity = myscanner.nextInt();

        System.out.print("\n🗓️ Enter the number of days you plan to stay: ");
        days = myscanner.nextInt();

        System.out.println("\n💼 📜 =========== Your Travel Package =========== 📜 💼");
        System.out.println();
        System.out.println("👤 Customer Name: " + customerName);
        System.out.println("📞 Phone Number: " + phoneNumber);
        System.out.println("📍 Destination: " + getLocationName(location));
        System.out.println("🎒 Travel Style: " + style);
        System.out.println("🎭 Activity: " + activity);
        System.out.println("🗓️ Duration: " + days + " days");

        TravelPackageService obj = new TravelPackageServiceImp();
        double total = obj.calculateEstimatedCost(location, style, activity, days);

        System.out.println("\n💰 Total Travel Budget: Rs." + total);
        obj.displayBill(total, customerName, phoneNumber, isRoyalty);

        System.out.println("\n-----------------🎉 🎊 Thank You for Choosing ABC Travel Agency! 🎊 🎉-----------------\n");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("\n👋 Goodbye! Have a fantastic day!\n");
        bundleContext.ungetService(serviceReference);
    }

    private String getLocationName(int location) {
        switch (location) {
            case 1: return "Paris, France";
            case 2: return "Bali, Indonesia";
            case 3: return "Tokyo, Japan";
            case 4: return "Maldives";
            case 5: return "New York, USA";
            case 6: return "Rome, Italy";
            case 7: return "Sydney, Australia";
            case 8: return "Dubai, UAE";
            case 9: return "Cape Town, South Africa";
            case 10: return "Santorini, Greece";
            default: return "Unknown Destination";
        }
    }
}
