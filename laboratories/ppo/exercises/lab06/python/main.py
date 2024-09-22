from src.ParkingLot import ParkingLot
from src.parking_vehicles.Bike import Bike
from src.parking_vehicles.Car import Car
from src.parking_vehicles.Truck import Truck


vehicles = [
    Bike(),
    Car(),
    Truck(),
    Car(),
]

parking_lot = ParkingLot()

for vehicle in vehicles:
    parking_lot.let_in(vehicle)
