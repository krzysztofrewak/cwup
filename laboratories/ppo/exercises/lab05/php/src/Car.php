<?php

namespace Ppo\Lab05;

class Car {
    protected string $name;

    public function __construct(string $name)
    {
        $this->name = $name;
    }

    public function getName(): string
    {
        return $this->getType() . " Car.php" . $this->name;
    }

    protected function getType(): string
    {
        return "samochód osobowy";
    }
}
