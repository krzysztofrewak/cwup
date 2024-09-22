from src.vehicles.Vehicle import Vehicle


class Car(Vehicle):
    plates = None

    def __init__(self, plates, name = None):
        if name:
           super().__init__(name)
        else:
           super().__init__()

        self.plates = plates

    def _get_identifier(self):
        return self.identifier + " by car [" + self.plates + "]"

    def _get_anonymous_identifier(self):
        return "anonymous by car [" + self.plates + "]"
