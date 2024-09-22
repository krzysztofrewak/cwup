package lab07.Vehicles;

public class Bike extends Vehicle {
    public Bike() {
        super();
    }

    public Bike(String identifier) {
        super(identifier);
    }

	public String getIdentifier() {
		return this.identifier + " by bike";
	}
}
