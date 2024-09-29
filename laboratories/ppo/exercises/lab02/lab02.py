import random


class Player:
    name = None
    healthPoints = 100

    def identify(self):
        return "[" + str(self.healthPoints) + "] " + self.name


def get_random_name():
    names = ["John", "Jim", "Jack", "George", "Kevin"]
    return random.choice(names)


players = []

player = Player()
player.name = get_random_name()
players.append(player)

for player in players:
    print(player.identify())
