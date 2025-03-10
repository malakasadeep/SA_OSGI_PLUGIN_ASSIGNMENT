package loyaltyprogramproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class LoyaltyActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("loyalty service started!");
		LoyaltyProgramService hillCottageHotel = new LoyaltyProgramServiceImp();
		
		serviceRegistration = context.registerService(LoyaltyProgramService.class.getName(), hillCottageHotel, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Loyalty program Stoped!!!");
		serviceRegistration.unregister();
		
	}

}
