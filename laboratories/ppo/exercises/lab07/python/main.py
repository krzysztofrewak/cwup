from src.vehicles.Bike import Bike
from src.vehicles.Car import Car


vehicles = [
    Car("DL00001"),
    Bike("John Doe"),
    Bike(),
    Car("DL00002", "Jane Doe"),
    Car("DLU0001"),
]

for vehicle in vehicles:
    print(vehicle.identify())
