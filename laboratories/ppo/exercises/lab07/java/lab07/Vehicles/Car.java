package lab07.Vehicles;

public class Car extends Vehicle {
    protected String plates;

    public Car(String plates) {
        super();
        this.plates = plates;
    }

    public Car(String plates, String name) {
        super(name);
        this.plates = plates;
    }

	public String getIdentifier() {
		return this.identifier + " by car [" + this.plates + "]";
	}

	public String getAnonymousIdentifier() {
		return "anonymous by car [" + this.plates + "]";
	}
}
