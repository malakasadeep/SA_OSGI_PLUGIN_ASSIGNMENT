package com.mtit.service;

public interface filghtServicePublish {
	public String flightPublishService();
	public void prices();
	public double clac_flight_fee(int dest,int start,String type,String seat);
	public double cal_fee_by_class(String type,double bace,String seat);
	public double cal_fee_by_weight(double Weight);
}
