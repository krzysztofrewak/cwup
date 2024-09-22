<?php

namespace Ppo\Lab06\ParkingVehicles;

class Car implements ParkingVehicle
{
    public function identify(): string
    {
        return "car";
    }
}
