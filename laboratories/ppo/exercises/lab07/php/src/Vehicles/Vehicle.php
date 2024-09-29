<?php

namespace Ppo\Lab07\Vehicles;

abstract class Vehicle
{
    protected bool $isAnonymous = false;
    protected ?string $identifier;

    public function __construct(?string $identifier = null)
    {
        $this->identifier = $identifier;

        if (!$identifier) {
            $this->isAnonymous = true;
        }
    }

    final public function identify(): string
    {
        if ($this->isAnonymous) {
            return $this->getAnonymousIdentifier();
        }

        return $this->getIdentifier();
    }

    protected function getAnonymousIdentifier(): string
    {
        return "anonymous by {$this->getClass()}";
    }

    protected function getClass(): string
    {
        return strtolower(array_reverse(explode("\\", static::class))[0]);
    }

    abstract protected function getIdentifier(): string;
}
