from src.exceptions.InputException import InputException


class EmptyStringException(InputException):
    message = "Empty input has been provided. Please continue."

    def __init__(self):
      super().__init__(self.message)
