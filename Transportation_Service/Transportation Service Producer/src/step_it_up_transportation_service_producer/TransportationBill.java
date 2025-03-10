package step_it_up_transportation_service_producer;

public class TransportationBill {

	private String customerName;
	private String phoneNumber;
	private int passengers;
	private int noOfDays;
	private int vehicle;
	public int driver;
	private boolean isLoyalty;

	public TransportationBill(String customerName, String phoneNumber, int passengers, int noOfDays, int vehicle,
			int driver,boolean isLoyalty) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.passengers = passengers;
		this.noOfDays = noOfDays;
		this.vehicle = vehicle;
		this.driver = driver;
		this.isLoyalty = isLoyalty;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getVehicle() {
		return vehicle;
	}

	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}

	public int getDriver() {
		return driver;
	}

	public void setDriver(int driver) {
		this.driver = driver;
	}
	public boolean getIsLoyalty() {
		return isLoyalty;
	}

	public void setIsLoyalty(boolean isLoyalty) {
		this.isLoyalty = isLoyalty;
	}

}
