<?php

namespace Ppo\Lab05;

class Truck extends Car {
    protected function getType(): string
    {
        return "samochód dostawczy";
    }
}
