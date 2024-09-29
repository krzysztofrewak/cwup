from src.Car import Car
from src.Truck import Truck


def get_payment(car):
    if isinstance(car, Truck):
        return 5.0
    else:
        return 4.0


vehicles = [
    Car("Volkswagen Passat"),
    Truck("Volkswagen Transporter"),
]

for vehicle in vehicles:
    print(f"{vehicle.get_name()}: {get_payment(vehicle)}zł")
