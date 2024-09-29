from src.Handler import Handler
from src.InputReader import InputReader
from src.exceptions.InputException import InputException


on = True
handler = Handler()
reader = InputReader()

while on:
    try:
        reader.read()
    except InputException as exception:
        if handler.handle(exception).should_break():
            on = False
