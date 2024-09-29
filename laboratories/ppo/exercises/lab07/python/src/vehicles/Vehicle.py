class Vehicle():
    is_anonymous = False
    identifier = None

    def __init__(self, identifier=None):
        self.identifier = identifier

        if identifier == None:
            self.is_anonymous = True

    def identify(self):
        if self.is_anonymous:
            return self._get_anonymous_identifier()

        return self._get_identifier()

    def _get_anonymous_identifier(self):
        return "anonymous by " + self.__class__.__name__.lower()

    def _get_identifier(self):
        raise Exception("method not implemented")
