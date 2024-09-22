<?php

namespace Ppo\Lab09\Exceptions;

class ExitCalledException extends InputException
{
    protected $message = ":q character has been provided. Application breaks.";
    protected bool $shouldBreak = true;
}
