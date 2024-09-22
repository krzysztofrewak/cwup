<?php

namespace Ppo\Lab09\Exceptions;

use Exception;

class ForbiddenCharacterException extends InputException
{
    protected $message = "Provided character :x is forbidden. Please continue.";

    public function __construct(string $letter)
    {
        $message = str_replace(":x", "$letter", $this->message);
        parent::__construct($message);
    }
}
