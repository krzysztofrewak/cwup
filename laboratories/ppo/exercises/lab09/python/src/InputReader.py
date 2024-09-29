from src.exceptions.EmptyStringException import EmptyStringException
from src.exceptions.ExitCalledException import ExitCalledException
from src.exceptions.ForbiddenCharacterException import ForbiddenCharacterException
from src.exceptions.MultipleCharactersException import MultipleCharactersException
from src.exceptions.WriteCalledException import WriteCalledException


class InputReader:
    message = ""

    def read(self):
        input_value = input("Please type a letter: ")

        if not input_value:
            raise EmptyStringException()

        if input_value == ":q":
            raise ExitCalledException()

        if input_value == ":w":
            raise WriteCalledException(self.message)

        if len(input_value) > 1:
            raise MultipleCharactersException()

        if input_value in ["ą", "ć", "ę", "ł", "ń", "ó", "ś", "ź", "ż"]:
            raise ForbiddenCharacterException(input_value)

        self.message += input_value.upper()
