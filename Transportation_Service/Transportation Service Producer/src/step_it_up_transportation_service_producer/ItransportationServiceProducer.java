/**
 * 
 */
package step_it_up_transportation_service_producer;

import java.util.List;

/**
 * @author miule
 *
 */
public interface ItransportationServiceProducer {
	
	public double transportationBillCalculator(int noOfDays, int vehicle, int driver);
	public void displayBill(List<TransportationBill> obj);
	public boolean checkLoyaltyCustomer(int id);


}
