<?php

namespace Ppo\Lab09\Exceptions;

class MultipleCharactersException extends InputException
{
    protected $message = "Providing more than one character is forbidden. Please continue.";
}
