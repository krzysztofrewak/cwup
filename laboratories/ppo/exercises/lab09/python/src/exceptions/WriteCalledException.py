from src.exceptions.InputException import InputException


class WriteCalledException(InputException):
    should_break = True

    def __init__(self, input):
      super().__init__(f":w character has been provided. Application ends with: {input}")
