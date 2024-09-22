<?php

namespace Ppo\Lab06;

use Ppo\Lab06\ParkingVehicles\ParkingVehicle;

class ParkingLot
{
    protected const MAX_AVAILABLE_SPACES = 3;
    protected int $occupiedSpaces = 0;

    public function letIn(ParkingVehicle $vehicle): void
    {
        $name = $vehicle->identify();
        $now = date("Y-m-d H:i:s");

        if ($this->occupiedSpaces >= static::MAX_AVAILABLE_SPACES) {
            echo "$name is returned at $now" . PHP_EOL;
            return;
        }

        echo "$name is entering at $now" . PHP_EOL;
        $this->occupiedSpaces++;
    }
}
