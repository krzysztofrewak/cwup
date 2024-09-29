from src.vehicles.Vehicle import Vehicle


class Bike(Vehicle):
    def _get_identifier(self):
        return self.identifier + " by bike"
