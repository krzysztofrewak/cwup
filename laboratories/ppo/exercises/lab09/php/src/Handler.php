<?php

namespace Ppo\Lab09;

use Ppo\Lab09\Exceptions\InputException;
use Throwable;

class Handler
{
    protected ?Throwable $exception = null;

    public function handle(Throwable $exception): static
    {
        $this->exception = $exception;

        echo $exception->getMessage() . PHP_EOL;

        return $this;
    }

    public function shouldBreak(): bool
    {
        return $this->exception instanceof InputException && $this->exception->shouldBreak();
    }
}
