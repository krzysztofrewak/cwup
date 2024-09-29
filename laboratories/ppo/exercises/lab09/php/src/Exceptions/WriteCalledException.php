<?php

namespace Ppo\Lab09\Exceptions;

class WriteCalledException extends InputException
{
    protected $message = ":w character has been provided. Application ends with: :x";
    protected bool $shouldBreak = true;

    public function __construct(string $input)
    {
        $message = str_replace(":x", $input, $this->message);
        parent::__construct($message);
    }
}
