<?php

namespace Ppo\Lab10;

class Router
{
    /** @var array<Route>  */
    protected array $routing;

    public function __construct(array $routing)
    {
        $this->routing = array_combine(
            array_map(fn(Route $route): string => $route->route, $routing),
            $routing,
        );
    }

    public function match(string $route): Route
    {
        return $this->routing[$route];
    }
}
