import random


class QuoteAction:
    quotes = [
        "May the Force be with you.",
        "Never tell me the odds!",
        "Do or do not. There is no try.",
        "I find your lack of faith disturbing.",
        "Stay on target.",
        "These aren't the droids you're looking for.",
        "It's a trap!",
        "I have a bad feeling about this.",
    ]

    def get_random_quote(self):
        return random.choice(self.quotes)

    def get_most_popular_quote(self):
        return self.quotes[0]

    def get_by_index(self, id):
        return self.quotes[int(id)]
