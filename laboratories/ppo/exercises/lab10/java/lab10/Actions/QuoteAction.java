package lab10.Actions;

public class QuoteAction {
    private static final String[] quotes = {
        "May the Force be with you.",
        "Never tell me the odds!",
        "Do or do not. There is no try.",
        "I find your lack of faith disturbing.",
        "Stay on target.",
        "These aren't the droids you're looking for.",
        "It's a trap!",
        "I have a bad feeling about this."
    };

    public String getRandomQuote(String[] parameters) {
        return this.quotes[(int) (Math.random() * this.quotes.length)];
    }

    public String getMostPopularQuote(String[] parameters) {
        return this.quotes[0];
    }

    public String getByIndex(String[] parameters) {
        return this.quotes[Integer.parseInt(parameters[0])];
    }
}
