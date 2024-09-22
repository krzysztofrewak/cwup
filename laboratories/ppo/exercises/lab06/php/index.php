<?php

use Ppo\Lab06\ParkingLot;
use Ppo\Lab06\ParkingVehicles\Bike;
use Ppo\Lab06\ParkingVehicles\Car;
use Ppo\Lab06\ParkingVehicles\ParkingVehicle;
use Ppo\Lab06\ParkingVehicles\Truck;

require __DIR__ . "/vendor/autoload.php";

/** @var array<ParkingVehicle> $vehicles */
$vehicles = [
    new Bike(),
    new Car(),
    new Truck(),
    new Car(),
];

$parkingLot = new ParkingLot();

foreach ($vehicles as $vehicle) {
    $parkingLot->letIn($vehicle);
}
