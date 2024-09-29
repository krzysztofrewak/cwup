import lab08.Collection;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String[] words = {
      "Lorem",
      "ipsum",
      "dolor",
      "sit",
      "amet",
      "consectetur",
      "adipiscing",
      "elit",
      "sed",
      "do",
      "eiusmod",
      "tempor",
      "incididunt",
      "ut",
      "labore",
      "et",
      "dolore",
      "magna",
      "aliqua"
     };

    Collection collection = new Collection(words);
    collection.filter(word -> word.length() < 4)
      .sort((a, b) -> a.compareTo(b) > 0)
      .limit(2);

    for(String word : collection.get()) {
      System.out.println(word);
    }
  }
}
