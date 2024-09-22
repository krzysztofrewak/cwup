<?php

use Ppo\Lab10\Actions\QuoteAction;
use Ppo\Lab10\Actions\VersionAction;
use Ppo\Lab10\Route;
use Ppo\Lab10\Router;

require __DIR__ . "/vendor/autoload.php";

$router = new Router([
    new Route("version", VersionAction::class),
    new Route("quote", QuoteAction::class, "getRandomQuote"),
    new Route("quote:popular", QuoteAction::class, "getMostPopularQuote"),
    new Route("quote:id", QuoteAction::class, "getByIndex"),
]);

$route = $router->match($argv[1]);

$reflector = new ReflectionClass($route->action);
$instance = $reflector->newInstance();
$method = $reflector->getMethod($route->method);
$result = $method->invoke($instance, ...array_splice($argv, 2));

echo $result . PHP_EOL;
