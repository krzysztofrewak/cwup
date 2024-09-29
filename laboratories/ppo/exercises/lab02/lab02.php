<?php

namespace Ppo\Lab02;

class Player
{
    public string $name;
    public int $healthPoints = 100;

    public function identify(): string
    {
        return "[{$this->healthPoints}] {$this->name}";
    }
}

function getRandomName(): string
{
    $names = ["John", "Jim", "Jack", "George", "Kevin"];

    return $names[rand(0, count($names) - 1)];
}

$players = [];

$player = new Player();
$player->name = getRandomName();
$players[] = $player;

foreach ($players as $player) {
    echo $player->identify() . PHP_EOL;
}
