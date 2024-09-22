class Router:
    def __init__(self, routing):
        self.routing = {route.route: route for route in routing}

    def match(self, route):
        return self.routing[route]
