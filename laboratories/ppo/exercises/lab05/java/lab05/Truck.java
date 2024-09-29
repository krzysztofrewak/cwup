package lab05;

public class Truck extends Car {
	public Truck(String name) {
		super(name);
	}

	protected String getType() {
		return "samochód dostawczy";
	}
}
