package lab05;

public class Car {
	protected String name;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.getType() + " " + this.name;
	}

	protected String getType() {
		return "samochód osobowy";
	}
}
