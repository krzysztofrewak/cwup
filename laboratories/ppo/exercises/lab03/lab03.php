<?php

namespace Ppo\Lab03;

class Player
{
    public string $name;
    protected int $healthPoints = 100;

    public function attack(Player $player): int
    {
        $hitPoints = rand(1, 3) * 10;
        $player->takeHit($hitPoints);

        return $hitPoints;
    }

    public function takeHit(int $hitPoints): void
    {
        $this->healthPoints = $this->healthPoints - $hitPoints;
    }

    public function isDead(): bool
    {
        return $this->healthPoints <= 0;
    }
}

function getRandomPlayer(array $players): Player
{
    return $players[array_rand($players)];
}

$luke = new Player();
$luke->name = "Luke Skywalker";

$vader = new Player();
$vader->name = "Darth Vader";

$players = [$luke, $vader];

$round = 1;
$ongoing = true;

while ($ongoing) {
    $attacker = getRandomPlayer($players);
    $target = getRandomPlayer($players);
    $hitPoints = $attacker->attack($target);

    echo "Round $round: {$attacker->name} attacked {$target->name} with $hitPoints points." . PHP_EOL;

    foreach ($players as $player) {
        if ($player->isDead()) {
            echo "{$player->name} died." . PHP_EOL;
            $ongoing = false;
        }
    }

    $round++;
}
