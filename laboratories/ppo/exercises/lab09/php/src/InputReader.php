<?php

namespace Ppo\Lab09;

use Ppo\Lab09\Exceptions\EmptyStringException;
use Ppo\Lab09\Exceptions\ExitCalledException;
use Ppo\Lab09\Exceptions\ForbiddenCharacterException;
use Ppo\Lab09\Exceptions\MultipleCharactersException;
use Ppo\Lab09\Exceptions\WriteCalledException;

class InputReader
{
    protected string $message = "";

    /**
     * @throws EmptyStringException
     * @throws ExitCalledException
     * @throws ForbiddenCharacterException
     * @throws MultipleCharactersException
     * @throws WriteCalledException
     */
    public function read(): void
    {
        $input = readline("Please type a letter: ");

        if (empty($input)) {
            throw new EmptyStringException();
        }

        if ($input === ":q") {
            throw new ExitCalledException();
        }

        if ($input === ":w") {
            throw new WriteCalledException($this->message);
        }

        if (mb_strlen($input) > 1) {
            throw new MultipleCharactersException();
        }

        if (in_array($input, ["ą", "ć", "ę", "ł", "ń", "ó", "ś", "ź", "ż"])) {
            throw new ForbiddenCharacterException($input);
        }

        $this->message .= strtoupper($input);
    }
}
