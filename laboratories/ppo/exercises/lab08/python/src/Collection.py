class Collection:
    def __init__(self, items=[]):
        self.original_items = items
        self.computed_items = items

    def filter(self, function):
        self.computed_items = [item for item in self.computed_items if function(item)]
        return self

    def sort(self, function):
        size = len(self.computed_items) - 1
        for i in range(size):
            for j in range(size - i):
                k = j + 1
                if function(self.computed_items[j], self.computed_items[k]):
                    self.computed_items[j], self.computed_items[k] = self.computed_items[k], self.computed_items[j]
        return self

    def limit(self, limit):
        self.computed_items = self.computed_items[:limit]
        return self

    def get(self):
        return self.computed_items
