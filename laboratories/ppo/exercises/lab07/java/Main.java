import lab07.Vehicles.Bike;
import lab07.Vehicles.Car;
import lab07.Vehicles.Vehicle;

public class Main {
  public static void main(String[] args) {
	Vehicle[] vehicles = {
        new Car("DL00001"),
        new Bike("John Doe"),
        new Bike(),
        new Car("DL00002", "Jane Doe"),
        new Car("DLU0001"),
	};

	for(Vehicle vehicle : vehicles) {
		System.out.println(vehicle.identify());
	}
  }
}
