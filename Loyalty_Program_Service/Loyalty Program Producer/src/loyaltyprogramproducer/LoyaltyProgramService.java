package loyaltyprogramproducer;

public interface LoyaltyProgramService {
	
	boolean checkLoyaltyIdValidity(int id);
	double getLoyaltyDiscount(double total);

}
