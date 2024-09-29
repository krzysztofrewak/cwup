import random


class Dice:
    def roll(self):
        return random.randint(1, 6)


class Player:
    name = None

    def __init__(self, name):
        self.name = name


class Game:
    fields = []
    players = []
    dice = None

    def prepareGame(self):
        for index, player in enumerate(self.players):
            self.fields.insert(index, 0)

    def run(self):
        winner = None

        while winner is None:
            for index, player in enumerate(self.players):
                result = self.dice.roll()
                position = self.fields[index] = self.fields[index] + result

                if position >= 40:
                    position = 40

                print(
                    player.name
                    + " rolled "
                    + str(result)
                    + ". Now is on position "
                    + str(position)
                    + "."
                )

                if position >= 40:
                    print(player.name + " won!")
                    winner = player
                    break


game = Game()
game.dice = Dice()
game.players = [
    Player("Anakin Skywalker"),
    Player("Obi-Wan Kenobi"),
]

game.prepareGame()
game.run()
