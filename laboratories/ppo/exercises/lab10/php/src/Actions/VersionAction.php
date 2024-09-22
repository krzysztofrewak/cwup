<?php

namespace Ppo\Lab10\Actions;

class VersionAction
{
    public function invoke(): string
    {
        return "php: " . PHP_VERSION;
    }
}
