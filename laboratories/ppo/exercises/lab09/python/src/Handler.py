from src.exceptions.InputException import InputException


class Handler:
    def __init__(self):
        self.exception = None

    def handle(self, exception):
        self.exception = exception
        print(exception)
        return self

    def should_break(self):
        return isinstance(self.exception, InputException) and self.exception.should_break
