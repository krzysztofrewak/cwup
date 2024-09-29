<?php

namespace Ppo\Lab06\ParkingVehicles;

class Bike implements ParkingVehicle
{
    public function identify(): string
    {
        return "bike";
    }
}
