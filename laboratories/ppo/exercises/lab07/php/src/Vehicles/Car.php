<?php

namespace Ppo\Lab07\Vehicles;

class Car extends Vehicle
{
    protected string $plates;

    public function __construct(string $plates, ?string $name = null)
    {
        parent::__construct($name);
        $this->plates = $plates;
    }

    protected function getIdentifier(): string
    {
        return "{$this->identifier} by car [{$this->plates}]";
    }

    protected function getAnonymousIdentifier(): string
    {
        return "anonymous by car [{$this->plates}]";
    }
}
