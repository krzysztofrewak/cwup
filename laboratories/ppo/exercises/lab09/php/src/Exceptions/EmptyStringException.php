<?php

namespace Ppo\Lab09\Exceptions;

class EmptyStringException extends InputException
{
    protected $message = "Empty input has been provided. Please continue.";
}
