from src.exceptions.InputException import InputException


class ExitCalledException(InputException):
    should_break = True
    message = ":q character has been provided. Application breaks."

    def __init__(self):
      super().__init__(self.message)

