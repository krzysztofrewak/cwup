<?php

namespace Ppo\Lab04;

class Dice
{
    public function roll(): int
    {
        return rand(1, 6);
    }
}

class Player
{
    public string $name;

    public function __construct(string $name)
    {
        $this->name = $name;
    }
}

class Game
{
    public array $fields = [];
    public array $players = [];
    public Dice $dice;

    public function prepareGame(): void
    {
        foreach ($this->players as $index => $player) {
            $this->fields[$index] = 0;
        }
    }

    public function run(): void
    {
        $winner = null;

        while ($winner === null) {
            foreach ($this->players as $index => $player) {
                $result = $this->dice->roll();
                $position = $this->fields[$index] += $result;

                if ($position >= 40) {
                    $position = 40;
                }

                echo "$player->name rolled $result. Now is on position $position." . PHP_EOL;

                if ($position >= 40) {
                    echo "$player->name won!" . PHP_EOL;
                    $winner = $player;

                    break;
                }
            }
        }
    }
}

$game = new Game();
$game->dice = new Dice();
$game->players = [
    new Player("Anakin Skywalker"),
    new Player("Obi-Wan Kenobi"),
];

$game->prepareGame();
$game->run();
