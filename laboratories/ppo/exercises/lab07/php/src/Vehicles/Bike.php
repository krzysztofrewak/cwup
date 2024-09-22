<?php

namespace Ppo\Lab07\Vehicles;

class Bike extends Vehicle
{
    protected function getIdentifier(): string
    {
        return "{$this->identifier} by bike";
    }
}
