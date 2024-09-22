<?php

namespace Ppo\Lab09\Exceptions;

use Exception;

abstract class InputException extends Exception
{
    protected bool $shouldBreak = false;

    public function shouldBreak(): bool
    {
        return $this->shouldBreak;
    }
}
