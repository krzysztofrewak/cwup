<?php

use Ppo\Lab08\Collection;

require __DIR__ . "/vendor/autoload.php";

$words = [
    "Lorem",
    "ipsum",
    "dolor",
    "sit",
    "amet",
    "consectetur",
    "adipiscing",
    "elit",
    "sed",
    "do",
    "eiusmod",
    "tempor",
    "incididunt",
    "ut",
    "labore",
    "et",
    "dolore",
    "magna",
    "aliqua"
];

$collection = new Collection($words);

$collection
    ->filter(fn(string $word): bool => strlen($word) < 4)
    ->sort(fn(string $a, string $b): bool => $a > $b)
    ->limit(2);

foreach($collection->get() as $word) {
    echo $word . PHP_EOL;
}
