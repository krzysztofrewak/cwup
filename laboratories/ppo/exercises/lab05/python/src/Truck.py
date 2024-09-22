from src.Car import Car


class Truck(Car):
	def __init__(self, name):
		super().__init__(name)

	def _get_type(self):
		return "samochód dostawczy"
