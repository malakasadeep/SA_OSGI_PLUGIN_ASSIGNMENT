package travel_package_producer;

public class CalcFeeByStyle {
	
	private int style;
	private double fee;
	
	public CalcFeeByStyle() {
		style = 0 ;
		fee = 0.0;
	}
	
	public double calc_fee(double amount, int style) {
		    if(style == 1) {
				fee = amount + 2000000;
			}else if(style == 2){
				fee = amount + 3000000;
			}else if(style == 3){
				fee = amount + 2500000;
			}else if(style == 4){
				fee = amount + 1000000;
			}else if(style == 5){
				fee = amount + 1500000;
			}else if(style == 6){
				fee = amount + 1200000;
			}

		return fee;
	}

}
