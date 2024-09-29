<?php

namespace Ppo\Lab10\Actions;

class QuoteAction
{
    protected array $quotes = [
        "May the Force be with you.",
        "Never tell me the odds!",
        "Do or do not. There is no try.",
        "I find your lack of faith disturbing.",
        "Stay on target.",
        "These aren't the droids you're looking for.",
        "It's a trap!",
        "I have a bad feeling about this.",
    ];

    public function getRandomQuote(): string
    {
        return $this->quotes[array_rand($this->quotes)];
    }

    public function getMostPopularQuote(): string
    {
        return $this->quotes[0];
    }

    public function getByIndex(int $id): string
    {
        return $this->quotes[$id];
    }
}
