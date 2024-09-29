package lab08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class Collection {
    private String[] originalItems;
    private String[] computedItems;

    public Collection(String[] items) {
        this.originalItems = Arrays.copyOf(items, items.length);
        this.computedItems = Arrays.copyOf(items, items.length);
    }

    public Collection filter(Predicate<String> function) {
        computedItems = Arrays.stream(computedItems)
                              .filter(function)
                              .toArray(String[]::new);
        return this;
    }

    public Collection sort(BiFunction<String, String, Boolean> function) {
        int size = this.computedItems.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int k = j + 1;
                if (function.apply(this.computedItems[j], this.computedItems[k])) {
                    String temp = this.computedItems[j];
                    this.computedItems[j] = this.computedItems[k];
                    this.computedItems[k] = temp;
                }
            }
        }

        return this;
    }

    public Collection limit(int limit) {
        computedItems = Arrays.copyOf(computedItems, Math.min(limit, computedItems.length));
        return this;
    }

    public String[] get() {
        return computedItems;
    }
}
