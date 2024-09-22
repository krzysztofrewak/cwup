<?php

namespace Ppo\Lab10;

class Route
{
    public function __construct(
        public string $route,
        public string $action,
        public string $method = "invoke"
    ) {}
}
