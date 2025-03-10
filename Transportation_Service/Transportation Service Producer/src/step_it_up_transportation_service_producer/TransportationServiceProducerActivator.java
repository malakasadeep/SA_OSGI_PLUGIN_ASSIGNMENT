package step_it_up_transportation_service_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TransportationServiceProducerActivator implements BundleActivator {


	    //register the service
		ServiceRegistration producerservicereg;
		
		public void start(BundleContext context) throws Exception {
			System.out.println("STEP IT UP Transportation Service Producer Starts.....");
			ItransportationServiceProducer pbService = new TransportationServiceProducer();
			
			//register the service
			producerservicereg = context.registerService(ItransportationServiceProducer.class.getName(),pbService,null);
		}

		public void stop(BundleContext context) throws Exception {
			System.out.println("STEP IT UP Transportation Service Producer Ends!!!!");
			producerservicereg.unregister();
		}

}
