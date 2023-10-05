public class Car {
	private String make;
	private String model;

	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}
}
