package travel_package_producer;

public class CalcFeeByActivity {
	
	private int Activity;
	private double payment;
	
	public CalcFeeByActivity() {
		Activity = 0;
		payment = 0.0;
	}
	
	public double calc_payment(double amount, int Activity) {
		if(Activity == 1) {
			payment = amount + 1000;
		}else if(Activity == 2){
			payment = amount + 5000;
		}else if(Activity == 3){
			payment = amount + 3000;
		}else if(Activity == 4){
			payment = amount + 2000;
		}
		
		return payment;
	}

}
