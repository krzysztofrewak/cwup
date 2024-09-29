from datetime import datetime
from src.parking_vehicles.ParkingVehicle import ParkingVehicle


class ParkingLot():
	MAX_AVAILABLE_SPACES = 3
	occupied_spaces = 0

	def let_in(self, vehicle):
		if not isinstance(vehicle, ParkingVehicle):
			raise Exception("object not implementing ParkingVehicle interface")

		name = vehicle.get_name()
		now = datetime.today().strftime('%Y-%m-%d %H:%M:%S')

		if self.occupied_spaces >= self.MAX_AVAILABLE_SPACES:
			print(name + " is returned at " + now)
			return

		print(name + " is entering at " + now)
		self.occupied_spaces = self.occupied_spaces + 1
