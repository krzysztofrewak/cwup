<?php

use Ppo\Lab05\Car;
use Ppo\Lab05\Truck;

require __DIR__ . "/vendor/autoload.php";

function getPayment(Car $car): float
{
    return match (get_class($car)) {
        Car::class => 4,
        default => 5,
    };
}

/** @var array<Car> $vehicles */
$vehicles = [
    new Car("Volkswagen Passat"),
    new Truck("Volkswagen Transporter"),
];

foreach ($vehicles as $vehicle) {
    echo $vehicle->getName() . ": " . getPayment($vehicle) . "zł" . PHP_EOL;
}
