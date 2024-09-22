from src.exceptions.InputException import InputException


class MultipleCharactersException(InputException):
    message = "Providing more than one character is forbidden. Please continue."

    def __init__(self):
      super().__init__(self.message)
