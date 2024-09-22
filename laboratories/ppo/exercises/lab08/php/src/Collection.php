<?php

namespace Ppo\Lab08;

class Collection
{
    protected array $originalItems;
    protected array $computedItems;

    public function __construct(array $items = [])
    {
        $this->originalItems = $items;
        $this->computedItems = $items;
    }

    public function filter(callable $function): static
    {
        $filtered = [];
        foreach ($this->computedItems as $item) {
            if ($function($item)) {
                $filtered[] = $item;
            }
        }

        $this->computedItems = $filtered;

        return $this;
    }

    public function sort(callable $function): static
    {
        $sorted = $this->computedItems;

        $size = count($sorted) - 1;
        for ($i = 0; $i < $size; $i++) {
            for ($j = 0; $j < $size - $i; $j++) {
                $k = $j + 1;
                if ($function($sorted[$j], $sorted[$k])) {
                    list($sorted[$j], $sorted[$k]) = [$sorted[$k], $sorted[$j]];
                }
            }
        }

        $this->computedItems = $sorted;

        return $this;
    }

    public function limit(int $limit): static
    {
        array_splice($this->computedItems, $limit);

        return $this;
    }

    public function get(): array
    {
        return $this->computedItems;
    }
}
