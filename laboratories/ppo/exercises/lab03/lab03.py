import random


class Player:
    name = None
    __health_points = 100

    def attack(self, player):
        hit_points = random.randint(1, 3) * 10
        player.take_hit(hit_points)

        return hit_points

    def take_hit(self, hit_points):
        self.__health_points = self.__health_points - hit_points

    def is_dead(self):
        return self.__health_points <= 0


def get_random_player(players):
    return random.choice(players)


players = []

luke = Player()
luke.name = "Luke Skywalker"
players.append(luke)

vader = Player()
vader.name = "Darth Vader"
players.append(vader)

round = 1
ongoing = True

while ongoing:
    attacker = get_random_player(players)
    target = get_random_player(players)
    hit_points = attacker.attack(target)

    print(
        "Round "
        + str(round)
        + ": "
        + attacker.name
        + " attacked "
        + target.name
        + " with "
        + str(hit_points)
        + " points."
    )

    for player in players:
        if player.is_dead():
            print("Player " + player.name + " died.")
            ongoing = False

    round = round + 1
