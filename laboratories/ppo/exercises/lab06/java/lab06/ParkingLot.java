package lab06;

import lab06.ParkingVehicles.ParkingVehicle;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ParkingLot {
	protected static final int MAX_AVAILABLE_SPACES = 3;
	protected int occupiedSpaces = 0;

	public void letIn(ParkingVehicle vehicle) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		String name = vehicle.identify();
		String now = formatter.format(LocalDateTime.now());

		if(this.occupiedSpaces >= this.MAX_AVAILABLE_SPACES) {
			System.out.println(name + " is returned at " + now);
			return;
		}

		System.out.println(name + " is entering at " + now);
		this.occupiedSpaces++;
	}
}
