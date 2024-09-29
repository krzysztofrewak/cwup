import lab06.ParkingLot;
import lab06.ParkingVehicles.Bike;
import lab06.ParkingVehicles.Car;
import lab06.ParkingVehicles.ParkingVehicle;
import lab06.ParkingVehicles.Truck;

public class Main {
  public static void main(String[] args) {
	ParkingVehicle[] vehicles = {
		new Bike(),
		new Car(),
		new Truck(),
		new Car(),
	};

	ParkingLot parkingLot = new ParkingLot();

	for(ParkingVehicle vehicle : vehicles) {
		parkingLot.letIn(vehicle);
	}
  }
}
