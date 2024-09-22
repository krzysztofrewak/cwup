<?php

use Ppo\Lab07\Vehicles\Bike;
use Ppo\Lab07\Vehicles\Car;
use Ppo\Lab07\Vehicles\Vehicle;

require __DIR__ . "/vendor/autoload.php";

/** @var array<Vehicle> $vehicles */
$vehicles = [
    new Car("DL00001"),
    new Bike("John Doe"),
    new Bike(),
    new Car("DL00002", "Jane Doe"),
    new Car("DLU0001"),
];


foreach ($vehicles as $vehicle) {
    echo $vehicle->identify() . PHP_EOL;
}
