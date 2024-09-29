from src.exceptions.InputException import InputException


class ForbiddenCharacterException(InputException):
    def __init__(self, letter):
      super().__init__(f"Provided character {letter} is forbidden. Please continue.")
