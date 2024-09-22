class Car():
	name = None

	def __init__(self, name):
		self.name = name

	def get_name(self):
		return self._get_type() + " " + self.name

	def _get_type(self):
		return "samochód osobowy"
