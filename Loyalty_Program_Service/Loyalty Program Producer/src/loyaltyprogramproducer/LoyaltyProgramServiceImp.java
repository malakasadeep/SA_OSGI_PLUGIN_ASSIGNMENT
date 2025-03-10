package loyaltyprogramproducer;

public class LoyaltyProgramServiceImp implements LoyaltyProgramService{

	@Override
	public boolean checkLoyaltyIdValidity(int id) {
		int[] idArray = {854601,290813,760924,495367,128745};
		boolean isTrue = false;
		for(int i=0;i<idArray.length;i++) {
			if(id == idArray[i]) {
				isTrue = true;
			}
		}
		return isTrue;
	}

	@Override
	public double getLoyaltyDiscount(double total) {
		
		return total*0.08;
	}

}
