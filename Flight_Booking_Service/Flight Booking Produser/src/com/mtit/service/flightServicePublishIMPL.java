package com.mtit.service;

public class flightServicePublishIMPL implements filghtServicePublish {
	
	private int desti;
	private int start1;
	private String Class;
	private double feeBy_class;
	private double fee;
	private double base_amount;
	private double tax;
	private double weight;
	private double weight_fee;
	
	public flightServicePublishIMPL() {
		desti=0;
		start1=0;
		fee=0.0;
		base_amount=0.0;
		tax=5000;
	}

	@Override
	public String flightPublishService() {
		// TODO Auto-generated method stub
		return "Execute the publish service of flightServicePublisher";
	}

	@Override
	public void prices() {
		// TODO Auto-generated method stub
		System.out.println("\n🌍 ✈️  **Flight Tour Prices** ✈️ 🌍");
		System.out.println("=========================================");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "From", "To", "Price (Rs)");
		System.out.println("-----------------------------------------");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "1️ India", "2️ Australia", "100,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "2️ Australia", "3️ Japan", "200,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "3️ Japan", "4️ France", "300,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "4️ France", "5️ Italy", "400,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "1️ India", "3️ Japan", "500,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "2️ Australia", "4️ France", "600,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "3️ Japan", "5️ Italy", "700,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "1️ India", "5️ Italy", "800,000");
		System.out.printf("| %-10s | %-10s | %-10s |\n", "2️ Australia", "5️ Italy", "700,000");
		System.out.println("=========================================");
		
	}

	@Override
	public double clac_flight_fee(int dest, int start, String type, String seat) {
		// TODO Auto-generated method stub
		this.desti=dest;
		this.start1=start;
		this.Class=type;
		
		if ((start1==1&&desti==2)||(start1==2&&desti==1)){
			base_amount=100000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if ((start1==2&&desti==3)||(start1==3&&desti==2)){
			base_amount=200000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if ((start1==3&&desti==4)||(start1==4&&desti==3)) {
			base_amount=300000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if ((start1==4&&desti==5)||(start1==5&&desti==4)){
			base_amount=400000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if ((start1==1&&desti==3)||(start1==3&&desti==1)){
			base_amount=500000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if((start1==2&&desti==4) ||(start1==4&&desti==2)){
			base_amount=600000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if((start1==3&&desti==5)||(start1==5&&desti==3)) {
			base_amount=700000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if((start1==1&&desti==5)||(start1==5&&desti==1)) {
			base_amount=800000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else if((start1==2&&desti==5)||(start1==5&&desti==2)) {
			base_amount=700000.00;
			fee=cal_fee_by_class(type,base_amount,seat);
		}
		else {
			return 0.0;
		}
		fee=fee+tax;
		return fee;	
	}

	@Override
	public double cal_fee_by_class(String type, double bace, String seat) {
		// TODO Auto-generated method stub
		switch(type) {
		case "f":
			feeBy_class=bace+75000;
			if(seat.equals("w")||seat.equals("W"))
				feeBy_class=feeBy_class+5000;
			break;
		case "b":
			feeBy_class=bace+35000;
			if(seat.equals("w")||seat.equals("W"))
				feeBy_class=feeBy_class+5000;
			break;
		case "e":
			feeBy_class=bace;
			if(seat.equals("w")||seat.equals("W"))
				feeBy_class=feeBy_class+5000;
			break;
		default:
			return 0.0;
		}
		
		return feeBy_class;
	}

	@Override
	public double cal_fee_by_weight(double Weight) {
		// TODO Auto-generated method stub
		
		this.weight=Weight;
		
		if(weight<=20) {
			weight_fee=0.0;
		}else {
			weight=weight-20;
			weight_fee=weight*1000;
		}
		
		return weight_fee;
	}
	
}
