<?php

use Ppo\Lab09\Handler;
use Ppo\Lab09\InputReader;

require __DIR__ . "/vendor/autoload.php";

$on = true;
$handler = new Handler();
$reader = new InputReader();

while($on) {
    try {
        $reader->read();
    } catch (Throwable $exception) {
        if($handler->handle($exception)->shouldBreak()) {
            $on = false;
        }
    }
}
